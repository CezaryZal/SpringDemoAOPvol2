package AOPdemo;

import AOPdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class ArounWithLoggerdMainApp {

    private static Logger logger = Logger.getLogger(ArounWithLoggerdMainApp.class.getName());

    public static void main (String [] args){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        logger.info("\nMain Program: AroundApp");
        String data = trafficFortuneService.getFortune();
        logger.info("\nMy fortune is: " + data);
        logger.info("Finished");

        context.close();
    }
}
