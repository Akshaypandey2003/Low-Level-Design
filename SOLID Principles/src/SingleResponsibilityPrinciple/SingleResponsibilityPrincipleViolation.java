package SingleResponsibilityPrinciple;

class UserService
{
    public void addUser()
    {
        // logic to save user
        System.out.println("USer saved to db");
    }

    public void sendEmail()
    {
        // logic to send email
        System.out.println("Email sent");
    }
    public void generateReport()
    {
     //logic to generate report
        System.out.println("Report generated");
    }
}

public class SingleResponsibilityPrincipleViolation
{
    public static void main(String args[])
    {
        UserService user = new UserService();
        user.addUser();
        user.generateReport();
        user.sendEmail();
    }
}
