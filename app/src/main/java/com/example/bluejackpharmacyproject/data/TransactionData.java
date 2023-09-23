package com.example.bluejackpharmacyproject.data;

public class TransactionData {

    private String transDate;
    private MedicineData item;
    public int quantity;
    private int UserId;

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getTransDate() {

        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    public MedicineData getItem() {
        return item;
    }

    public void setItem(MedicineData item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public TransactionData(String transDate, MedicineData item, int quantity, int UserId) {
        this.transDate = transDate;
        this.item = item;
        this.quantity = quantity;
        this.UserId = UserId;
    }
}
