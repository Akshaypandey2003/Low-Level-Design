package BehaviouralDesignPatterns.ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

interface Observer{
    void update(String message);
}

/* Subject */
interface Subject{
    void addObserver(Observer o);
    void removeObserever(Observer o);
    void notifyObservers();
}

/* Concrete Observers */
class EmailService implements Observer{
    public void update(String message)
    {
        System.out.println("Email sent for: "+message);
    }
}

class SMSService implements Observer{
    public void update(String msg) {
        System.out.println("SMS sent for: " + msg);
    }
}
/* Concrete Subject */
class OrderService implements Subject{
    List<Observer> observers = new ArrayList<>();
    private String status;

    public void placeOrder()
    {
        this.status = "ORDER_PLACED";
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
      observers.add(o);
    }

    @Override
    public void removeObserever(Observer o) {
       observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer o : observers)
        {
            o.update(status);
        }
    }
}



public class ObserverDesignPattern
{
    public static void main(String args[])
    {
        OrderService orderService = new OrderService();

        orderService.addObserver(new EmailService());
        orderService.addObserver(new SMSService());

        orderService.placeOrder();

    }
}
