package org.vikas;

public class Triangle {
	private String type;
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
}
