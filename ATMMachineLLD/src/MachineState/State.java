package MachineState;

import Entities.Atm;
import Entities.TransactionType;

public abstract class State {
        protected Atm atm;
        public State(Atm atm) {
            this.atm = atm;
        }
    public void idle() {
        System.out.println("Welcome to the ATM. Please Select the transaction you want to perform.");
        System.out.println("1. Balance Enquiry");
        System.out.println("2. Cash Withdrawal");
        System.out.println("3. Mini Statement");

        int option  = this.atm.getScanner().nextInt();
        switch (option) {
            case 1:
                this.atm.setTransactionType(TransactionType.BALANCE_ENQUIRY);
                this.atm.setCurrentState(new InsertCardState(this.atm));
                this.atm.getCurrentState().insertCard();
                break;
            case 2:
                this.atm.setTransactionType(TransactionType.CASH_WITHDRAWAL);
                this.atm.setCurrentState(new InsertCardState(this.atm));
                this.atm.getCurrentState().insertCard();
                break;
            case 3:
                this.atm.setTransactionType(TransactionType.MINI_STATEMENT);
                this.atm.setCurrentState(new InsertCardState(this.atm));
                this.atm.getCurrentState().insertCard();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
    public abstract void insertCard();
    public abstract void enterPin();
    public abstract void transactionProcessing();
}
