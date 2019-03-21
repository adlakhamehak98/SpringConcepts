package com.springAOPandEvents.springAOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.io.IOException;
import java.util.Arrays;

//question 4: Create a logging aspect. Create a pointcut to log all methods Of services .

@Aspect
public class LoggingAspect {

    //question 5: Add a logging statement before and after the method ends
    @Around(value = "execution(* *Service*(..))")
    //would not run since there is no service
    void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("============================Aspect Before Service============================");
        proceedingJoinPoint.proceed();
        System.out.println("============================Aspect After Service============================");
    }

    //similar example to demonstrate how it runs
    @Around(value = "execution(void display())")
    void aroundDisplayAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("============================Aspect Before Display============================");
        proceedingJoinPoint.proceed();
        System.out.println("============================Aspect After Display============================");
    }

    //question 6:  Log all the methods which throw IOException
    @AfterThrowing(pointcut = "execution(* *(..))", throwing = "e")
    void afterReturningAdvice(IOException e) {
        System.out.println("======Running AfterThrowing " + e + "==========");
    }

    //Question 7: Apply execution, within, args, this and bean expressions on the before and after advice of service bean.
    @Before(value = "within(com.springAOPandEvents.events.entity.*)")
    void withinBeforeEntityPackageAdvice() {
        System.out.println("============================Before Anything within Entity Package============================");
    }

    @After(value = "within(com.springAOPandEvents.events.entity.*)")
    void withinAfterEntityPackageAdvice() {
        System.out.println("============================After Anything within Entity Package============================");
    }

    @Before(value = "args(Integer)")
    void beforeIntegerArgumentAdvice() {
        System.out.println("============================Before Method with Integer Argument============================");
    }

    @After(value = "args(Integer)")
    void afterIntegerArgumentAdvice() {
        System.out.println("============================After Method with Integer Argument============================");
    }

    @Before(value = "this(com.springAOPandEvents.events.entity.Database)")
    void beforeDatabaseObjectAdvice() {
        System.out.println("============================Before Method with Database Object============================");
    }

    @After(value = "this(com.springAOPandEvents.events.entity.Database)")
    void afterDatabaseObjectAdvice() {
        System.out.println("============================After Method with Database Object============================");
    }

    @Before(value = "bean(database)")
    void beforeUsingDatabaseBeanAdvice(JoinPoint joinPoint) {
        //question 9:  Access the properties of the JoinPoint in before advice. Print Signature of method being called and its arguments
        System.out.println("Before Using Database Bean : " + joinPoint.getThis().getClass().getSimpleName() +
                " having signature : " + joinPoint.getSignature() + " and Arguments : " +
                Arrays.toString(joinPoint.getArgs()));
    }

    @After(value = "bean(database)")
    void afterUsingDatabaseBeanAdvice(JoinPoint joinPoint) {
        System.out.println("After Using Database Bean : " + joinPoint.getThis().getClass().getSimpleName());
    }

    //question 8: Access the properties of the JoinPoint in before advice. Print Signature of method being called and its arguments
    @Pointcut("execution(* getPort())")
    void afterBeforeGetPortMethod() {
    }

    //Exercise8
    @Pointcut("execution(* setPort(..))")
    void afterBeforeSetPortMethod() {
    }

    //Exercise8
    @After("afterBeforeGetPortMethod() || afterBeforeSetPortMethod()")
    void afterPortGetterSetter() {
        System.out.println("============================After after Port's Getter Setter============================");
    }
}
