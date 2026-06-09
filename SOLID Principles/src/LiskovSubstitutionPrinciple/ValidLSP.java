package LiskovSubstitutionPrinciple;

interface Account2 { }

interface Withdrawable {
    void withdraw(double amount);
}

class SavingsAccount implements Account2, Withdrawable {
    public void withdraw(double amount) { }
}

class FixedDepositAccount2 implements Account2 {
    // no withdraw method
}
public class ValidLSP {
}
