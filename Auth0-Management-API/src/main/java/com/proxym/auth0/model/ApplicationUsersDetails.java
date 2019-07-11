package com.proxym.auth0.model;

public class ApplicationUsersDetails {
    private String last_ip;

    private String email_verified;

    private String last_login;

    private String created_at;

    private String picture;

    private String logins_count;

    private ApplicationUsersDetailsIdentities[] identities;

    private String updated_at;

    private String user_id;

    private String name;

    private String nickname;

    private String email;

    private String last_password_reset;

    public ApplicationUsersDetails() {
    }

    public ApplicationUsersDetails(String last_ip, String email_verified, String last_login, String created_at, String picture, String logins_count, ApplicationUsersDetailsIdentities[] identities, String updated_at, String user_id, String name, String nickname, String email, String last_password_reset) {
        this.last_ip = last_ip;
        this.email_verified = email_verified;
        this.last_login = last_login;
        this.created_at = created_at;
        this.picture = picture;
        this.logins_count = logins_count;
        this.identities = identities;
        this.updated_at = updated_at;
        this.user_id = user_id;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.last_password_reset = last_password_reset;
    }

    public String getLast_ip() {
        return last_ip;
    }

    public void setLast_ip(String last_ip) {
        this.last_ip = last_ip;
    }

    public String getEmail_verified() {
        return email_verified;
    }

    public void setEmail_verified(String email_verified) {
        this.email_verified = email_verified;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getLogins_count() {
        return logins_count;
    }

    public void setLogins_count(String logins_count) {
        this.logins_count = logins_count;
    }

    public ApplicationUsersDetailsIdentities[] getIdentities() {
        return identities;
    }

    public void setIdentities(ApplicationUsersDetailsIdentities[] identities) {
        this.identities = identities;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLast_password_reset() {
        return last_password_reset;
    }

    public void setLast_password_reset(String last_password_reset) {
        this.last_password_reset = last_password_reset;
    }
}
