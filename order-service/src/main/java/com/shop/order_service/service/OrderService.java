package com.shop.order_service.service;

import com.shop.order_service.common.Payement;
import com.shop.order_service.controller.TransactionRequest;
import com.shop.order_service.controller.TransactionResponse;
import com.shop.order_service.entity.Order;
import com.shop.order_service.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private RestTemplate restTemplate;

    public TransactionResponse saveOrder(TransactionRequest transactionRequest){
        Order order = transactionRequest.getOrder();
        Payement payement = transactionRequest.getPayement();
        payement.setOrderId(order.getId());
        payement.setAmount(order.getPrice());

        //rest call
        Payement payementResponse =  restTemplate
                .postForObject("http://PAYMENT-SERVICE/payment/doPayment",payement, Payement.class);
        /*
        Problem: Some RestTemplate methods, like getForObject or
        getForEntity, are designed for GET requests and might ignore the
        request body or headers intended for content negotiation.
        Solution: For posting data, use appropriate RestTemplate methods like postForObject,
        postForEntity, or exchange with HttpMethod.POST.
         */
       String response = payementResponse.
               getPaymentStatus().
               equalsIgnoreCase("success")?"Order plced":"Payment failed";

        orderRepo.save(order);
        return new TransactionResponse(order,payementResponse.getAmount(),payementResponse.getTransactionId(),response);
    }

}
