package com.proxym.auth0.model;

public class ApplicationDetails {
    private String access_token;
    private String scope;
    private float expires_in;
    private String token_type;

    public ApplicationDetails() {
    }

    public ApplicationDetails(String access_token, String scope, float expires_in, String token_type) {
        this.access_token = access_token;
        this.scope = scope;
        this.expires_in = expires_in;
        this.token_type = token_type;
    }
// Getter Methods

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    // Setter Methods

    public float getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(float expires_in) {
        this.expires_in = expires_in;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

}
