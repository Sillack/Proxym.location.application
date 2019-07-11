package com.proxym.auth0.model;

public class UserLoginDetails {
    private String access_token;
    private String id_token;
    private String scope;
    private float expires_in;
    private String token_type;

    public UserLoginDetails() {
    }

    public UserLoginDetails(String access_token, String id_token, String scope, float expires_in, String token_type) {
        this.access_token = access_token;
        this.id_token = id_token;
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

    public String getId_token() {
        return id_token;
    }

    public void setId_token(String id_token) {
        this.id_token = id_token;
    }

    public String getScope() {
        return scope;
    }

    // Setter Methods

    public void setScope(String scope) {
        this.scope = scope;
    }

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
