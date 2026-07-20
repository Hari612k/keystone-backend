package com.keystone.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "time_logs")
public class TimeLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_order_id", nullable = false)
    private WorkOrder workOrder;

    @Column(nullable = false)
    private Double hoursSpent;

    @Column(length = 500)
    private String remarks;

    @Column(nullable = false)
    private LocalDateTime loggedAt;

    public TimeLog() {
    }

    public TimeLog(WorkOrder workOrder,
                   Double hoursSpent,
                   String remarks,
                   LocalDateTime loggedAt) {
        this.workOrder = workOrder;
        this.hoursSpent = hoursSpent;
        this.remarks = remarks;
        this.loggedAt = loggedAt;
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

    public Double getHoursSpent() {
        return hoursSpent;
    }

    public void setHoursSpent(Double hoursSpent) {
        this.hoursSpent = hoursSpent;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }

    public void setLoggedAt(LocalDateTime loggedAt) {
        this.loggedAt = loggedAt;
    }
}