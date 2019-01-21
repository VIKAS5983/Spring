package org.vikas;

import java.util.List;

import javax.security.auth.DestroyFailedException;
import javax.security.auth.Destroyable;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;

public class Triangle implements ApplicationContextAware, BeanNameAware,InitializingBean,Destroyable{

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
		System.out.println("Points are\n pointA:"+ pointA+"\n pointB:"+ pointB+"\n pointC:"+ pointC);
		
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


	//Way to get the reference for context of the current object
	//This helps us to get the prototype based inner beans for the single top parent class bean 
	// In this case Triangle is a singleton bean and pointA, pointB, pointC are the prototype beans
	// Using context we can get the different prototyped beans initialze the inner attributes for 
	//every request of the Triangle
	
	//This method gets called when triangle bean get loaded to the container 
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {

		this.context=arg0;
	}
	
	//Similar to above we can get the bean from using the beanNameAware interface 
	//which internally calls the setBeanNamemethod 
	
	@Override
	public void setBeanName(String arg0) {

			System.out.println("Bean name is "+ arg0);		
	}
	
	 //This would get called only when the abstractapplication context is registered hook up with the shutdown
	//Same can be acheived using the annotatoins. 
	@Override
	public void destroy() throws DestroyFailedException {

		System.out.println("DEstroyed the bean. This is called after deploying the bean");
	}
	
	
	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	//This would get called after loading the properties to the bean
	//Same can be acheived using the annotatoins. 
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("This is getting called after loaing the properties of the beans i.e after bean initialization");	
	
	}


}
