package org.vikas;

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
		
/*  - - Without using spring 
 * 		Traingle t=new Traingle();
		t.draw();
*/		
		
		
		//Why are we actually doing this ?? 
		// Advantage is actually visible in the more complex objects where it makes the intializing of the objects easy 
		
//		Resource resource=new FileSystemResource("spring.xml");
//		BeanFactory b=new XmlBeanFactory(resource);
	//		Triangle tr=(Triangle)b.getBean("triangle");

		//Similar thing can done from the application context.xml
		//which has some additional functionalities of aop and event notification
		

		//In this case spring.xml should be avaiable at the classpath under src folder
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("spring2.xml");
		context.registerShutdownHook();
		Triangle tr=(Triangle)context.getBean("triangle2");

		tr.draw();
	}
}
