package Entities;

import java.util.Scanner;

import MachineState.IdleState;
import MachineState.State;

public class Atm {
    private State currentState;
    private int currPin;
    private long currCard;
    private Bank bank;
    private TransactionType transactionType;
    private Scanner scanner;

    public Atm(Bank b) {
        this.bank = b;
        this.currentState = new IdleState(this);
        this.scanner = new Scanner(System.in);
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public int getCurrPin() {
        return currPin;
    }

    public void setCurrPin(int currPin) {
        this.currPin = currPin;
    }

    public Scanner getScanner(){
        return this.scanner;
    }

    public long getCurrCard() {
        return currCard;
    }

    public void setCurrCard(long currCard) {
        this.currCard = currCard;
    }

    public void setTransactionType(TransactionType transactionType){
        this.transactionType = transactionType;
    }
    public TransactionType getTransactionType() {
        return transactionType;
    }


    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void insertCard() {
        currentState.insertCard();
    }
  
    public void enterPin() {
        currentState.enterPin();
    }

    public void transactionProcessing() {
        currentState.transactionProcessing();
    }
    
}
