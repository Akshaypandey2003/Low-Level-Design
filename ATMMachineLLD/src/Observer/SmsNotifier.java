package Observer;

public class SmsNotifier implements Observer {
    @Override
    public void notify(String message) {
        System.out.println("[SMS_Notification: ] " + message);
    }
}
