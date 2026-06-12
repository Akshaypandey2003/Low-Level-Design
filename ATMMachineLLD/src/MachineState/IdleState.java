package MachineState;

import Entities.Atm;

public class IdleState extends State {

    public IdleState(Atm atm) {
        super(atm);
    }

    @Override
    public void insertCard() {
        System.out.println("Please Enter you card number.");
        
        // Transition to CardInsertedState
    }

    @Override
    public void enterPin() {
        System.out.println("No card inserted. Cannot enter PIN.");
    }

    @Override
    public void transactionProcessing() {
        System.out.println("No card inserted. Cannot process transaction.");
    }
    
}
