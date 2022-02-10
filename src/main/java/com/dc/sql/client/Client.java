package com.dc.sql.client;

import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import javax.net.ssl.SSLException;

public class Client {

    public static WebClient createWebClient(String url, int bufferSize) throws SSLException  {
        ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(bufferSize)).build();
        return WebClient.builder().exchangeStrategies(exchangeStrategies).baseUrl(url).build();
    }

}
