package com.hype.webmvc._payment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import com.hype.webmvc.Values;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

@Service
@Scope("session")
public class PaymentService {

    public PaymentIntent _createPaymentObject(MultiValueMap<String, Object> payload) throws StripeException {

        Stripe.apiKey = Values.STRIPEAPIKEY;
        PaymentIntent paymentIntent = null;
        try {

            Map<String, Object> automaticPaymentMethods = new HashMap<>();
            automaticPaymentMethods.put("enabled", true);
            Map<String, Object> params = new HashMap<>();
            params.putAll(payload);
            params.put("amount", 500);
            params.put("currency", "sgd");
            params.put("description", "basic subscription");
            params.put("payment_method_types", "card");
            params.put("confirm", true);
            params.put("automatic_payment_methods", automaticPaymentMethods);
            paymentIntent = PaymentIntent.create(params);

        } catch (StripeException e) {
            Map<String, Object> errorData = new HashMap<>();
            errorData.put("message", e.getUserMessage());
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("error", errorData.toString());
        } catch (Exception e) {
            Map<String, Object> errorData = new HashMap<>();
            errorData.put("message", e);
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("error", errorData.toString());
        }
        return paymentIntent;

    }

}
