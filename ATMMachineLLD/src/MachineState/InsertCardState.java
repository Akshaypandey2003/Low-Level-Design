package MachineState;

import Entities.Atm;
import Entities.TransactionType;

public class InsertCardState extends State {

    public InsertCardState(Atm atm)
    {
        super(atm);
    }

    @Override
    public void insertCard() {

        while(true)
        {
            System.out.println("Please Enter your 10 digit card number.");
            long cardNumber = this.atm.getScanner().nextLong();
           

            if(this.atm.getBank().validateCard(cardNumber))
            {
               this.atm.setCurrCard(cardNumber);
               this.atm.setCurrentState(new EnterPinState(this.atm));
               this.atm.getCurrentState().enterPin();
               break;
            }
            else
            {
                 System.out.println("Invalid card number. Please try again.");
            }
        }
    }


    @Override
    public void enterPin() {
       System.out.println("Card not inserted. Please insert your card first.");
    }

    @Override
    public void transactionProcessing() {
        System.out.println("Card not inserted. Please insert your card first.");
    }
    
}
