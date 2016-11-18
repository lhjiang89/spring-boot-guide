/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package hello.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * ClassName: MyAspect Function: TODO
 *
 * @Author: ljiang
 * @Date: Nov 15, 2016 3:40:57 PM
 */
@Aspect
@Component
@EnableAspectJAutoProxy
public class MyAspect {

	@Around(value = "@annotation(hello.aop.PerfLogging)")
	public Object around(ProceedingJoinPoint pjp) {
		long start = System.currentTimeMillis();
		try {
			return pjp.proceed();
		} catch (Throwable e) {
			return null;
		} finally {
			System.out.println("cost " + (System.currentTimeMillis() - start));
		}
	}

	@AfterReturning("execution(* hello.aop.AOPTestController.*(..))")
	public void doAfterReturning(JoinPoint jp) throws Throwable {
		System.out.println("Completed: " + jp);
	}
}
