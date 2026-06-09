package InterfaceSegregationPrinciple;

interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class HumanWorker implements Workable, Eatable {
    public void work() { }
    public void eat() { }
}

class RobotChitti implements Workable {
    public void work() { }
}
public class ValidISP
{

}
