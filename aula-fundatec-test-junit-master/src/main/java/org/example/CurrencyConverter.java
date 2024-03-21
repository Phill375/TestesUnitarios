package org.example;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    private Map<String, Double> exchangeRates;

    public CurrencyConverter() {
        exchangeRates = new HashMap<>();

        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.72);
        exchangeRates.put("JPY", 128.60);
        exchangeRates.put("BRL", 5.0);///
    }

    public double convert(double amount, String fromCurrency, String toCurrency) {
        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Moeda não suportada.");
        }
        double exchangeRate = exchangeRates.get(toCurrency) / exchangeRates.get(fromCurrency);
        return amount * exchangeRate;
    }
}
