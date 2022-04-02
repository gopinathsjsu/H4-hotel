package com.cmpe202.hotels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Map;
import java.util.logging.Logger;


@SpringBootApplication
public class HotelsApplication {

	private static Logger logger = Logger.getLogger(HotelsApplication.class.getName());
	public static void main(String[] args) {
		SpringApplication.run(HotelsApplication.class, args);


	}

	@EventListener
	public void handleContextRefresh(ContextRefreshedEvent event) {
		ApplicationContext applicationContext = event.getApplicationContext();
		RequestMappingHandlerMapping requestMappingHandlerMapping = applicationContext
				.getBean("requestMappingHandlerMapping", RequestMappingHandlerMapping.class);
		Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping
				.getHandlerMethods();
		map.forEach((key, value) -> logger.info("key = " + key + ", value=" + value));
	}

	@EventListener
	public void showBeansRegistered(ApplicationReadyEvent event) {
		String[] beanNames = event.getApplicationContext()
				.getBeanDefinitionNames();

		for(String beanName: beanNames) {
			logger.info("bean = " + beanName);
		}
	}

}
