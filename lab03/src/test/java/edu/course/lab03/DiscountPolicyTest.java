package edu.course.lab03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class DiscountPolicyTest {

    @Test
    void noDiscountReturnsOriginalPrice() {
        PriceCalculator calc = new PriceCalculator(new NoDiscount());
        assertEquals(100.0, calc.calculate(100.0), 0.001);
    }

    @Test
    void noDiscountRejectsNegativePrice() {
        PriceCalculator calc = new PriceCalculator(new NoDiscount());
        assertThrows(IllegalArgumentException.class, () -> calc.calculate(-10));
    }

    @Test
    void percentDiscountAppliesCorrectly() {
        PriceCalculator calc = new PriceCalculator(new PercentDiscount(20));
        assertEquals(80.0, calc.calculate(100.0), 0.001);
    }

    @Test
    void percentDiscountRejectsInvalidPercent() {
        assertThrows(IllegalArgumentException.class, () -> new PercentDiscount(-5));
        assertThrows(IllegalArgumentException.class, () -> new PercentDiscount(150));
    }

    @Test
    void policyCanBeReplacedWithoutChangingCalculator() {
        PriceCalculator calc = new PriceCalculator(new NoDiscount());
        assertEquals(100.0, calc.calculate(100.0), 0.001);

        calc = new PriceCalculator(new PercentDiscount(50));
        assertEquals(50.0, calc.calculate(100.0), 0.001);
    }
}