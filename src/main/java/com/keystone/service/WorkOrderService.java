package com.keystone.service;

import java.util.List;

import com.keystone.dto.WorkOrderRequest;
import com.keystone.dto.WorkOrderResponse;
import com.keystone.dto.WorkOrderStatusHistoryResponse;
import com.keystone.enums.WorkOrderStatus;
import com.keystone.dto.TimeLogRequest;
import com.keystone.dto.TimeLogResponse;
import com.keystone.dto.PartUsageRequest;
import com.keystone.dto.PartUsageResponse;

public interface WorkOrderService {

    WorkOrderResponse createWorkOrder(WorkOrderRequest request);

    List<WorkOrderResponse> getAllWorkOrders();

    WorkOrderResponse getWorkOrderById(Long id);

    List<WorkOrderResponse> getWorkOrdersBySite(Long siteId);

    List<WorkOrderResponse> getWorkOrdersByTechnician(Long technicianId);

    List<WorkOrderResponse> getWorkOrdersByStatus(WorkOrderStatus status);

    WorkOrderResponse updateWorkOrder(Long id, WorkOrderRequest request);

    void deleteWorkOrder(Long id);
    
    
    WorkOrderResponse assignTechnician(Long workOrderId, Long technicianId);

    WorkOrderResponse removeTechnician(Long workOrderId);
    
    WorkOrderResponse updateWorkOrderStatus(
            Long workOrderId,
            WorkOrderStatus status);
    
    List<WorkOrderStatusHistoryResponse> getStatusHistory(Long workOrderId);
    
    List<TimeLogResponse> getTimeLogs(Long workOrderId);

    TimeLogResponse addTimeLog(Long workOrderId, TimeLogRequest request);
    
    PartUsageResponse addPartUsage(Long workOrderId, PartUsageRequest request);

    List<PartUsageResponse> getPartUsage(Long workOrderId);
    
    List<WorkOrderResponse> getSlaBreachedWorkOrders();
    
    List<WorkOrderResponse> getWorkOrdersByCustomer(Long customerId);
}