package com.example.demo.model.dto;

import java.math.BigDecimal;
import java.util.Map;
//{
//  "disclaimer": "Usage subject to terms: https://openexchangerates.org/terms",
//  "license": "https://openexchangerates.org/license",
//  "timestamp": 1700128800,
//  "base": "USD",
//  "rates": {
//    "BGN": 1.8014,
//    "EUR": 0.921556
//  }
//}
public record ExchangeRatesDTO  (String base, Map<String, BigDecimal> rates) {
}
