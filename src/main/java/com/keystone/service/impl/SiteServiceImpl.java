package com.keystone.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.keystone.dto.SiteRequest;
import com.keystone.dto.SiteResponse;
import com.keystone.entity.Customer;
import com.keystone.entity.Site;
import com.keystone.exception.ResourceNotFoundException;
import com.keystone.repository.CustomerRepository;
import com.keystone.repository.SiteRepository;
import com.keystone.service.SiteService;

@Service
public class SiteServiceImpl implements SiteService {

    private final SiteRepository siteRepository;
    private final CustomerRepository customerRepository;

    public SiteServiceImpl(SiteRepository siteRepository,
                           CustomerRepository customerRepository) {
        this.siteRepository = siteRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public SiteResponse createSite(SiteRequest request) {

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer not found"));

        Site site = new Site();

        site.setSiteName(request.getSiteName());
        site.setAddress(request.getAddress());
        site.setCity(request.getCity());
        site.setState(request.getState());
        site.setZipCode(request.getZipCode());
        site.setCustomer(customer);

        Site saved = siteRepository.save(site);

        return mapToResponse(saved);
    }

    @Override
    public List<SiteResponse> getAllSites() {

        return siteRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public SiteResponse getSiteById(Long id) {

        Site site = siteRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Site not found"));

        return mapToResponse(site);
    }

    @Override
    public List<SiteResponse> getSitesByCustomer(Long customerId) {

        return siteRepository.findByCustomerId(customerId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public SiteResponse updateSite(Long id, SiteRequest request) {

        Site site = siteRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Site not found"));

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer not found"));

        site.setSiteName(request.getSiteName());
        site.setAddress(request.getAddress());
        site.setCity(request.getCity());
        site.setState(request.getState());
        site.setZipCode(request.getZipCode());
        site.setCustomer(customer);

        Site updated = siteRepository.save(site);

        return mapToResponse(updated);
    }

    @Override
    public void deleteSite(Long id) {

        Site site = siteRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Site not found"));

        siteRepository.delete(site);
    }

    private SiteResponse mapToResponse(Site site) {

        return new SiteResponse(
                site.getId(),
                site.getSiteName(),
                site.getAddress(),
                site.getCity(),
                site.getState(),
                site.getZipCode(),
                site.getCustomer().getId(),
                site.getCustomer().getName()
        );
    }
}