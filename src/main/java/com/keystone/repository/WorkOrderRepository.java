package com.keystone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keystone.entity.WorkOrder;
import com.keystone.enums.WorkOrderStatus;
import java.time.LocalDateTime;

@Repository
public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long> {

    List<WorkOrder> findBySiteId(Long siteId);

    List<WorkOrder> findByTechnicianId(Long technicianId);

    List<WorkOrder> findByStatus(WorkOrderStatus status);
    
    List<WorkOrder> findBySlaDeadlineBeforeAndSlaBreachedFalse(
            LocalDateTime now);
    
    List<WorkOrder> findBySlaBreachedTrue();
    
    long countBySlaBreachedTrue();
    
    List<WorkOrder> findBySiteCustomerId(Long customerId);

}