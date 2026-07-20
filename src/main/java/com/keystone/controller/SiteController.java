package com.keystone.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.keystone.dto.SiteRequest;
import com.keystone.dto.SiteResponse;
import com.keystone.service.SiteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/sites")
public class SiteController {

    private final SiteService siteService;

    public SiteController(SiteService siteService) {
        this.siteService = siteService;
    }

    @PostMapping
    public ResponseEntity<SiteResponse> createSite(
            @Valid @RequestBody SiteRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(siteService.createSite(request));
    }

    @GetMapping
    public ResponseEntity<List<SiteResponse>> getAllSites() {

        return ResponseEntity.ok(siteService.getAllSites());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SiteResponse> getSiteById(
            @PathVariable Long id) {

        return ResponseEntity.ok(siteService.getSiteById(id));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<SiteResponse>> getSitesByCustomer(
            @PathVariable Long customerId) {

        return ResponseEntity.ok(siteService.getSitesByCustomer(customerId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SiteResponse> updateSite(
            @PathVariable Long id,
            @Valid @RequestBody SiteRequest request) {

        return ResponseEntity.ok(siteService.updateSite(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSite(
            @PathVariable Long id) {

        siteService.deleteSite(id);

        return ResponseEntity.ok("Site deleted successfully");
    }
}