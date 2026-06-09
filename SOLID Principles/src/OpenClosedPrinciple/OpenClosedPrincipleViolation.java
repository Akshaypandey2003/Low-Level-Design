package OpenClosedPrinciple;

class DiscountCalculator {
    double calculate(String type, double amount) {
        if (type.equals("FESTIVAL"))
            return amount * 0.2;
        if (type.equals("LOYAL"))
            return amount * 0.1;
        return 0;
    }
}
public class OpenClosedPrincipleViolation {

    public static void main(String args[])
    {
        DiscountCalculator cal = new DiscountCalculator();
        double festiveDiscount = cal.calculate("FESTIVAL",100); // Runs perfectly
        double blackFridayDiscount =  cal.calculate("BLACKFRIDAY",500); // returns 0;

        System.out.println("Festival Discount: "+festiveDiscount);
        System.out.println("Black Friday Discount: "+blackFridayDiscount);
    }
}
