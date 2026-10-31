package edu.course.lab02;

public class BankAcc {      


    private int balance;     //ограничитель,баланс видно только внутри класса 

    public BankAcc(int initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным");
        }
        this.balance = initialBalance;
    }


    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма пополнения должна быть больше нуля");
        }
        this.balance += amount;
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма списания должна быть больше нуля");
        }
        if (amount > this.balance) {
            throw new IllegalArgumentException("Недостаточно средств на счете");
        }
        this.balance -= amount;
    }


    public int getBalance() {    //возвращает баланс
        return balance;
    }
}
