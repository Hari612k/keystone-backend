package com.keystone.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.keystone.dto.WorkOrderRequest;
import com.keystone.dto.WorkOrderResponse;
import com.keystone.dto.WorkOrderStatusHistoryResponse;
import com.keystone.entity.Site;
import com.keystone.entity.User;
import com.keystone.entity.WorkOrder;
import com.keystone.enums.WorkOrderStatus;
import com.keystone.exception.ResourceNotFoundException;
import com.keystone.repository.SiteRepository;
import com.keystone.repository.UserRepository;
import com.keystone.repository.WorkOrderRepository;
import com.keystone.service.WorkOrderService;
import com.keystone.repository.WorkOrderStatusHistoryRepository;
import java.time.LocalDateTime;
import com.keystone.entity.WorkOrderStatusHistory;
import com.keystone.entity.TimeLog;
import com.keystone.repository.TimeLogRepository;
import com.keystone.dto.TimeLogRequest;
import com.keystone.dto.TimeLogResponse;
import com.keystone.dto.PartUsageRequest;
import com.keystone.dto.PartUsageResponse;
import com.keystone.entity.PartUsage;
import com.keystone.repository.PartUsageRepository;

@Service
public class WorkOrderServiceImpl implements WorkOrderService {

    private final WorkOrderRepository workOrderRepository;
    private final SiteRepository siteRepository;
    private final UserRepository userRepository;
    private final WorkOrderStatusHistoryRepository historyRepository;
    private final TimeLogRepository timeLogRepository;
    private final PartUsageRepository partUsageRepository;

    public WorkOrderServiceImpl(
            WorkOrderRepository workOrderRepository,
            SiteRepository siteRepository,
            UserRepository userRepository,
            WorkOrderStatusHistoryRepository historyRepository,
            TimeLogRepository timeLogRepository,
            PartUsageRepository partUsageRepository) {

        this.workOrderRepository = workOrderRepository;
        this.siteRepository = siteRepository;
        this.userRepository = userRepository;
        this.historyRepository = historyRepository;
        this.timeLogRepository = timeLogRepository;
        this.partUsageRepository = partUsageRepository;
    }

