package com.keystone.dto;

import java.time.LocalDateTime;

public class TimeLogResponse {

    private Long id;
    private Double hoursSpent;
    private String remarks;
    private LocalDateTime loggedAt;

    public TimeLogResponse() {
    }

    public TimeLogResponse(Long id,
                           Double hoursSpent,
                           String remarks,
                           LocalDateTime loggedAt) {
        this.id = id;
        this.hoursSpent = hoursSpent;
        this.remarks = remarks;
        this.loggedAt = loggedAt;
    }

    public Long getId() {
        return id;
    }

    public Double getHoursSpent() {
        return hoursSpent;
    }

    public String getRemarks() {
        return remarks;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }
}