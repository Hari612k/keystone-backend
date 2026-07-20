package com.keystone.entity;

import java.time.LocalDateTime;

import com.keystone.enums.WorkOrderStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "work_order_status_history")
public class WorkOrderStatusHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_order_id", nullable = false)
    private WorkOrder workOrder;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WorkOrderStatus fromStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WorkOrderStatus toStatus;

    @Column(nullable = false)
    private LocalDateTime changedAt;

    public WorkOrderStatusHistory() {
    }

    public WorkOrderStatusHistory(WorkOrder workOrder,
                                  WorkOrderStatus fromStatus,
                                  WorkOrderStatus toStatus,
                                  LocalDateTime changedAt) {
        this.workOrder = workOrder;
        this.fromStatus = fromStatus;
        this.toStatus = toStatus;
        this.changedAt = changedAt;
    }

    public Long getId() {
        return id;
    }

    public WorkOrder getWorkOrder() {
        return workOrder;
    }

    public void setWorkOrder(WorkOrder workOrder) {
        this.workOrder = workOrder;
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