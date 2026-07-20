package com.keystone.service;

import java.util.List;

import com.keystone.dto.CustomerRequest;
import com.keystone.dto.CustomerResponse;

public interface CustomerService {

    CustomerResponse createCustomer(CustomerRequest request);

    List<CustomerResponse> getAllCustomers();

    CustomerResponse getCustomerById(Long id);

    CustomerResponse updateCustomer(Long id, CustomerRequest request);

    void deleteCustomer(Long id);
}