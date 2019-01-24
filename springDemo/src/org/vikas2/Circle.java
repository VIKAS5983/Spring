package org.vikas2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

//Replacement of the bean declaration in the spring.xml. This would result into a single bean only as below
// 	<bean id="circle" class="org.vikas2.Circle">
//	</bean>

@Component
public class Circle implements Shape {
	
	private Point center; 
	
	// To access the MessageSource at the class level, we can use the autowired concept in this case. 
	@Autowired
	public MessageSource messageSource;
	
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	public void draw() {
		System.out.println("Drawing Circle");
		
		System.out.println(messageSource.getMessage("drawing.circle", null,"Circle drawinDefault",null)+": ("+ center.getX()+" , "+ center.getY()+")");
		
		//System.out.println("point is " + center.getX()+" , "+center.getY());
		//Above statement can be re-write as the below statement which can help in ignoreing the static content
		//We are passing the parameters to the string and internally it would replace the placeholders 
		//Localte parameter would be appending to the flie_name as myMessage_en.properties or myMessage_ar.properties
		//properties would be loaded based on the locale name 
		System.out.println(messageSource.getMessage("drawing.center",new Object[]{center.getX(),center.getY()},"center is ",null));

		System.out.println("Greetin message: " + messageSource.getMessage("greetings", null, "DEfault greeints from circle", null));
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
