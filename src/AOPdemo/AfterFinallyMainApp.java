package AOPdemo;

import AOPdemo.DAO.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyMainApp {
    public static void main (String [] args){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        List<Account> accounts = null;
        try {
            boolean tripWire = true;
            accounts = accountDAO.findAccounts(tripWire);
        } catch (Exception ex) {
            System.out.println("\nMain Program ... caught exception: " + ex);
        }

        System.out.println("\n\nMain Program: AfterThrowingApp" + "\n---\n" + accounts + "\n");

        context.close();
    }
}
