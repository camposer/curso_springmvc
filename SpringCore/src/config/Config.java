package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import bean.Envoltorio;
import bean.HelloWorld;
import bean.IHolaMundo;

@Configuration
public class Config {
	@Bean
	public IHolaMundo holaMundo1() {
		return new HelloWorld();
	}

	@Bean
	@Scope("prototype")
	public IHolaMundo holaMundo2() {
		return new HelloWorld();
	}
	
}








