package org.vikas;

import java.util.List;

public class Triangle {
/*	private String type;
	private int height;
	
	//Using the constructor injection in spring.xml we are setting the name of the triangle 
	public Triangle(String type,int height){
		this.type=type;
		this.height=height;
	}
	
	public Triangle(String type){
		this.type=type;
	}
	
	//
	public Triangle(int height){
		this.height=height;
	}

	public int getHeight(){
		return height;
	}
	public String getType(){
		
		return type;
	}
	
	//Using setter injection we are setting the type of the Triangle 
	public void setType(String type){
		this.type=type;
	}
	
	public void draw(){
		System.out.println(type+" Triangle Drawn. Height: "+ height );
	}
	*/
	
	// Object injection
	
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	private List<Point> points;
	// We will use spring to initialize all the three points 

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


}
