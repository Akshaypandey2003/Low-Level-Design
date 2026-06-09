package InterfaceSegregationPrinciple;

interface Worker {
    void work();
    void eat();
    void sleep();
}

class Robot implements Worker{
    public void work() { }
    public void eat() { }    // ❌ meaningless
    public void sleep() { }  // ❌ meaningless
}
public class ISPViolation {
}
