package edu.course.lab02;

public class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        if (initialBalance < 0) throw new IllegalArgumentException("Баланс < 0");
        this.balance = initialBalance;
    }

    public void deposit(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Сумма <= 0");
        this.balance += amount;
    }

    public void withdraw(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Сумма <= 0");
        if (amount > this.balance) throw new IllegalArgumentException("Мало денег");
        this.balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}