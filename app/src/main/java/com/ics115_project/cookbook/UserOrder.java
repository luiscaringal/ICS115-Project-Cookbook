package com.ics115_project.cookbook;

public class UserOrder {
    private String customerUserName;
    private String customerName;
    private String orderFood;
    private String orderQuantity;
    private String pickUpDate;
    private String modeOfPayment;
    private String extraComment;
    private String chefUsername;

    public UserOrder(){

    }

    public UserOrder(String customerUserName, String customerName, String orderFood, String orderQuantity, String pickUpDate, String modeOfPayment, String extraComment, String chefUserName) {
        this.customerUserName = customerUserName;
        this.customerName = customerName;
        this.orderFood = orderFood;
        this.orderQuantity = orderQuantity;
        this.pickUpDate = pickUpDate;
        this.modeOfPayment = modeOfPayment;
        this.extraComment = extraComment;
        this.chefUsername = chefUserName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getOrderFood() {
        return orderFood;
    }

    public String getOrderQuantity() {
        return orderQuantity;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public String getExtraComment() {
        return extraComment;
    }

    public String getCustomerUserName() {
        return customerUserName;
    }

    public String getChefUsername() {
        return chefUsername;
    }
}