    @Override
    public WorkOrderResponse createWorkOrder(WorkOrderRequest request) {

        Site site = siteRepository.findById(request.getSiteId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Site not found"));

        User technician = null;

        if (request.getTechnicianId() != null) {
            technician = userRepository.findById(request.getTechnicianId())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Technician not found"));
        }

        WorkOrder workOrder = new WorkOrder();

        workOrder.setTitle(request.getTitle());
        workOrder.setDescription(request.getDescription());
        workOrder.setPriority(request.getPriority());
        workOrder.setStatus(WorkOrderStatus.NEW);
        workOrder.setSite(site);
        workOrder.setTechnician(technician);
        
        workOrder.setSlaDeadline(LocalDateTime.now().plusHours(24));
        workOrder.setSlaBreached(false);

        WorkOrder saved = workOrderRepository.save(workOrder);

        return mapToResponse(saved);
    }

    @Override
    public List<WorkOrderResponse> getAllWorkOrders() {

        return workOrderRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public WorkOrderResponse getWorkOrderById(Long id) {

        WorkOrder workOrder = workOrderRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Work Order not found"));

        return mapToResponse(workOrder);
    }

    @Override
    public List<WorkOrderResponse> getWorkOrdersBySite(Long siteId) {

        return workOrderRepository.findBySiteId(siteId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<WorkOrderResponse> getWorkOrdersByTechnician(Long technicianId) {

        return workOrderRepository.findByTechnicianId(technicianId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<WorkOrderResponse> getWorkOrdersByStatus(
            com.keystone.enums.WorkOrderStatus status) {

        return workOrderRepository.findByStatus(status)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public WorkOrderResponse updateWorkOrder(Long id,
                                             WorkOrderRequest request) {

        WorkOrder workOrder = workOrderRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Work Order not found"));

        Site site = siteRepository.findById(request.getSiteId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Site not found"));

        User technician = null;

        if (request.getTechnicianId() != null) {
            technician = userRepository.findById(request.getTechnicianId())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Technician not found"));
        }

        workOrder.setTitle(request.getTitle());
        workOrder.setDescription(request.getDescription());
        workOrder.setPriority(request.getPriority());
        workOrder.setStatus(request.getStatus());
        workOrder.setSite(site);
        workOrder.setTechnician(technician);

        WorkOrder updated = workOrderRepository.save(workOrder);

        return mapToResponse(updated);
    }

    @Override
    public void deleteWorkOrder(Long id) {

        WorkOrder workOrder = workOrderRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Work Order not found"));

        workOrderRepository.delete(workOrder);
    }

    private WorkOrderResponse mapToResponse(WorkOrder workOrder) {

        Long technicianId = null;
        String technicianName = null;

        if (workOrder.getTechnician() != null) {
            technicianId = workOrder.getTechnician().getId();
            technicianName = workOrder.getTechnician().getFullName();
        }

        return new WorkOrderResponse(
                workOrder.getId(),
                workOrder.getTitle(),
                workOrder.getDescription(),
                workOrder.getPriority(),
                workOrder.getStatus(),
                workOrder.getSite().getId(),
                workOrder.getSite().getSiteName(),
                technicianId,
                technicianName
        );
    }
    
    @Override
    public WorkOrderResponse assignTechnician(Long workOrderId, Long technicianId) {

        WorkOrder workOrder = workOrderRepository.findById(workOrderId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Work Order not found"));
        
        if (workOrder.getStatus() == WorkOrderStatus.CLOSED
                || workOrder.getStatus() == WorkOrderStatus.CANCELLED) {

            throw new IllegalStateException(
                    "Cannot assign a closed or cancelled work order.");
        }

        User technician = userRepository.findById(technicianId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Technician not found"));

        workOrder.setTechnician(technician);

        workOrder.setStatus(com.keystone.enums.WorkOrderStatus.ASSIGNED);

        WorkOrder updated = workOrderRepository.save(workOrder);

        return mapToResponse(updated);
    }

    @Override
    public WorkOrderResponse removeTechnician(Long workOrderId) {

        WorkOrder workOrder = workOrderRepository.findById(workOrderId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Work Order not found"));

        workOrder.setTechnician(null);

        WorkOrder updated = workOrderRepository.save(workOrder);

        return mapToResponse(updated);
    }
    
    @Override
    public WorkOrderResponse updateWorkOrderStatus(
            Long workOrderId,
            WorkOrderStatus newStatus) {

        WorkOrder workOrder = workOrderRepository.findById(workOrderId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Work Order not found"));

        WorkOrderStatus currentStatus = workOrder.getStatus();

        boolean validTransition = switch (currentStatus) {
            case NEW ->
                    newStatus == WorkOrderStatus.ASSIGNED;

            case ASSIGNED ->
                    newStatus == WorkOrderStatus.IN_PROGRESS;

            case IN_PROGRESS ->
                    newStatus == WorkOrderStatus.ON_HOLD
                            || newStatus == WorkOrderStatus.COMPLETED;

            case ON_HOLD ->
                    newStatus == WorkOrderStatus.IN_PROGRESS
                            || newStatus == WorkOrderStatus.CANCELLED;

            case COMPLETED ->
                    newStatus == WorkOrderStatus.CLOSED;

            case CLOSED, CANCELLED ->
                    false;
        };

        if (!validTransition) {
            throw new IllegalStateException(
                    "Invalid status transition from "
                            + currentStatus
                            + " to "
                            + newStatus);
        }

        WorkOrderStatus previousStatus = workOrder.getStatus();

        workOrder.setStatus(newStatus);

        WorkOrder updated = workOrderRepository.save(workOrder);

        WorkOrderStatusHistory history = new WorkOrderStatusHistory(
                updated,
                previousStatus,
                newStatus,
                LocalDateTime.now());

        historyRepository.save(history);

        return mapToResponse(updated);
    }
    
    @Override
    public List<WorkOrderStatusHistoryResponse> getStatusHistory(Long workOrderId) {

        List<WorkOrderStatusHistory> historyList =
                historyRepository.findByWorkOrderIdOrderByChangedAtAsc(workOrderId);

        return historyList.stream()
                .map(history -> new WorkOrderStatusHistoryResponse(
                        history.getId(),
                        history.getFromStatus(),
                        history.getToStatus(),
                        history.getChangedAt()))
                .collect(Collectors.toList());
    }
    
    @Override
    public TimeLogResponse addTimeLog(Long workOrderId, TimeLogRequest request) {

        WorkOrder workOrder = workOrderRepository.findById(workOrderId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Work Order not found"));

        TimeLog timeLog = new TimeLog(
                workOrder,
                request.getHoursSpent(),
                request.getRemarks(),
                LocalDateTime.now());

        TimeLog saved = timeLogRepository.save(timeLog);

        return new TimeLogResponse(
                saved.getId(),
                saved.getHoursSpent(),
                saved.getRemarks(),
                saved.getLoggedAt());
    }

    @Override
    public List<TimeLogResponse> getTimeLogs(Long workOrderId) {

        List<TimeLog> timeLogs =
                timeLogRepository.findByWorkOrderIdOrderByLoggedAtAsc(workOrderId);

        return timeLogs.stream()
                .map(log -> new TimeLogResponse(
                        log.getId(),
                        log.getHoursSpent(),
                        log.getRemarks(),
                        log.getLoggedAt()))
                .toList();
    }
    
    @Override
    public PartUsageResponse addPartUsage(Long workOrderId, PartUsageRequest request) {

        WorkOrder workOrder = workOrderRepository.findById(workOrderId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Work Order not found"));

        PartUsage partUsage = new PartUsage(
                workOrder,
                request.getPartName(),
                request.getQuantity(),
                request.getUnitPrice());

        PartUsage saved = partUsageRepository.save(partUsage);

        return new PartUsageResponse(
                saved.getId(),
                saved.getPartName(),
                saved.getQuantity(),
                saved.getUnitPrice(),
                saved.getQuantity() * saved.getUnitPrice());
    }
    
    @Override
    public List<PartUsageResponse> getPartUsage(Long workOrderId) {

        return partUsageRepository.findByWorkOrderId(workOrderId)
                .stream()
                .map(part -> new PartUsageResponse(
                        part.getId(),
                        part.getPartName(),
                        part.getQuantity(),
                        part.getUnitPrice(),
                        part.getQuantity() * part.getUnitPrice()))
                .toList();
    }
    
    @Override
    public List<WorkOrderResponse> getSlaBreachedWorkOrders() {

        return workOrderRepository.findBySlaBreachedTrue()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }
    
    @Override
    public List<WorkOrderResponse> getWorkOrdersByCustomer(Long customerId) {

        return workOrderRepository
                .findBySiteCustomerId(customerId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }
}