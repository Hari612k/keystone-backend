package com.keystone.dto;

import com.keystone.enums.Priority;
import com.keystone.enums.WorkOrderStatus;

public class WorkOrderResponse {

    private Long id;
    private String title;
    private String description;
    private Priority priority;
    private WorkOrderStatus status;

    private Long siteId;
    private String siteName;

    private Long technicianId;
    private String technicianName;

    public WorkOrderResponse() {
    }

    public WorkOrderResponse(Long id, String title, String description,
                             Priority priority, WorkOrderStatus status,
                             Long siteId, String siteName,
                             Long technicianId, String technicianName) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.siteId = siteId;
        this.siteName = siteName;
        this.technicianId = technicianId;
        this.technicianName = technicianName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public Long getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(Long technicianId) {
        this.technicianId = technicianId;
    }

    public String getTechnicianName() {
        return technicianName;
    }

    public void setTechnicianName(String technicianName) {
        this.technicianName = technicianName;
    }
}