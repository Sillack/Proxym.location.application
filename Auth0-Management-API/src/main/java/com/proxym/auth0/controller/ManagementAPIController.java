package com.proxym.auth0.controller;

import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.UrlJwkProvider;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proxym.auth0.model.*;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.security.interfaces.RSAPublicKey;
import java.util.Date;
import java.util.List;

@RestController
//@RequestMapping("Proxym")
public class ManagementAPIController {

    private ResponseEntity<List<ApplicationUsersDetails>> entity_application_users = null;
    private ResponseEntity<UserDetails> entity_user_details;
    private String token_user;
    private String idtoken_user;
    private String token_application;
    private ApplicationUsersDetails create_user;


    @Value("${application.client.id}")
    private String clientId;
    @Value("${application.client.secret}")
    private String clientSecret;
    @Value("${application.grant.Type.List}")
    private List<String> grantTypeList;
    @Value("${application.audience}")
    private String applicationTokenAudience;
    @Value("${application.token.provider}")
    private String applicationTokenProviderUrl;
    @Value("${user.login.audience}")
    private String userLoginAudience;
    @Value("${user.scopes}")
    private String userScopes;
    @Value("${user.connections}")
    private List<String> userConnections;
    @Value("${application.url.jwk.provider}")
    private String urlJwkProvider;
    @Value("${application.token.issuer}")
    private String tokenIssuer;

    @RequestMapping(value = "/Application/token")
    public ApplicationDetails getAccessTokenForApplication() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("content-type", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> httpEntity = new HttpEntity<Object>("{\"client_id\":" + "\"" + clientId + "\"" + ",\"client_secret\":" + "\"" + clientSecret + "\",\"audience\":" + "\"" + applicationTokenAudience + "\",\"grant_type\":" + "\"" + grantTypeList.get(0) + "\"}",
                requestHeaders);
        ResponseEntity<ApplicationDetails> response = restTemplate.postForEntity(applicationTokenProviderUrl,
                httpEntity,
                ApplicationDetails.class);
        this.token_application = response.getBody().getAccess_token();

        return response.getBody();
    }


