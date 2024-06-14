package com.scaler.paymentservicefinal.services.paymentgateway;

import com.razorpay.RazorpayException;

public interface PaymentGateway
{
    String generatePaymentLink(String orderId, String email, String phoneNumber, Long amount);
}
