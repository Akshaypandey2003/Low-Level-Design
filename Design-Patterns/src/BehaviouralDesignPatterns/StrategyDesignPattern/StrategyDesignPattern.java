package BehaviouralDesignPatterns.StrategyDesignPattern;

interface PaymentStrategy{
    void pay(int amount);
}

/* ------------- Concrete Strategies ----------------- */
class UpiPayement implements PaymentStrategy
{
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " via UPI");
    }
}
class CardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " via Card");
    }
}
class PaymentService{

    public void pay(int amount, PaymentStrategy strategy)
    {
        strategy.pay(amount);
    }
}
public class StrategyDesignPattern
{
    public static void main(String args[])
    {
        PaymentStrategy strategy = new UpiPayement();
        PaymentService service = new PaymentService();
        service.pay(5000,strategy);
    }
}
