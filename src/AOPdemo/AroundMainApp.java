package AOPdemo;

import AOPdemo.DAO.AccountDAO;
import AOPdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundMainApp {
    public static void main (String [] args){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        System.out.println("\nMain Program: AroundApp");
        String data = trafficFortuneService.getFortune();
        System.out.println("\nMy fortune is: " + data + "\nfinish");

        context.close();
    }
}
