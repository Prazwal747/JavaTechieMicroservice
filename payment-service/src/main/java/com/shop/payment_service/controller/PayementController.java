package com.shop.payment_service.controller;

import com.shop.payment_service.entity.Payement;
import com.shop.payment_service.service.Payementservice;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/payment")
public class PayementController {

    @Autowired
    Payementservice payementservice;

    @RequestMapping(value = "/doPayment",method = {RequestMethod.GET,
            RequestMethod.POST, RequestMethod.PUT},
            produces = MediaType.APPLICATION_JSON,
            consumes = MediaType.APPLICATION_JSON
    )
    public @ResponseBody Payement doPayement(@RequestBody Payement payement){
        return payementservice.payement(payement);
    }


}
