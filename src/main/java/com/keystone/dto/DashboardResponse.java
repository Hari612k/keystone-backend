package com.keystone.dto;

public class DashboardResponse {

    private long totalCustomers;
    private long totalSites;
    private long totalWorkOrders;
    private long newWorkOrders;
    private long assignedWorkOrders;
    private long inProgressWorkOrders;
    private long completedWorkOrders;
    private long closedWorkOrders;
    private long cancelledWorkOrders;
    private long totalTechnicians;
    private long slaBreachedWorkOrders;

    public DashboardResponse() {
    }

    public DashboardResponse(long totalCustomers,
                             long totalSites,
                             long totalWorkOrders,
                             long newWorkOrders,
                             long assignedWorkOrders,
                             long inProgressWorkOrders,
                             long completedWorkOrders,
                             long closedWorkOrders,
                             long cancelledWorkOrders,
                             long totalTechnicians) {

        this.totalCustomers = totalCustomers;
        this.totalSites = totalSites;
        this.totalWorkOrders = totalWorkOrders;
        this.newWorkOrders = newWorkOrders;
        this.assignedWorkOrders = assignedWorkOrders;
        this.inProgressWorkOrders = inProgressWorkOrders;
        this.completedWorkOrders = completedWorkOrders;
        this.closedWorkOrders = closedWorkOrders;
        this.cancelledWorkOrders = cancelledWorkOrders;
        this.totalTechnicians = totalTechnicians;
    }
    
    public long getSlaBreachedWorkOrders() {
        return slaBreachedWorkOrders;
    }

    public void setSlaBreachedWorkOrders(long slaBreachedWorkOrders) {
        this.slaBreachedWorkOrders = slaBreachedWorkOrders;
    }

    public long getTotalCustomers() {
        return totalCustomers;
    }

    public void setTotalCustomers(long totalCustomers) {
        this.totalCustomers = totalCustomers;
    }

    public long getTotalSites() {
        return totalSites;
    }

    public void setTotalSites(long totalSites) {
        this.totalSites = totalSites;
    }

    public long getTotalWorkOrders() {
        return totalWorkOrders;
    }

    public void setTotalWorkOrders(long totalWorkOrders) {
        this.totalWorkOrders = totalWorkOrders;
    }

    public long getNewWorkOrders() {
        return newWorkOrders;
    }

    public void setNewWorkOrders(long newWorkOrders) {
        this.newWorkOrders = newWorkOrders;
    }

    public long getAssignedWorkOrders() {
        return assignedWorkOrders;
    }

    public void setAssignedWorkOrders(long assignedWorkOrders) {
        this.assignedWorkOrders = assignedWorkOrders;
    }

    public long getInProgressWorkOrders() {
        return inProgressWorkOrders;
    }

    public void setInProgressWorkOrders(long inProgressWorkOrders) {
        this.inProgressWorkOrders = inProgressWorkOrders;
    }

    public long getCompletedWorkOrders() {
        return completedWorkOrders;
    }

    public void setCompletedWorkOrders(long completedWorkOrders) {
        this.completedWorkOrders = completedWorkOrders;
    }

    public long getClosedWorkOrders() {
        return closedWorkOrders;
    }

    public void setClosedWorkOrders(long closedWorkOrders) {
        this.closedWorkOrders = closedWorkOrders;
    }

    public long getCancelledWorkOrders() {
        return cancelledWorkOrders;
    }

    public void setCancelledWorkOrders(long cancelledWorkOrders) {
        this.cancelledWorkOrders = cancelledWorkOrders;
    }

    public long getTotalTechnicians() {
        return totalTechnicians;
    }

    public void setTotalTechnicians(long totalTechnicians) {
        this.totalTechnicians = totalTechnicians;
    }
}