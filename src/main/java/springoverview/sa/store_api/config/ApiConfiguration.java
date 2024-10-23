package springoverview.sa.store_api.config;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration

public class ApiConfiguration {
	@Bean("getlocalDateTime")
	@Scope("request")
	public LocalDateTime initDate(){
		return LocalDateTime.now();
	}
	
	@Bean("initialLocalDate")
	@Scope("singleton")
	public LocalDateTime getTime(){
		return LocalDateTime.now();
	}
}