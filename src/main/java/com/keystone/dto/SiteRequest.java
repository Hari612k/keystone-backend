package com.keystone.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SiteRequest {

    @NotBlank(message = "Site name is required")
    private String siteName;

    private String address;

    private String city;

    private String state;

    private String zipCode;

    @NotNull(message = "Customer ID is required")
    private Long customerId;

    public SiteRequest() {
    }

    public SiteRequest(String siteName, String address, String city,
                       String state, String zipCode, Long customerId) {
        this.siteName = siteName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.customerId = customerId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}