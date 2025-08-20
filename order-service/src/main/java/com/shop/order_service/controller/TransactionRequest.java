package com.shop.order_service.controller;

import com.shop.order_service.common.Payement;
import com.shop.order_service.entity.Order;

public class TransactionRequest
{

    private Order order;
    private Payement payement;

    public TransactionRequest(Order order, Payement payement) {
        this.order = order;
        this.payement = payement;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Payement getPayement() {
        return payement;
    }

    public void setPayement(Payement payement) {
        this.payement = payement;
    }
}
