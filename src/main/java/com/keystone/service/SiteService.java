package com.keystone.service;

import java.util.List;

import com.keystone.dto.SiteRequest;
import com.keystone.dto.SiteResponse;

public interface SiteService {

    SiteResponse createSite(SiteRequest request);

    List<SiteResponse> getAllSites();

    SiteResponse getSiteById(Long id);

    List<SiteResponse> getSitesByCustomer(Long customerId);

    SiteResponse updateSite(Long id, SiteRequest request);

    void deleteSite(Long id);
}