package AOPdemo.aspect;

import AOPdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class AfterReturningLoggingAspect {

    @AfterReturning(
            pointcut = "execution(* AOPdemo.DAO.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturingFindAccountAvice(JoinPoint joinPoint, List<Account> result){

        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n--Executing AfterReturning on method: " + method);
        System.out.println("\n->results: " + result);

        convertAccountNameToUpperCase(result);
        System.out.println("\n->results: " + result);
    }

    private void convertAccountNameToUpperCase(List<Account> result) {
        for(Account tempAccount : result){
            String upperName = tempAccount.getName().toUpperCase();
            tempAccount.setName(upperName);
        }
    }

    @Before("AOPdemo.aspect.AOPExpressions.forDAOPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        System.out.println("\n Executing method beforeAddAccount from JoinPointsAspect class");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);
    }


}
