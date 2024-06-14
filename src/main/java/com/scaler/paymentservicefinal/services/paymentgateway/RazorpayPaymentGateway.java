package com.scaler.paymentservicefinal.services.paymentgateway;

import com.razorpay.PaymentLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.json.JSONObject;
import com.razorpay.RazorpayClient;


@Service
public class RazorpayPaymentGateway implements PaymentGateway
{

    private final RazorpayClient razorpayClient;

    @Autowired
    public RazorpayPaymentGateway(RazorpayClient razorpayClient)
    {
        this.razorpayClient = razorpayClient;
    }

    @Override
    public String generatePaymentLink(String orderId, String email, String phoneNumber, Long amount)
    {
        try
        {
            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount", amount); // 10.00
            paymentLinkRequest.put("currency","INR");
            paymentLinkRequest.put("accept_partial",false);
            paymentLinkRequest.put("expire_by", 1700502051); // epoch timestamp
            paymentLinkRequest.put("reference_id", orderId);
            paymentLinkRequest.put("description","Payment for order number: " + orderId);

            JSONObject customer = new JSONObject();
            customer.put("contact", phoneNumber);
            customer.put("name","Kapil Kumar");
            customer.put("email", email);
            paymentLinkRequest.put("customer",customer);

            JSONObject notify = new JSONObject();
            notify.put("sms",true);
            notify.put("email",true);
            paymentLinkRequest.put("notify",notify);
            paymentLinkRequest.put("reminder_enable",true);

            paymentLinkRequest.put("callback_url","https://example-callback-url.com/");
            paymentLinkRequest.put("callback_method","get");

            PaymentLink payment = this.razorpayClient.paymentLink.create(paymentLinkRequest);

            return payment.get("short_url").toString();
        }
        catch (Exception ex)
        {
            return "something is wrong";
        }
    }
}
