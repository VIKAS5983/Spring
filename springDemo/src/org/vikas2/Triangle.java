package org.vikas2;

import java.util.List;

import javax.security.auth.DestroyFailedException;
import javax.security.auth.Destroyable;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;

public class Triangle implements Shape{

	// Object injection
	
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	private List<Point> points;
	// We will use spring to initialize all the three points 
	private ApplicationContext context;

	public Point getPointB() {
		return pointB;
	}
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
	public Point getPointA() {
		return pointA;
	}
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	public Point getPointC() {
		return pointC;
	}
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
		
	public void draw(){
		System.out.println("Drawing a triangle");
		System.out.println("Points are\n pointA:"+ pointA+"\n pointB:"+ pointB+"\n pointC:"+ pointC);
		
		if(points!=null)
		for(int i=0;i<points.size();i++){
			System.out.print(points.get(i).toString()+ " ");
		}
	}
	public List<Point> getPoints() {
		return points;
	}
	public void setPoints(List<Point> points) {
		this.points = points;
	}

}
