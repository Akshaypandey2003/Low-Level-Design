package BehaviouralDesignPatterns.MediatorDesignPattern;

import java.util.ArrayList;
import java.util.List;

/* Mediator Interface */
interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}
 /* concrete Mediator */
 class ChatRoom implements ChatMediator {

     private List<User> users = new ArrayList<>();

     public void addUser(User user) {
         users.add(user);
     }

     public void sendMessage(String message, User sender) {
         for (User user : users) {
             if (user != sender) {
                 user.receive(message);
             }
         }
     }
 }

class User {
    private String name;
    private ChatMediator mediator;

    public User(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public void send(String message) {
        System.out.println(name + " sends: " + message);
        mediator.sendMessage(message, this);
    }

    public void receive(String message) {
        System.out.println(name + " receives: " + message);
    }
}

public class MediatorDesignPattern {
     public static void main(String args[])
     {
         ChatMediator chat = new ChatRoom();

         User akshay = new User("Akshay", chat);
         User rahul = new User("Rahul", chat);
         User amit = new User("Amit", chat);

         chat.addUser(akshay);
         chat.addUser(rahul);
         chat.addUser(amit);

         akshay.send("Hello everyone!");
     }
}
