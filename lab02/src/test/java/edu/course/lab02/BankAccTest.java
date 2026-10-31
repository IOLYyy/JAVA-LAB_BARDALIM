package edu.course.lab02;
import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.*;
class BankAccountTest { @Test void withdrawSuccessfully() { BankAcc account = new BankAcc(100); account.withdraw(40); assertEquals(60, account.getBalance()); }
@Test
void withdrawThrowsWhenInsufficientFunds() {
    BankAcc account = new BankAcc(50);
    assertThrows(IllegalArgumentException.class, () -> account.withdraw(100));
}

@Test
void constructorThrowsForNegativeBalance() {
    assertThrows(IllegalArgumentException.class, () -> new BankAcc(-10));
}
}