package Entities;

import java.util.Map;

import Observer.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bank {
    private Map<Long, Customer> customers;
    private List<Observer> observer;

    public Bank() {
        customers = new HashMap<>();
        observer = new ArrayList<>();
    }

    public Map<Long, Customer> getCustomers() {
        return this.customers;
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.getCardNumber(), customer);
    }

    public void addObserver(Observer observer) {
        this.observer.add(observer);
    }

    public void notify(long cardNumber, double amount) {
        Customer customer = customers.get(cardNumber);
        for (Observer obs : observer) {
            obs.notify("Dear " + customer.getName() + ", your account has been debited with amount: " + amount
                    + ", available balance is: " + customer.getBalance());
        }
    }

    public void updateBalance(long cardNumber, double amount) {
        Customer customer = customers.get(cardNumber);
        if (customer != null) {
            customer.updateBalance(customer.getBalance() - amount);

            Transaction transaction = new Transaction(new java.sql.Timestamp(System.currentTimeMillis()),
                    TransactionType.CASH_WITHDRAWAL, amount, customer.getBalance());
            customer.getTransactions().add(transaction);
            notify(cardNumber, amount);
        }
    }

    public boolean validateCard(long cardNumber) {
        return customers.containsKey(cardNumber);
    }

    public boolean validatePin(long cardNumber, int pin) {
        Customer customer = customers.get(cardNumber);
        return customer != null && customer.getPin() == pin;
    }

    public boolean validateTransaction(long cardNumber, double amount) {
        Customer customer = customers.get(cardNumber);
        return customer != null && customer.getBalance() >= amount;
    }

    public void printStatement(long cardNumber) {
        Customer customer = customers.get(cardNumber);
        List<Transaction> transactions = customer.getTransactions();

        System.out.println("Recent Transactions:");
        for (Transaction transaction : transactions) {
            System.out.println("- " + transaction.getTimestamp() + ": " + transaction.getType() + " of amount "
                    + transaction.getAmount()+ ", available balance: " + transaction.getAvailableBalance());
        }
    }

}
