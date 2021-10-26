package cn.jihongyun.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class AnnotationAspect {

    private final static Logger logger = Logger.getLogger("AnnotationAspect");

    @Pointcut("execution(* cn.jihongyun.aop.service..*(..))")
    public void aspect() {

    }

    @Before("aspect()")
    public void before(JoinPoint joinpoint) {
        logger.info("before" + joinpoint);
    }

    // 配置后置通知，使用在方法
    @After("aspect()")
    public void  after(JoinPoint joinpoint) {
        logger.info("after" + joinpoint);
    }

    // 配置环绕通知，使用方法aspect() 上注册的切入点
    @Around("aspect()")
    public void around(JoinPoint joinpoint) {
        long start = System.currentTimeMillis();
        try {
            ((ProceedingJoinPoint) joinpoint).proceed();
            long end = System.currentTimeMillis();
            logger.info("around"+joinpoint+"\tUse time : "+(end - start )+"ms!");
        } catch (Throwable e) {
            long end = System.currentTimeMillis();
            logger.info("around"+joinpoint+"\tUse time : "+(end - start )+"ms with Exception : "+e.getMessage());
        }
    }

    // 配置后置返回通知，使用在方法aspect()上注册的切入点
    @AfterReturning("aspect()")
    public void afterReturn(JoinPoint joinpoint) {
        logger.info("afterReturn " + joinpoint);
    }

    // 配置抛出异常后通知，使用在方法aspect()上注册的切入点
    @AfterThrowing(pointcut = "aspect()",throwing = "ex")
    public void afterThrow(JoinPoint joinpoint, Exception ex) {
        logger.info("afterThrow " + joinpoint + "\t" + ex.getMessage());
    }
}
