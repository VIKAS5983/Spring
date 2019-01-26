package com.vikas.aspects;

import org.aspectj.lang.annotation.AdviceName;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
//We want the below method to get called before the method call of getName from circle class 
//To do that we need to delcare the class as an aspect then every method of the class would 
	//become the advice 

	//Before is the annotation to define the advice when the current advice should run 
	// In the arguemtns we should before which method the current advice should call. 
	//Description: Below advice will get called before execution of the method in the following signature 
	//"public String getName()"
	@Before("execution(public String getName())")
	public void logginAdvice(){
		System.out.println("Advice run. Get Method called");
	}
	
	
	//This gets called only for the circle
	@Before("execution(public String com.vikas.model.Circle.getName())")
	public void loggingAdvice(){
		System.out.println("Advicerun only for circle");
	}
	
	//Using wildcards to get the methods .. like all the setters or all the getters 
	//	@Before("execution(public * get*())")  - this would run for all the public methods starting with get. In this case it gonna run for getCircle(), getName() . 

	//@Before("execution(public String get*())")
	//@Before("execution(* get*())") - If the method contains name starting with get
	//@Before("execution(* get*(..))")- all getters irrespective of the argument count ( 0 or more )
	//@Before("execution(* get*(*))")   - all the getters with one or more argument 
	
	@Before("execution(public * get*(*))")
	public void loggingAdvicewildCard(){
		System.out.println("Advice run with WildCard ");
	}
	
	//If you want to use the same execution expression for all the methods, we can use the pointcuts to reduce the repetation
	
 @Pointcut("execution(* get*())") //We are defining the expression only once
 public void allGetters(){//this is dummy method
	 
 }

 @Pointcut("execution(* com.vikas.model.Circle.*(..))") //We are defining the expression only once
 public void allCircleMethods(){//this is dummy method
	 
 }

 //This point cut would apply to all the methods of the circle 
@Pointcut("within(com.vikas.model.Circle)")
public void allCircleMethods2(){
}

//This pointcut would apply to all the subpackage classes contained	  inside the model package
//@Pointcut("within(com.vikas.model..*)")-> 
//Double dot indicate to apply the pointcut to all the sub-packages and classes of it too

//This pointcut would apply to all the classes inside the model package
@Pointcut("within(com.vikas.model.*)")
public void allModelClasses(){
}


 //Making use of point cut to call the adivice method before every getter
 @Before("allGetters()")
 public void pointCut1(){
	 System.out.println("point Cut 1 Method is called ");
 }
 
 //We are making use of the pointcut to call the advice method 
 @Before("allGetters()")
 public void pointCut2(){
	 System.out.println("point Cut 2 Method is called ");
 }
@Before("allCircleMethods()")
 public void circleMethodLog(){
	 System.out.println("CircleMethod is called");
 }
 
//This pointcut would be applied to all the methods which satify both the point cuts 
//Implies getter method inside the Circle class only  
@Before("allCircleMethods() && allGetters()")
public void allGetersOfCricleClassMethods(){
	System.out.println("All Getters of Circle Class Methods ");
}

}
