package Entities;

import java.sql.Timestamp;

public class Transaction {
    private String id = java.util.UUID.randomUUID().toString();
    private Timestamp timestamp;
    private TransactionType type;
    private double amount;
    private double availableBalance;

    
    public Transaction(Timestamp timestamp, TransactionType type, double amount, double availableBalance) {
        this.timestamp = timestamp;
        this.type = type;
        this.amount = amount;
        this.availableBalance = availableBalance;
    }
    public String getId() {
        return id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
   
    public TransactionType getType() {
        return type;
    }
   
    public double getAmount() {
        return amount;
    }
    
    public double getAvailableBalance() {
        return availableBalance;
    }
    
}
