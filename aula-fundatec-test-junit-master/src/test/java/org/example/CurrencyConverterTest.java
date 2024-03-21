package org.example;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CurrencyConverterTest {

    @Test
    void convertUSDToEUR() {
        CurrencyConverter converter = new CurrencyConverter();
        double result = converter.convert(100, "USD", "EUR");
        assertThat(result).isCloseTo(85.0, Offset.offset(0.01));///
    }

    @Test
    void convertGBPToUSD() {
        CurrencyConverter converter = new CurrencyConverter();
        double result = converter.convert(100, "GBP", "USD");
        assertThat(result).isCloseTo(138.89, Offset.offset(0.01));
    }

    @Test
    void convertEURToJPY() {
        CurrencyConverter converter = new CurrencyConverter();
        double result = converter.convert(100, "EUR", "JPY");
        assertThat(result).isCloseTo(12860.0, Offset.offset(0.01));
    }

    @Test
    void convertUSDtoBRL() {
        CurrencyConverter converter = new CurrencyConverter();
        double result = converter.convert(100, "USD", "BRL");
        assertThat(result).isCloseTo(500.0, Offset.offset(0.01));
    }

    @Test
    void convertInvalidCurrency() {
        CurrencyConverter converter = new CurrencyConverter();
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convert(100, "XYZ", "USD");
        });
    }
}
