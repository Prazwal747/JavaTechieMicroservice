package com.shop.order_service.common;

import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class Payement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payementId;

    private String paymentStatus;

    private String transactionId;

    private int orderId;

    private double amount;



    public Payement() {
    }

    public Payement(int payementId, String paymentStatus, String transactionId, int orderId, int amount) {
        this.payementId = payementId;
        this.paymentStatus = paymentStatus;
        this.transactionId = transactionId;
        this.orderId = orderId;
        this.amount = amount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPayementId() {
        return payementId;
    }

    public void setPayementId(int payementId) {
        this.payementId = payementId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
