package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

//import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    private static Calculator calculator;

    @BeforeAll
    public static void setup() {
        calculator = new Calculator();
        System.out.println(">>>>> setup");
    }

    @Test
    @DisplayName("Simple multiplication should work")
    void testMultiply() {
        assertEquals(20, calculator.multiply(4,5), "Regular multiplication should work");
    }

    @RepeatedTest(5)
    @DisplayName("Ensure correct handling zero")
    void testMultiplyWithZero() {
        assertEquals(0, calculator.multiply(0, 5), "Multiply with zero should be zero");
        assertEquals(0, calculator.multiply(5, 0), "Multiply with zero should be zero");
    }

    @Test
    void exceptionTest() {

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            User user = new User("24a");
        });

        assertEquals("Age must be a integer.", exception.getMessage());
    }

    @Test
    void groupedAssertions() {
        Address address = new Address();
        assertAll("address name",
                () -> assertEquals("Attilio2", address.getStreet()),
                () -> assertEquals("1001", address.getNumber()),
               () -> assertTrue(true)
                // () -> ...
        );
    }
}