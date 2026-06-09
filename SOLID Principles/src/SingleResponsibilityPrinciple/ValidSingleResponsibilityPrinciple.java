package SingleResponsibilityPrinciple;

class UserService2 {
    public void addUser() {
        // logic to save user
        System.out.println("USer saved to db");
    }
}
class EmailService {
    public void sendEmail() {
        // logic to send email
        System.out.println("Email sent");
    }

}
class ReportService{

    public void generateReport()
    {
        //logic to generate report
        System.out.println("Report generated");
    }
}
/*
1. Easier to manage
2. Easier to debug/test
3. Easier to understand
* */
public class ValidSingleResponsibilityPrinciple
{
    public static void main(String args[])
    {
        UserService2 user = new UserService2();
        EmailService email = new EmailService();
        ReportService report = new ReportService();

        user.addUser();
        email.sendEmail();
        report.generateReport();
    }

}
