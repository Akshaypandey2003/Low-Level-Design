package CreationalDesignPatterns.AbstractFactoryDesignPattern;
interface Button
{
    void paint();
}
interface CheckBox{
    void paint();
}
interface  GUIFactory{
    Button createButton();
    CheckBox createCheckBox();
}
class WindowsButton implements Button{
    @Override
    public void paint() {
        System.out.println("Windows button");
    }
}
class WindowsCheckBox implements CheckBox{
    @Override
    public void paint() {
        System.out.println("Windows CheckBox");
    }
}
class WindowsFactory implements GUIFactory{
    @Override
    public Button createButton()
    {
        return new WindowsButton();
    }
    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}
class MacFactory implements GUIFactory{
    @Override
    public Button createButton()
    {
        return new MacButton();
    }
    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}
class MacButton implements Button{
    @Override
    public void paint() {
        System.out.println("Mac button");
    }
}
class MacCheckBox implements CheckBox{
    @Override
    public void paint() {
        System.out.println("Mac CheckBox");
    }
}
class FactoryProvider {

    public static GUIFactory getFactory() {

        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win"))
            return new WindowsFactory();
        else
            return new MacFactory();
    }
}
class Application
{
    private Button button;
    private CheckBox checkBox;

    Application(GUIFactory factory)
    {
        this.button = factory.createButton();
        this.checkBox = factory.createCheckBox();
    }
    public void paint()
    {
        button.paint();
        checkBox.paint();
    }
}
public class AbstractFactoryDesignPattern
{
  public static void main(String args[])
  {
    GUIFactory factory = FactoryProvider.getFactory();
    Application application = new Application(factory);
    application.paint();
  }
}
