package Entities;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private long cardNumber;
    private int pin;
    private double balance;
    private List<Transaction> transactions;

    public Customer(String name, long cardNumber, int pin, double balance) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }
    public int getPin() {
        return pin;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }
    public double getBalance() {
        return balance;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
    public void updateBalance(double balance) {
        this.balance = balance;
    }

    
}
