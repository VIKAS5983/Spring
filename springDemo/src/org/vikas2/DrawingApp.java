package org.vikas2;

import java.util.Locale;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@SuppressWarnings("deprecation")
public class DrawingApp {

	public static void main(String args[]){
				//This class doesn't know whether we are getting the circle or triangle class.
				// We are just operating on the shape class
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("springForVikas2.xml");	
		context.registerShutdownHook();
		Shape s1=(Shape)context.getBean("circle");
		s1.draw();
 
		//Using the message source to get the data from a properties 
		String greeting=context.getMessage("greetings", null, "default greeting",null );
		
		System.out.println("Greeting loaded "+ greeting);
/*		Shape s2=(Shape)context.getBean("triangle");
		s2.draw();

*/		
	}

}
