package CreationalDesignPatterns.FactoryDesignPattern;

import java.util.HashMap;
import java.util.Map;

interface Notification{
    void notifyUser();
}
class EmailNotification implements Notification{

    public void notifyUser()
    {
        System.out.println("Sending notification via email");
    }
}
class SMSNotification implements Notification{

    public void notifyUser()
    {
        System.out.println("Sending notification via SMS");
    }
}

class WhatsappNotification implements Notification
{
    public void notifyUser()
    {
        System.out.println("Sending Notification via whatsapp");
    }
}

class NotificationFactory
{
    private static final Map<String, Notification> REGISTRY = new HashMap<>();
    static{
        REGISTRY.put("EMAIL", new EmailNotification());
        REGISTRY.put("SMS",new SMSNotification());
    }
    public static void registerService(String type, Notification notification){
        REGISTRY.put(type.toUpperCase(),notification);
    }
    public static Notification createNotification(String type)
    {
        Notification notification = REGISTRY.get(type.toUpperCase());
        if(notification!=null)
            return notification;
        else
            throw new IllegalArgumentException("Invalid Notification Type");
    }
}
public class FactoryDesignPattern {

    public static void main(String []args)
    {
        try{
            Notification notification = NotificationFactory.createNotification("sms");
            notification.notifyUser();

            NotificationFactory.registerService("whatsapp",new WhatsappNotification());

            Notification notification1 = NotificationFactory.createNotification("whatsapp");
            notification1.notifyUser();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
