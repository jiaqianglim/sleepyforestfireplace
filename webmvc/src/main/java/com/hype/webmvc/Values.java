package com.hype.webmvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Values {

    /// Droplet Deployment
    public static String FRONTENDURL = "http://localhost:4200";
    public static String MONGOURL = "localhost:// 27017";
    public static String STRIPEBASEURL = "https://api.stripe.com";
    public static String STRIPEPUBLISHABLEKEY = "pk_test_51MvssFDjgly01pNnRh3T8KZuzAjRu7B45beV055u40fIlzfZ3R9b8jBU9grIELnsKBChuSJtLhVCsSzMY7A3Hrnv00syRUjUvq";

    @Value("${MONGOCONNECTIONSTRING}")
    public static String MONGOCONNECTIONSTRING;
    @Value("${STRIPEAPIKEY}")
    public static String STRIPEAPIKEY;
}