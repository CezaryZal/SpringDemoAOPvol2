package AOPdemo;

import AOPdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class ArounHandleExceptionMainApp {

    private static Logger logger = Logger.getLogger(ArounHandleExceptionMainApp.class.getName());

    public static void main (String [] args){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
        logger.info("\nMain Program: AroundApp");

        String data = trafficFortuneService.getFortune(true);
        logger.info("\nMy fortune is: " + data);
        logger.info("Finished");

        context.close();
    }
}
