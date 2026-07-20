package com.keystone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keystone.entity.Site;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {

    List<Site> findByCustomerId(Long customerId);
    
    long count();

}