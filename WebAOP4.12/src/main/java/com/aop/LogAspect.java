package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 *公司有 个人力资源管理系统目前已经上线，但是系统运行不稳定，有时运行得很慢，为了检
 * 测出到底是哪个环节出问题了，开发人员想要监控每一个方法的执行时间，再根据这些执行时间判
 * 断出问题所在。当问题解决后，再把这些监控移除掉。系统目前己经运行，如果手动修改系统中成
 * 千上万个方法，那么工作量未免太大，而且这些监控方法以后还要移除掉；如果能够在系统运行过
 * 程中动态添加代码，就能很好地解决这个需求。这种在系统运行时动态添加代码的方式称为面向切
 * 面编程 CAOP ）。 Spring 框架对 AOP 提供了很好的支持。在 AOP 中，有一些常见的概念需要读者
 * 了解。
 *
 * • Joinpoint （连接点）：类里面可以被增强的方法即为连接点。例如，想修改哪个方法的功能，
 * 那么该方法就是一个连接点。
 * • Pointcut（切入点）：对 Joinpoint 进行拦截的定义即为切入点，例如，拦截所有以 insert 开始的
 * 方法，这个定义即为切入点。
 * • Advice （通知）：拦截到 Joinpoint 之后所要做的事情就是通知。例如， 上文说到的打印日志
 * 监控 通知分为前置通知、后置通知、异常通知、最终通知和环绕通知。
 * • Aspect （切面）： Pointcut Advice 的结合。
 * • Target （目标对象）：要增强的类称为 Target
 */
//创建切面
@Component//把普通pojo实例化到spring容器中，相当于配置文件中的 泛指各种组件，就是说当我们的类不属于各种归类的时候（不属于@Controller、@Services等的时候），我们就可以使用@Component来标注这个类。
@Aspect//注解表明这是一个切面类
public class LogAspect {
    /**
     * 定义的 pcl 方法使用了＠Pointcut主解，这是一个切入点（Pointcut）定义。execution 中的第一
     * 个＊表示方法返回任意值，第二个＊表示 service 包下的任意类，第三个＊表示类中的任意方法，
     * 括号中的两个点表示方法参数任意，也就是这里描述的切入点Pointcut）为service 包下所有类中的所有方
     * 法。
     */
    @Pointcut("execution(* com.serverlet.*.*(..))")//
//    @Pointcut("execution(* com.aop.service.*.*(..))")
    public void pcl() {
    }

    /**
     * 行定义的方法使用了＠Before 注解，表示这是一个前直通知，该方法在目标方法执行
     * 之前执行。通过 JoinPoint参数可以获取目标方法的方法名、修饰符等信息。
     * @param jp
     */
    @Before(value = "pcl()")
    public void before(JoinPoint jp) {
        String name = jp.getSignature().getName();//获取目标方法的方法名
        System.out.println("方法名："+name + "方法开始执行 ．．．:");
    }

    /**
     * 行定义的方法使用了＠After 注解，表示这是一个后置通知，该方法在目标方法执行之后执行
     * @param jp
     */
    @After(value = "pcl()")
    public void after(JoinPoint jp) {
        String name = jp.getSignature().getName();//获取目标方法的方法名
        System.out.println("方法名："+name + "方法执行结束 ．．．:");
    }


    /**
     * 行定义的方法使用了＠AfterReturning 主解，表示这是一个返回通知，在该方法中可
     * 以获取目标方法的返回值 @AfterReturning 注解的 returning 参数是指返回值的变量名，对应
     * 方法的参数。注意，在方法参数中定义了 result 的类型为 Object ，表示目标方法的返回值可
     * 以是任意类型，若 result 参数的类型为 Long ，则该方法只能处理目标方法返回值为 Long
     * 情况。
     * @param jp
     * @param result
     */
    @AfterReturning(value = "pcl()",returning = "result")//注解的 returning 参数是指返回值的变量名对应方法的参数
    public void afterReturning(JoinPoint jp,Object result) {//
        String name = jp.getSignature().getName();
        System.out.println("方法名："+name + "方法返回值为 :"+result);
    }


    /**
     * 定义的方法使用了 erηrrowing 解， 表示这是一个异常通知 即当目标方法
     * 发生异常时，该方法会被调用，异常类型为 Exception 表示所有的异常都会进入该方法中执
     * 若异常类型为 ArithmeticException 则表示只有目标方法抛出的 ArithmeticException 异常
     * 才会进入该方法中处理
     * @param jp
     * @param e
     *
     * 若异常类型为 ArithmeticException 则表示只有目标方法抛出的 ArithmeticException 异常
     *   才会进入该方法中处理
     */
    @AfterThrowing(value = "pcl()",throwing = "e")
    public void afterThrowing(JoinPoint jp,Exception e) {
        String name = jp.getSignature().getName();
        System.out.println("方法名："+name + "抛出了异常:"+e.getMessage());
    }

    /**
     * Advice（通知）
     *
     * 定义的方法使用了 Around 注解，表示这是一个环绕通知 环绕通知是所有通知
     * 里功能最为强大的通知，可以实现前置通知、后置通知、异常通知以及返回通知的功能
     * 标方法进入环绕通知后 ，通过调用 ProceedingJoinPoint 对象的 proceed 方法使目标方法继续执
     * 行，开发者可以在此修改目标方法的执行参数、返回值等，并且可以在此处理目标方法的异常
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around(value = "pcl()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
//        String name = jp.getSignature().getName();
        System.out.println( "环绕通知 :");
        /**
         *
        通过调用 ProceedingJoinPoint 对象的 proceed 方法使目标方法继续执
                * 行，开发者可以在此修改目标方法的执行参数、返回值等，并且可以在此处理目标方法的异常
         */
         return pjp.proceed();//方法proceed
    }
}