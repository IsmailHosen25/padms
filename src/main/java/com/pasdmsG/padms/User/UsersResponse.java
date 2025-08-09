package com.pasdmsG.padms.User;

import java.time.LocalDateTime;

public class UsersResponse {
    private String name;
    private Integer phone;
    private String role;
    private String address;
    private LocalDateTime createdAt;

    public UsersResponse() {
    }

    public UsersResponse(String name, Integer phone, String role, String address, LocalDateTime createdAt) {
        this.name = name;
        this.phone = phone;
        this.role = role;
        this.address = address;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
