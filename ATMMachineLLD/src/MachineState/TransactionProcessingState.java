package MachineState;

import Entities.Atm;
import Entities.Customer;

public class TransactionProcessingState extends State{

    public TransactionProcessingState(Atm atm) {
        super(atm);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void insertCard() {
        System.out.println("Processing transaction. Cannot insert card now.");
    }

    @Override
    public void enterPin() {
     System.out.println("Processing transaction. Cannot enter PIN now.");
    }

    @Override
    public void transactionProcessing() {
        // TODO Auto-generated method stub
        System.out.println("Processing transaction.");

        Customer customer = this.atm.getBank().getCustomers().get(this.atm.getCurrCard());

            switch (this.atm.getTransactionType()) {
                case BALANCE_ENQUIRY:
                    System.out.println(customer.getName() + ", your current balance is: " + customer.getBalance());
                    break;
                case CASH_WITHDRAWAL:
                    System.out.println("Enter the amount to withdraw:");
                    double amount = this.atm.getScanner().nextDouble();
                    if(this.atm.getBank().validateTransaction(this.atm.getCurrCard(), amount))
                    {
                        System.out.println("Please collect your cash.");
                        this.atm.getBank().updateBalance(customer.getCardNumber(), amount);
                        
                        this.atm.setCurrentState(new IdleState(this.atm));

                    }
                    else
                    {
                        System.out.println("Insufficient balance. Please try again.");
                        this.atm.setCurrentState(new IdleState(this.atm));
                    }
                    break;
                case MINI_STATEMENT:
                    System.out.println("Mini Statement:");
                    this.atm.getBank().printStatement(this.atm.getCurrCard());
                    break;
                default:
                    System.out.println("Invalid transaction type.");
            }
    }
    
    
    
}
