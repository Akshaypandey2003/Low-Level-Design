package MachineState;

import Entities.Atm;

public class EnterPinState extends State {

    public EnterPinState(Atm atmMachine) {
        super(atmMachine);
    }

    @Override
    public void insertCard() {
        System.out.println("Card already inserted. Please enter your PIN.");
    }

    @Override
    public void enterPin() {

        while (true) {
            System.out.println("Please enter your PIN:");
            int pin = this.atm.getScanner().nextInt();
            if (this.atm.getBank().validatePin(this.atm.getCurrCard(), pin)) {
                this.atm.setCurrPin(pin);
                this.atm.setCurrentState(new TransactionProcessingState(this.atm));
                this.atm.getCurrentState().transactionProcessing();
                break;
            } else {
                System.out.println("Invalid PIN. Please try again.");
            }
        }

    }

    @Override
    public void transactionProcessing() {
        System.out.println("Please enter your PIN first.");
    }

}
