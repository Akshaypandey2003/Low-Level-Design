package BehaviouralDesignPatterns.StateDesignPattern;

interface OrderState {
    void next(OrderContext context);
    String getStatus();
}
class NewState implements OrderState {

    public void next(OrderContext context) {
        context.setState(new PaidState());
    }

    public String getStatus() {
        return "NEW";
    }
}

class PaidState implements OrderState {
    public void next(OrderContext context) {
        context.setState(new ShippedState());
    }

    public String getStatus() {
        return "PAID";
    }
}
class ShippedState implements OrderState {

    public void next(OrderContext context) {
        context.setState(new DeliveredState());
    }

    public String getStatus() {
        return "SHIPPED";
    }
}

class DeliveredState implements OrderState {

    public void next(OrderContext context) {
        System.out.println("Order already delivered");
    }

    public String getStatus() {
        return "DELIVERED";
    }
}
class OrderContext {
    private OrderState state;

    public OrderContext() {
        this.state = new NewState(); // initial state
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void next() {
        state.next(this);  // delegate to state
    }

    public String getStatus() {
        return state.getStatus();
    }
}

public class StateDesignPattern {
    public static void main(String args[])
    {
        OrderContext order = new OrderContext();

        order.next(); // NEW -> PAID
        order.next(); // PAID -> SHIPPED
        order.next(); // SHIPPED -> DELIVERED
        order.next(); // already delivered
    }


}
