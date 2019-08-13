package AOPdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpressions {

    @Pointcut("execution(* AOPdemo.DAO.*.*(..))")
    public void forDAOPackage(){}

    @Pointcut("execution(* AOPdemo.DAO.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* AOPdemo.DAO.*.set*(..))")
    public void setter(){}

    @Pointcut("forDAOPackage() && !(getter() || setter())")
    public void forDAOPackageNoGetterSetter(){
    }
}
