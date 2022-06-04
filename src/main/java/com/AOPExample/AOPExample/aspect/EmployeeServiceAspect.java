package com.AOPExample.AOPExample.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeServiceAspect {

    // JoinPoint对象封装了SpringAop中切面方法的信息,在切面方法中添加JoinPoint参数,就可以获取到封装了该方法信息的JoinPoint对象.

    // 這種value表示 在EmployeeService中的所有 包含參數name,empId的方法都會通過這裡
    @Before(value = "execution(* com.AOPExample.AOPExample.service.EmployeeService.*(..)) && args(name,empId)")
    public void beforeAdvice(JoinPoint joinPoint, String name, String empId) {
        System.out.println("Before method:" + joinPoint.getSignature());

        System.out.println("Creating Employee with name - " + name + " and id - " + empId);
    }

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

    @After(value = "execution(* com.AOPExample.AOPExample.service.EmployeeService.*(..)) && args(name,empId)")
    public void afterAdvice(JoinPoint joinPoint, String name, String empId) {
        System.out.println("After method:" + joinPoint.getSignature());

        System.out.println("Successfully created Employee with name - " + name + " and id - " + empId);
    }

    



}
