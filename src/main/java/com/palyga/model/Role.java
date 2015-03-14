package com.palyga.model;

/**
 * Created by Василь on 27.02.2015.
 */

public enum Role {
    CUSTOMER("Customer"),MANAGER("Manager"),ADMIN("Admin");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
