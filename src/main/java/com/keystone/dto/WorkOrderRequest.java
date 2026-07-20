package com.keystone.dto;

import com.keystone.enums.Priority;
import com.keystone.enums.WorkOrderStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class WorkOrderRequest {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    @NotNull(message = "Priority is required")
    private Priority priority;

    @NotNull(message = "Status is required")
    private WorkOrderStatus status;

    @NotNull(message = "Site ID is required")
    private Long siteId;

    private Long technicianId;

    public WorkOrderRequest() {
    }

    public WorkOrderRequest(String title, String description,
                            Priority priority,
                            WorkOrderStatus status,
                            Long siteId,
                            Long technicianId) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.siteId = siteId;
        this.technicianId = technicianId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public WorkOrderStatus getStatus() {
        return status;
    }

    public void setStatus(WorkOrderStatus status) {
        this.status = status;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public Long getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(Long technicianId) {
        this.technicianId = technicianId;
    }
}