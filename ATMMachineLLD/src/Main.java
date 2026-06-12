import Entities.*;
import Observer.Observer;
import Observer.SmsNotifier;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        
        Observer smsNotifier = new SmsNotifier();

        bank.addObserver(smsNotifier);
       
        Customer customer1 = new Customer("Akshay", 7879379487L, 1234, 1000.0);
        bank.addCustomer(customer1);
        
        Atm atm = ATMFactory.createATM(bank);

        ATMFactory.on(atm);
    }
}
