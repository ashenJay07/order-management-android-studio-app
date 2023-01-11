package com.example.ordermanagement.model;

public class Order {

    String material, siteName, siteAddress, deliveryDate, orderStatus;
    int quantity;
    Double unitPrice, totBudget;

    public Order(String material) {
        this.material = material;
    }

    public Order(String material, int quantity, Double unitPrice, Double totBudget, String siteName, String siteAddress, String deliveryDate, String orderStatus) {
        this.material = material;
        this.siteName = siteName;
        this.siteAddress = siteAddress;
        this.deliveryDate = deliveryDate;
        this.orderStatus = orderStatus;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totBudget = totBudget;
    }

    public String getMaterial() {
        return material;
    }

    public String getSiteName() {
        return siteName;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public CharSequence getQuantity() {
        return String.valueOf(quantity);
    }

    public CharSequence getUnitPrice() {
        return String.valueOf(unitPrice);
    }

    public CharSequence getTotBudget() {
        return String.valueOf(totBudget);
    }
}
