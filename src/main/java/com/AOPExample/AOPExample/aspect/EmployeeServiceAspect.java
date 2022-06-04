package com.AOPExample.AOPExample.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
// order可以用來排序那一個aspect先跑
@Order(1)
public class EmployeeServiceAspect {

    // JoinPoint对象封装了SpringAop中切面方法的信息,在切面方法中添加JoinPoint参数,就可以获取到封装了该方法信息的JoinPoint对象.

    // 這種value表示 在EmployeeService中的所有 包含參數name,empId的方法都會通過這裡
//    @Before(value = "execution(* com.AOPExample.AOPExample.service.EmployeeService.*(..)) && args(name,empId)")
//    public void beforeAdvice(JoinPoint joinPoint, String name, String empId) {
//        System.out.println("Before method:" + joinPoint.getSignature());
//
//        System.out.println("Creating Employee with name - " + name + " and id - " + empId);
//    }

//    這種value表示 在EmployeeService中的某一個方法 兩種都可以
//    星星的地方 應該要填存取修是 以及回傳型別 這邊使用*就代表 任何存取修飾以及任何回傳型別都可以接受
//    @Before(value = "execution(* com.AOPExample.AOPExample.service.EmployeeService.printHello())")
//    @Before(value = "execution(String printHello())")
//    任何print開頭的方法
//    @Before(value = "execution(String print*())")
//    任何回傳型別都可以接受
    @Before(value = "execution(* printHello())")
    public void aroundAdvice(JoinPoint joinPoint) {
        System.out.println("Before method:" + joinPoint.getSignature());

        System.out.println("Before hello world!");
    }

//    @After(value = "execution(* com.AOPExample.AOPExample.service.EmployeeService.*(..)) && args(name,empId)")
//    public void afterAdvice(JoinPoint joinPoint, String name, String empId) {
//        System.out.println("After method:" + joinPoint.getSignature());
//
//        System.out.println("Successfully created Employee with name - " + name + " and id - " + empId);
//    }

//  使用Pointcut 來多次使用該切點
    @Pointcut(value = "execution(* com.AOPExample.AOPExample.service.EmployeeService.*(..)) && args(name,empId)")
    public void Pointcut1(String name, String empId) { }

    @Pointcut(value = "execution(* com.AOPExample.AOPExample.service.EmployeeService.*(..)) && args(name,empId)")
    public void Pointcut2(String name, String empId) { }

    @Before("Pointcut1(name, empId)")
    public void PointcutBefore1(JoinPoint joinPoint, String name, String empId) {
        System.out.println("Before method1:" + joinPoint.getSignature());
        System.out.println("Successfully created Employee with name - " + name + " and id - " + empId);
    }

    @After("Pointcut1(name, empId)")
    public void PointcutAfter1(JoinPoint joinPoint, String name, String empId) {
        System.out.println("After method1:" + joinPoint.getSignature());
        System.out.println("Successfully created Employee with name - " + name + " and id - " + empId);
    }


    @Before("Pointcut2(name, empId)")
    public void PointcutBefore2(JoinPoint joinPoint, String name, String empId) {
        System.out.println("Before method2:" + joinPoint.getSignature());
        System.out.println("Successfully created Employee with name - " + name + " and id - " + empId);
    }

    @After("Pointcut2(name, empId)")
    public void PointcutAfter2(JoinPoint joinPoint, String name, String empId) {
        System.out.println("After method2:" + joinPoint.getSignature());
        System.out.println("Successfully created Employee with name - " + name + " and id - " + empId);
    }


}
