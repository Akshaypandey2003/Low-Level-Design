package CreationalDesignPatterns.SingletonDesignPattern;

/* Lazy Singleton----> Means Object is created when getInstance() is called */

class User {
    private static volatile User instance;
    private String name;

    private User(String name) {
        this.name = name;
        System.out.println(Thread.currentThread().getName() +
                " created User object with name = " + name);
    }
    public static User getInstance(String name) {

        if (instance == null) { // 1st check (no lock)
            synchronized (User.class) {
                if (instance == null) { // 2nd check (with lock)
                    instance = new User(name);
                }
            }
        }
        return instance;
    }

    public String getName() {
        return name;
    }
}
class UserTask implements Runnable {

    private String name;

    public UserTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        User user = User.getInstance(name);
        System.out.println(Thread.currentThread().getName() +
                " got instance with name = " + user.getName());
    }
}


/* Eager Singleton ----> Object Created Instantly  */
//class User{
//
//    String name;
//    private static User userObj ;
//
//    private User(String name){
//        this.name = name;
//    }
//
//    public static User getInstance(String name)
//    {
//
//        if(userObj==null)
//        {
//            userObj = new User(name);
//            return userObj;
//        }
//        return null;
//    }
//    public String getName()
//    {
//        return this.name;
//    }
//}

public class Singleton {
  public static void main(String []args)
  {
      Thread t1 = new Thread(new UserTask("Akshay"), "Thread-1");
      Thread t2 = new Thread(new UserTask("Rahul"), "Thread-2");
      Thread t3 = new Thread(new UserTask("Amit"), "Thread-3");

      t1.start();
      t2.start();
      t3.start();
  }
}
