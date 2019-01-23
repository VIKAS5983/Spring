package org.vikas2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Circle implements Shape {
	
	private Point center; 
	
	@Override
	public void draw() {
		System.out.println("Drawing Circle");
		System.out.println("center point is: ("+ center.getX()+" , "+ center.getY()+")");
	}

	public Point getCenter() {
		return center;
	}

	//Required will make sure the ceneter is passed wile initilaizing the bean 
	//To validate the required annotation the bean must call a bean post processor, since this validates the annotations  
	//@Required
/*	
	@Autowired
	@Qualifier("circleRelated")
*/
	@Resource(name="pointC")
	public void setCenter(Point center) {
		this.center = center;
		System.out.println("Setting the center");
	}

	//this gonna gets executed just after the construction of the bean
	@PostConstruct
	public void initializeCircle(){
		System.out.println("Call in initialize");
	}

	//This gonna gets executed just before destroyed. Dependent of the application context shutdownhook
	@PreDestroy
	public void destroyCircle(){
		System.out.println("Call in destroy circle");
	}

}
