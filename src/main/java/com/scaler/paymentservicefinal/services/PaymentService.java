package com.scaler.paymentservicefinal.services;

import com.scaler.paymentservicefinal.services.paymentgateway.PaymentGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService
{
    private final PaymentGatewayChooserStrategy paymentGatewayChooserStrategy;

    @Autowired
    public PaymentService(PaymentGatewayChooserStrategy paymentGatewayChooserStrategy)
    {
        this.paymentGatewayChooserStrategy = paymentGatewayChooserStrategy;
    }

    public String initiatePayment(String orderId, String email, String phoneNumber, Long amount)
    {
        PaymentGateway paymentGateway = this.paymentGatewayChooserStrategy.getBestPaymentGateway();

        return paymentGateway.generatePaymentLink(orderId, email, phoneNumber, amount);
    }
}
