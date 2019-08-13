package AOPdemo.aspect;

import AOPdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
public class AroundLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Around("execution(* AOPdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("\n----Executing After(Finally) on method: " + method);

        long begin = System.currentTimeMillis();
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception exc){
            logger.warning(exc.getMessage());
            throw exc;
        }

        long end = System.currentTimeMillis();
        logger.info("\n ====> Duration: " + (end - begin)/1000.00 + " seconds");

        return result;
    }


}
