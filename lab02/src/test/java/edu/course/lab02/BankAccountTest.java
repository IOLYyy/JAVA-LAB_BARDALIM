package edu.course.lab02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    @Test
    void testWithdraw() {
        BankAccount acc = new BankAccount(100);
        acc.withdraw(40);
        assertEquals(60, acc.getBalance());
    }

    @Test
    void testWithdrawError() {
        BankAccount acc = new BankAccount(50);
        assertThrows(IllegalArgumentException.class, () -> acc.withdraw(100));
    }

    @Test
    void testNegativeBalanceError() {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount(-10));
    }
}