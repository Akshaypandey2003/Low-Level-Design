package DependencyInversionPrinciple;

interface Database {
    void save(String data);
}

class ValidMySQLDatabase implements Database {
    public void save(String data) {
        System.out.println("Utilizing MySql Database");
    }
}
class MongoDatabase implements Database {
    public void save(String data) {
        System.out.println("Utilizing mongoDB Database");
    }
}
class ValidUserService {
    private Database database;

    public ValidUserService(Database database) {
        this.database = database;
    }

    void saveUser(String user) {
        database.save(user);
    }
}
public class ValidDIP {
    public static void main(String args[])
    {
        Database db = new MongoDatabase();
        ValidUserService userService = new ValidUserService(db);
        userService.saveUser("I am Ram");
    }
}
