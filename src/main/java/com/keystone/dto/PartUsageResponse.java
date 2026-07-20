package com.keystone.dto;

public class PartUsageResponse {

    private Long id;
    private String partName;
    private Integer quantity;
    private Double unitPrice;
    private Double totalCost;

    public PartUsageResponse() {
    }

    public PartUsageResponse(Long id,
                             String partName,
                             Integer quantity,
                             Double unitPrice,
                             Double totalCost) {
        this.id = id;
        this.partName = partName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalCost = totalCost;
    }

    public Long getId() {
        return id;
    }

    public String getPartName() {
        return partName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public Double getTotalCost() {
        return totalCost;
    }
}