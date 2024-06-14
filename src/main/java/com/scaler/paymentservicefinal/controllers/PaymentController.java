package com.scaler.paymentservicefinal.controllers;

import com.scaler.paymentservicefinal.dtos.InitiatePaymentRequestDto;
import com.scaler.paymentservicefinal.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController
{
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService)
    {
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDto requestDto)
    {
        return this.paymentService.initiatePayment(requestDto.getOrderId(), requestDto.getEmail(), requestDto.getPhoneNumber(), requestDto.getAmount());
    }
}
