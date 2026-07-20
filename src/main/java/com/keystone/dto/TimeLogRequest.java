package com.keystone.dto;

public class TimeLogRequest {

    private Double hoursSpent;
    private String remarks;

    public TimeLogRequest() {
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
}