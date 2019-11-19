package com.lzh.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 切面类
 * @author lzh
 * create 2019-10-31-20:28
 */
//@Aspect：告诉Spring当前类是一个切面类
@Aspect
public class LogAspects {

    //抽取公共的切入点表达式
    //1、本类引用
    //2、其他的切面引用
    @Pointcut("execution(public int com.lzh.aop.MathCalculator.*(..))")
    public void pointCut(){};

    //@Before在目标方法之前切入，切入表达式（指定在哪个方法切入）
    //@Before("@After(com.lzh.aop.MathCalculator.*(..))")
    @Before("pointCut(){}")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println(""+joinPoint.getSignature().getName()+"运行...@Before：参数列表是：{"+ Arrays.asList(args)+"}");
    }

    //@After("com.lzh.aop.MathCalculator.*(..)")
    //外部引用
    @After("com.lzh.aop.LogAspects.pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(""+joinPoint.getSignature().getName()+"结束...@After");
    }

    //JoinPoint一定要出现在参数表的第一位
    @AfterReturning(value = "pointCut(){}",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        System.out.println(""+joinPoint.getSignature().getName()+"正常返回...@AfterReturning：运行结果：{"+result+"}");
    }

    @AfterThrowing(value = "pointCut(){}",throwing = "exception")
    public void logRExecption(JoinPoint joinPoint,Exception exception){
        System.out.println(""+joinPoint.getSignature().getName()+"除法异常...异常信息：{"+exception+"}");
    }
}

