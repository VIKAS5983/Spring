package org.vikas2;

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
	
	@Autowired
	@Qualifier("circleRelated")
	public void setCenter(Point center) {
		this.center = center;
		System.out.println("Setting the center");
	}

}
