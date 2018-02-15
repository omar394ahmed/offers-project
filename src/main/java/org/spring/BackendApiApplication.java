package org.spring;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.spring.images.*;




@SpringBootApplication
public class BackendApiApplication   extends SpringBootServletInitializer   {
	
	
	
	public static void main(String[] args) {
		
	  //  StorageService.welcome_method();
		StorageService.deleteAll();
		StorageService.init();
		SpringApplication.run(BackendApiApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder ) {
		// TODO Auto-generated method stub
		
		return builder.sources(BackendApiApplication.class);
	}

	


	
	
	
	
	
	
}
