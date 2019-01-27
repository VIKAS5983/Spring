package com.vikas.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect2 {
	
	 @Pointcut("execution(* get*())") //We are defining the expression only once
	 public void allGetters(){//this is dummy method
		 
	 }

	//ProceedingJoingPoint is a cumplsory argument for around advice
	 @Around("allGetters()")
	 public Object adviceAround(ProceedingJoinPoint pjp) {
		 System.out.println("Write the code to check the conditions of the method");
		 Object returnValue=null;
		 System.out.println("Beofre advice execution completed");
		 System.out.println("Run the method now");
		 //If we want to check some precondition we check and skip the execution if needed
		 try{
			
		 returnValue=pjp.proceed();//This executes the actual method to which advice applies to
		 			 
		 } catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("Method run completed");
		 System.out.println("Now do this required for after advice run");
		 //You can modify the return value now and send a different thing if required. 
		 //This is not possible with the @Ater advice.Only around advice can modify the return value 
		 
		 return returnValue;
	 }
	
	 
	 //This advice would apply to all the methods which has the @Loggable Annotation
	 @Before("@annotation(com.vikas.aspects.Loggable)")
	public void customAnnotationAdvice(){
		System.out.println("Customer annotation");
	}
}
