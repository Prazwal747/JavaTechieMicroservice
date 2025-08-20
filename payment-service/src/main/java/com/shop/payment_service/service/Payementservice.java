package com.shop.payment_service.service;

import com.shop.payment_service.entity.Payement;
import com.shop.payment_service.repo.PayementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Random;
import java.util.UUID;

@Service
public class Payementservice {

    @Autowired
    PayementRepo payementRepo;

    public Payement payement(@RequestBody Payement payement){
        payement.setTransactionId(UUID.randomUUID().toString());
        payement.setPaymentStatus(isPaymentProcessing());
        return payementRepo.save(payement);
    }

    public String isPaymentProcessing(){
        return new Random().nextBoolean()?"success":"failed";
    }

}
