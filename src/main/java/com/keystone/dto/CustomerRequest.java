package com.keystone.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CustomerRequest {

    @NotBlank(message = "Customer name is required")
    private String name;

    @Email(message = "Invalid email")
    private String email;

    private String phone;

    private String companyName;

    private String address;

    public CustomerRequest() {
    }

    public CustomerRequest(String name, String email, String phone,
                           String companyName, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.companyName = companyName;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}