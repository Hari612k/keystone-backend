package com.keystone.dto;

public class SiteResponse {

    private Long id;
    private String siteName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private Long customerId;
    private String customerName;

    public SiteResponse() {
    }

    public SiteResponse(Long id, String siteName, String address,
                        String city, String state, String zipCode,
                        Long customerId, String customerName) {
        this.id = id;
        this.siteName = siteName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}