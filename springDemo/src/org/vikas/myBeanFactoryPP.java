package org.vikas;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

  
public class myBeanFactoryPP implements BeanFactoryPostProcessor {

	
	// This gonna run before bean Factory gonna initialize
	// This would get called even with the application context as it
	//includes the beanfactory underneat with some additional functinalities
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
			throws BeansException {
		System.out.println("Bean Factory Post Processing is called " + beanFactory.getSingletonCount());
		
	}

}
