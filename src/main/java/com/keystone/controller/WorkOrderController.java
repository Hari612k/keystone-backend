package com.keystone.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.keystone.dto.WorkOrderRequest;
import com.keystone.dto.WorkOrderResponse;
import com.keystone.dto.WorkOrderStatusHistoryResponse;
import com.keystone.enums.WorkOrderStatus;
import com.keystone.service.WorkOrderService;
import com.keystone.dto.TimeLogRequest;
import com.keystone.dto.TimeLogResponse;
import com.keystone.dto.PartUsageRequest;
import com.keystone.dto.PartUsageResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/work-orders")
public class WorkOrderController {

    private final WorkOrderService workOrderService;

    public WorkOrderController(WorkOrderService workOrderService) {
        this.workOrderService = workOrderService;
    }

    @PostMapping
    public ResponseEntity<WorkOrderResponse> createWorkOrder(
            @Valid @RequestBody WorkOrderRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(workOrderService.createWorkOrder(request));
    }

    @GetMapping
    public ResponseEntity<List<WorkOrderResponse>> getAllWorkOrders() {

        return ResponseEntity.ok(workOrderService.getAllWorkOrders());
    }
    
    @GetMapping("/sla-breached")
    public ResponseEntity<List<WorkOrderResponse>> getSlaBreachedWorkOrders() {

        return ResponseEntity.ok(
                workOrderService.getSlaBreachedWorkOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkOrderResponse> getWorkOrderById(
            @PathVariable Long id) {

        return ResponseEntity.ok(workOrderService.getWorkOrderById(id));
    }

    @GetMapping("/site/{siteId}")
    public ResponseEntity<List<WorkOrderResponse>> getWorkOrdersBySite(
            @PathVariable Long siteId) {

        return ResponseEntity.ok(workOrderService.getWorkOrdersBySite(siteId));
    }

    @GetMapping("/technician/{technicianId}")
    public ResponseEntity<List<WorkOrderResponse>> getWorkOrdersByTechnician(
            @PathVariable Long technicianId) {

        return ResponseEntity.ok(workOrderService.getWorkOrdersByTechnician(technicianId));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<WorkOrderResponse>> getWorkOrdersByStatus(
            @PathVariable WorkOrderStatus status) {

        return ResponseEntity.ok(workOrderService.getWorkOrdersByStatus(status));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkOrderResponse> updateWorkOrder(
            @PathVariable Long id,
            @Valid @RequestBody WorkOrderRequest request) {

        return ResponseEntity.ok(workOrderService.updateWorkOrder(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWorkOrder(
            @PathVariable Long id) {

        workOrderService.deleteWorkOrder(id);

        return ResponseEntity.ok("Work Order deleted successfully");
    }
    
    @PutMapping("/{workOrderId}/assign/{technicianId}")
    public ResponseEntity<WorkOrderResponse> assignTechnician(
            @PathVariable Long workOrderId,
            @PathVariable Long technicianId) {

        return ResponseEntity.ok(
                workOrderService.assignTechnician(workOrderId, technicianId));
    }
    
    @PutMapping("/{workOrderId}/unassign")
    public ResponseEntity<WorkOrderResponse> removeTechnician(
            @PathVariable Long workOrderId) {

        return ResponseEntity.ok(
                workOrderService.removeTechnician(workOrderId));
    }
    
    @PutMapping("/{workOrderId}/status")
    public ResponseEntity<WorkOrderResponse> updateWorkOrderStatus(
            @PathVariable Long workOrderId,
            @RequestParam WorkOrderStatus status) {

        return ResponseEntity.ok(
                workOrderService.updateWorkOrderStatus(workOrderId, status));
    }
    
    @GetMapping("/{workOrderId}/history")
    public ResponseEntity<List<WorkOrderStatusHistoryResponse>> getStatusHistory(
            @PathVariable Long workOrderId) {

        return ResponseEntity.ok(
                workOrderService.getStatusHistory(workOrderId));
    }
    
    @PostMapping("/{workOrderId}/time-logs")
    public ResponseEntity<TimeLogResponse> addTimeLog(
            @PathVariable Long workOrderId,
            @RequestBody TimeLogRequest request) {

        return ResponseEntity.ok(
                workOrderService.addTimeLog(workOrderId, request));
    }
    
    @GetMapping("/{workOrderId}/time-logs")
    public ResponseEntity<List<TimeLogResponse>> getTimeLogs(
            @PathVariable Long workOrderId) {

        return ResponseEntity.ok(
                workOrderService.getTimeLogs(workOrderId));
    }
    
    @PostMapping("/{workOrderId}/parts")
    public ResponseEntity<PartUsageResponse> addPartUsage(
            @PathVariable Long workOrderId,
            @RequestBody PartUsageRequest request) {

        return ResponseEntity.ok(
                workOrderService.addPartUsage(workOrderId, request));
    }
    
    @GetMapping("/{workOrderId}/parts")
    public ResponseEntity<List<PartUsageResponse>> getPartUsage(
            @PathVariable Long workOrderId) {

        return ResponseEntity.ok(
                workOrderService.getPartUsage(workOrderId));
    }
    
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<WorkOrderResponse>> getCustomerWorkOrders(
            @PathVariable Long customerId) {

        return ResponseEntity.ok(
                workOrderService.getWorkOrdersByCustomer(customerId));
    }
    
   
}