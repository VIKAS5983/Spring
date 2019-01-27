package com.vikas;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vikas.service.ShapeService;

public class AOPMain {

	public static void main(String argsp[]){
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		//this way of getting the bean doesn't need any class casting 
		//we should pass the class name as an argument 
		ShapeService shp=ctx.getBean("shapeService",ShapeService.class);
		shp.getCircle().setName("CircleName");

		shp.getCircle().setNameAndReturn("CircleName");
	
		//This is the core spring 
		System.out.println(shp.getCircle().getName());


		
		//The above thing can be done by the Aspects 
		//  we can define the aspect which gets a call  
		//when ever the getName() of the class gets called 
		
		//After creating the aspect, the name is getting printer automatically.
		//Same would work for Triangle class too.
	}
}
