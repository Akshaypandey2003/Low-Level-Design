package LiskovSubstitutionPrinciple;

class Account {
    double balance;

    void withdraw(double amount) throws Exception {
        if (amount <= balance) {
            balance -= amount;
        }
    }
}
 /* ❌ Subclass that BREAKS behavior */
class FixedDepositAccount extends Account {

    @Override
    void withdraw(double amount) throws Exception {
        throw new UnsupportedOperationException("Withdrawal not allowed");
    }
}
/*
💥 Runtime failure

❌ Why LSP is broken:
Expectation from Account	FixedDepositAccount
Withdrawal allowed	Withdrawal forbidden
No exception	Runtime exception
Behavior preserved	Behavior changed


*/

public class LSPViolation {

    public static void main(String args[])
    {
        FixedDepositAccount fixedDepositAccount = new FixedDepositAccount();

        try {
            fixedDepositAccount.withdraw(1000);
        }
        catch(Exception e)
        {
           System.out.println( e.getMessage());
        }


    }
}
