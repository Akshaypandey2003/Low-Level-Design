import Entities.*;

public class ATMFactory {

    
    public static Atm createATM(Bank bank) {
        return new Atm(bank);
    }
    
    public static void on(Atm atm) {

        while(true)
        {
          atm.getCurrentState().idle();
        }
        
    }

}
