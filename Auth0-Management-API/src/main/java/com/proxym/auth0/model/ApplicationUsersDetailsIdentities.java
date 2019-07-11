package com.proxym.auth0.model;

public class ApplicationUsersDetailsIdentities {

    private String isSocial;

    private String user_id;

    private String provider;

    private String connection;

    public ApplicationUsersDetailsIdentities() {
    }

    public ApplicationUsersDetailsIdentities(String isSocial, String user_id, String provider, String connection) {
        this.isSocial = isSocial;
        this.user_id = user_id;
        this.provider = provider;
        this.connection = connection;
    }

    public String getIsSocial() {
        return isSocial;
    }

    public void setIsSocial(String isSocial) {
        this.isSocial = isSocial;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

}
