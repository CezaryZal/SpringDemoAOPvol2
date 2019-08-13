package AOPdemo;

import AOPdemo.DAO.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main (String [] args){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        accountDAO.addAccount();

        accountDAO.setName("TOM");
        accountDAO.setServiceCode("Rudy");
        String name = accountDAO.getName();
        String serviceCode = accountDAO.getServiceCode();

        accountDAO.makeSomething();

        context.close();
    }
}
