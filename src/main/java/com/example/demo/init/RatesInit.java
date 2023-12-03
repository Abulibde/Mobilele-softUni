package com.example.demo.init;

import com.example.demo.config.OpenExchangeRateConfig;
import com.example.demo.model.dto.ExchangeRatesDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class RatesInit implements CommandLineRunner {
    private final OpenExchangeRateConfig openExchangeRateConfig;
    private final RestTemplate restTemplate;

    public RatesInit(OpenExchangeRateConfig openExchangeRateConfig, RestTemplate restTemplate) {
        this.openExchangeRateConfig = openExchangeRateConfig;
        this.restTemplate = restTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        String openExchangeRateUrl =
                openExchangeRateConfig.getSchema() +
                        "://" +
                        openExchangeRateConfig.getHost() +
                        openExchangeRateConfig.getPath() +
                        "?app_od={app_id}&symbols={symbols}";

        Map<String, String> requestParam = Map.of(
                "app_id", openExchangeRateConfig.getAppId(),
                "symbols", String.join(",", openExchangeRateConfig.getSymbols())
        );


        ExchangeRatesDTO exchangeRatesDTO = restTemplate
                .getForObject(openExchangeRateUrl, ExchangeRatesDTO.class, requestParam);
        System.out.println("-- receive from open exchange rates  -----");
        System.out.println(exchangeRatesDTO);
        System.out.println("-- receive from open exchange rates  -----");
    }

}
