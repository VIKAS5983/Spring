package org.vikas;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class DisplayBeanNamePostProcessor implements BeanPostProcessor{

	
	//We should return the same object back
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String name)
			throws BeansException {
		System.out.println("In After Initialization method, Bean Name is " + name);

		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String name)
			throws BeansException {

		System.out.println("In Before Initialization method. Bean name is " + name );
		
		return bean;
	}

}