    @RequestMapping(value = "/Application/user/login")
    @ResponseBody
    public ResponseEntity LoginUser() {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("content-type", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> httpEntity = new HttpEntity<Object>("{\"grant_type\":\"" + grantTypeList.get(1) + "\",\"username\":\"anis@gmail.com\",\"password\":\"Anis.1995\",\"audience\":\"" + userLoginAudience + "\",\"scope\":\"" + userScopes + "\",\"client_id\":\"" + clientId + "\",\"client_secret\":\"" + clientSecret + "\",\"connection\":\"" + userConnections.get(0) + "\"}",
                requestHeaders);
        ResponseEntity<UserLoginDetails> response = restTemplate.exchange(applicationTokenProviderUrl,
                HttpMethod.POST, httpEntity,
                UserLoginDetails.class);

        //HttpHeaders hty = new HttpHeaders();
        //hty.add("token",getAccessTokenForApplication().getAccess_token());

            /*return ResponseEntity.ok()
                    .headers(hty)
                    .body(response.getBody());*/
        return response;


    }

    @RequestMapping("/Application/user/create")
    public ResponseEntity CreateUser() throws Exception {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("content-type", MediaType.APPLICATION_JSON_VALUE);
        requestHeaders.add("authorization", "Bearer " + getAccessTokenForApplication().getAccess_token());
        HttpEntity<?> httpEntity = new HttpEntity<Object>("{\"email\":\"anis8.ouragini@ymail.com\",\"password\":\"Google.com12\",\"connection\":\"" + userConnections.get(0) + "\",\"email_verified\": false}",
                requestHeaders);
        ResponseEntity<ApplicationUsersDetails> response_entity = restTemplate.exchange("https://dev-ay9wi6hz.auth0.com/api/v2/users",
                HttpMethod.POST, httpEntity,
                ApplicationUsersDetails.class);
            /* this.create_user = new ApplicationUsersDetails(response_entity.getBody().getLast_ip(),
                    response_entity.getBody().getEmail_verified(),response_entity.getBody().getLast_login(),
                    response_entity.getBody().getCreated_at(),response_entity.getBody().getPicture(),
                    response_entity.getBody().getLogins_count(),
                    response_entity.getBody().getIdentities(),response_entity.getBody().getUpdated_at(),
                    response_entity.getBody().getUser_id(),response_entity.getBody().getName(),
                    response_entity.getBody().getNickname(),response_entity.getBody().getEmail(),
                    response_entity.getBody().getLast_password_reset());*/
        return response_entity;
    }


    @RequestMapping(value = "/Application/users")
    public List<ApplicationUsersDetails> getAllApplicationUsers() throws Exception {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", MediaType.APPLICATION_JSON_VALUE);
        headers.add("cache-control", "no-cache");
        headers.add("Authorization", "Bearer " + this.token_application);
        entity_application_users = restTemplate.exchange("https://dev-ay9wi6hz.auth0.com/api/v2/users",
                HttpMethod.GET, new HttpEntity<Object>(headers),
                new ParameterizedTypeReference<List<ApplicationUsersDetails>>() {
                });
        return entity_application_users.getBody();

    }


    @RequestMapping("/Application/user/profil")
    public UserDetails findAllUsersPasswordGrant() throws Exception {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", MediaType.APPLICATION_JSON_VALUE);
        headers.add("cache-control", "no-cache");
        headers.add("Authorization", "Bearer " + token_user);
        entity_user_details = restTemplate.exchange(userLoginAudience,
                HttpMethod.GET, new HttpEntity<Object>(headers),
                new ParameterizedTypeReference<UserDetails>() {
                });
        return entity_user_details.getBody();

    }


    @RequestMapping(method = RequestMethod.GET, value = "/verify")
    public String verifySignature(@RequestParam String token) throws Exception {

        // String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IlJqQXhSa1UyUVRSQlFqazNOMEpCTVVNM09ERTNNamRFTXpnek4wWkVPVFkxUkVJMFJrVXlSQSJ9.eyJpc3MiOiJodHRwczovL2Rldi1heTl3aTZoei5hdXRoMC5jb20vIiwic3ViIjoiU1ZYOU42cUR2ZXE2cUJoMDVqY3FJeXFZaFN0YTJFd3ZAY2xpZW50cyIsImF1ZCI6Imh0dHBzOi8vZGV2LWF5OXdpNmh6LmF1dGgwLmNvbS9hcGkvdjIvIiwiaWF0IjoxNTYyMzI0MTMxLCJleHAiOjE1NjI0MTA1MzEsImF6cCI6IlNWWDlONnFEdmVxNnFCaDA1amNxSXlxWWhTdGEyRXd2Iiwic2NvcGUiOiJyZWFkOnVzZXJzIHVwZGF0ZTp1c2VycyBkZWxldGU6dXNlcnMgY3JlYXRlOnVzZXJzIHJlYWQ6dXNlcnNfYXBwX21ldGFkYXRhIHVwZGF0ZTp1c2Vyc19hcHBfbWV0YWRhdGEgZGVsZXRlOnVzZXJzX2FwcF9tZXRhZGF0YSBjcmVhdGU6dXNlcnNfYXBwX21ldGFkYXRhIHJlYWQ6dXNlcl9pZHBfdG9rZW5zIiwiZ3R5IjoiY2xpZW50LWNyZWRlbnRpYWxzIn0.OkJOwYAKJp21Y_yDKc9DsGel042blWLHC2MYGfBxDve5G7QGCKG_5w9_TzL_7iPhmchoGFVuG6tS2_-YfXFMCpFONrFmVOzV3j-M-mEr-_e8ccaKwr0CAPg46cylqpPI0sTGpIUeSXAPxVmSYiteNquVCU4vuHpyEWISKfpPFW0JQYTvj6Uepyao-60ZLZTiGbkve1TWhkr-Rc2qitP-s5m1CCBD_yEMyFahkaLNd4C-eRSeiwlb1k2r-XkwNjz8ojiL6MP_f2wbdGYfHy5g6jA0KlPEwLuWAhUg1ZHkptLJWU7csW3kyaLuRqtW45NjRpE0iJbP4tdfSTcaxxod5Q";
        DecodedJWT decodedJwt = JWT.decode(token);
        String kid = decodedJwt.getKeyId();
        //Getting from https://dev-ay9wi6hz.auth0.com/.well-known/jwks.json ,the public key by parsing the JWKS
        JwkProvider jwkProvider = new UrlJwkProvider("https://dev-ay9wi6hz.auth0.com/.well-known/jwks.json");


        Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) jwkProvider.get(kid).getPublicKey(), null);

        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("https://dev-ay9wi6hz.auth0.com/") // Token issuer configured in my API
                .build(); //Reusable verifier instance
        return verifier.verify(token).getSignature();


    }


    public boolean verifyTokenExpiration(String jwtToken) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String[] split_string = jwtToken.split("\\."); // decode jwt
        String base64EncodedBody = split_string[1];

        Base64 base64Url = new Base64(true);

        String body = new String(base64Url.decode(base64EncodedBody));

        ApiClaimsDetails claims = mapper.readValue(body, ApiClaimsDetails.class);

        //validate expiration data
        long dateeexpiration = Long.parseLong(claims.getExp());
        Date currentDate = new Date();
        long nowtimestamp = currentDate.getTime() / 1000;

        if (nowtimestamp > dateeexpiration) return false;
        else return true;

    }

    @RequestMapping("/test")
    public String test() {
        return "test test"
                ;
    }


}
