package StructuralDesignPatterns.AdapterDesingPattern;

/* Client Expected Interface */
interface PaymentProcessor {
    void pay(double amount);
}

/* Existing / Legacy Class (Incompatible) */
/* Adaptee */
class LegacyPaymentGateway {
    public void makePayment(double amount) {
        System.out.println("Paid " + amount + " via legacy gateway");
    }
}

/* Adapter Class */
class PaymentAdapter implements  PaymentProcessor{

    LegacyPaymentGateway paymentGateway;

    PaymentAdapter(LegacyPaymentGateway paymentGateway)
    {
        this.paymentGateway = new LegacyPaymentGateway();
    }
    @Override
    public void pay(double amount) {
        paymentGateway.makePayment(amount);
    }
}
/* Client Code */
public class AdapterDesignPattern
{
    public static void main(String args[])
    {
        PaymentProcessor paymentProcessor = new PaymentAdapter(new LegacyPaymentGateway());

        paymentProcessor.pay(500.56);
    }
}
