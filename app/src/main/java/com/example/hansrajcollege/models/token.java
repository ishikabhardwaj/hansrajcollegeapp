package com.example.hansrajcollege.models;

public class token {
    private String refresh,access;

    public token(String refresh, String access) {
        this.refresh = refresh;
        this.access = access;
    }

    public String getRefresh() {
        return refresh;
    }

    public String getAccess() {
        return access;
    }
}
