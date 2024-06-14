package com.scaler.paymentservicefinal.services;

import com.scaler.paymentservicefinal.services.paymentgateway.PaymentGateway;
import com.scaler.paymentservicefinal.services.paymentgateway.RazorpayPaymentGateway;
import com.scaler.paymentservicefinal.services.paymentgateway.StripePaymentGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentGatewayChooserStrategy
{
    private final RazorpayPaymentGateway razorpayPaymentGateway;
    private final StripePaymentGateway stripePaymentGateway;


    @Autowired
    public PaymentGatewayChooserStrategy(RazorpayPaymentGateway razorpayPaymentGateway, StripePaymentGateway stripePaymentGateway)
    {
        this.razorpayPaymentGateway = razorpayPaymentGateway;
        this.stripePaymentGateway = stripePaymentGateway;
    }

    public PaymentGateway getBestPaymentGateway()
    {
        int randomInt = new Random().nextInt();

        if(randomInt % 2 == 0)
        {
            return this.stripePaymentGateway;
        }
        else
        {
            return this.stripePaymentGateway;
        }
    }
}
