package com.hype.webmvc._payment;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import com.hype.webmvc.Values;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import jakarta.json.Json;
import jakarta.json.JsonObject;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService psvc;

    @Autowired
    RestTemplate rtemp;

    @GetMapping("/config")
    public ResponseEntity<String> getpublishablekey() {
        JsonObject jo = Json.createObjectBuilder().add("publishableKey", Values.STRIPEPUBLISHABLEKEY).build();
        return ResponseEntity.ok().body(jo.toString());

    }

    @PostMapping("/create-payment-intent")
    public ResponseEntity<String> createPaymentIntent(@RequestBody MultiValueMap<String, Object> payload)
            throws StripeException, IOException {

        PaymentIntent newPaymentIntent = psvc._createPaymentObject(payload);
        // String payments_intents_endpoint =
        // UriComponentsBuilder.fromUriString(Values.STRIPEBASEURL).toUriString();
        // RequestEntity<String> req = RequestEntity.post(payments_intents_endpoint)
        // .contentType(MediaType.APPLICATION_JSON)
        // .accept(MediaType.APPLICATION_JSON)
        // .body(newPaymentIntent.toString());

        // Event event = rtemp.exchange(req, Event.class).getBody();
        // EventDataObjectDeserializer dataObjectDeserializer =
        // event.getDataObjectDeserializer();
        // StripeObject stripeObject = null;
        // if (dataObjectDeserializer.getObject().isPresent()) {
        // stripeObject = dataObjectDeserializer.getObject().get();
        // }
        // if (event.getType().equals("payment_intent.created")) {
        // PaymentIntent paymentIntent = (PaymentIntent) stripeObject;
        // }

        return ResponseEntity.ok().body(newPaymentIntent.toJson());
    }
}
