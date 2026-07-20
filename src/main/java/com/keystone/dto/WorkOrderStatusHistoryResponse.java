package com.keystone.dto;

import java.time.LocalDateTime;

import com.keystone.enums.WorkOrderStatus;

public class WorkOrderStatusHistoryResponse {

    private Long id;
    private WorkOrderStatus fromStatus;
    private WorkOrderStatus toStatus;
    private LocalDateTime changedAt;

    public WorkOrderStatusHistoryResponse() {
    }

    public WorkOrderStatusHistoryResponse(Long id,
                                          WorkOrderStatus fromStatus,
                                          WorkOrderStatus toStatus,
                                          LocalDateTime changedAt) {
        this.id = id;
        this.fromStatus = fromStatus;
        this.toStatus = toStatus;
        this.changedAt = changedAt;
    }

    public Long getId() {
        return id;
    }

    public WorkOrderStatus getFromStatus() {
        return fromStatus;
    }

    public void setFromStatus(WorkOrderStatus fromStatus) {
        this.fromStatus = fromStatus;
    }

    public WorkOrderStatus getToStatus() {
        return toStatus;
    }

    public void setToStatus(WorkOrderStatus toStatus) {
        this.toStatus = toStatus;
    }

    public LocalDateTime getChangedAt() {
        return changedAt;
    }

    public void setChangedAt(LocalDateTime changedAt) {
        this.changedAt = changedAt;
    }
}