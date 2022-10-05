package co.api.rest.bikleek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumoApiRestBikleekApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ConsumoApiRestBikleekApplication.class, args);
	}

	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	        return builder.sources(ConsumoApiRestBikleekApplication.class);
	    }
	
	 @Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }
}
