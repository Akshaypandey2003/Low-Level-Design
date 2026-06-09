package OpenClosedPrinciple;

interface DiscountCalculatorExample
{
    double calculate(double amount);
}

class FestivalDiscount implements  DiscountCalculatorExample
{
    public double calculate(double amount)
    {
        return amount*0.5;
    }
}
class BlackFridayDiscount implements  DiscountCalculatorExample
{
    public double calculate(double amount)
    {
        return amount*0.2;
    }
}

public class ValidOpenClosedPrinciple
{
    public static void main(String args[])
    {
        DiscountCalculatorExample festiveDiscount = new FestivalDiscount();
        System.out.println("Festivaldiscount: "+festiveDiscount.calculate(100));
        DiscountCalculatorExample blackFridayDiscount = new BlackFridayDiscount();
        System.out.println("Black friday discount: "+ blackFridayDiscount.calculate(500) );

    }
}
