package dmacc.controller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.*;

@Configuration
public class BeanConfiguration {
	@Bean
	public Roster roster() {
		Roster bean = new Roster();
		return bean;
	}

}
