package DependencyInversionPrinciple;

class MySQLDatabase {
    void save(String data) {
        System.out.println("Utilizing MySql Databse");
    }
}
/* 👉 Tightly coupled → cannot switch DB easily */
class UserService {
    private MySQLDatabase db = new MySQLDatabase();

    void saveUser(String user) {
        db.save(user);
    }
}
public class DIPViolation
{
  public static void main(String args[])
  {
      UserService userService = new UserService();
      userService.saveUser("I am RAm");
  }
}
