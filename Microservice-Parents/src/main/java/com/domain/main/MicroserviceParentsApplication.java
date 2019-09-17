package com.domain.main;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;
//import org.springframework.context.annotation.Bean;
//import com.domain.main.model.Parents;
//import com.domain.main.repository.ParentsRepository;
//import reactor.core.publisher.Flux;
@EnableSwagger2WebFlux
@SpringBootApplication
public class MicroserviceParentsApplication {
	
	/*
	private Logger log = LoggerFactory.getLogger(this.getClass());
	 
	
	@Bean
	  CommandLineRunner start(ParentsRepository parentsrepository){
		
	    return args -> {
	    	 parentsrepository.deleteAll();
	      Flux.just(
	          new Parents("1","Marcos","M","02/05/1987","dni","123456","1","Perez"),
	          new Parents("2","Helena","f","02/05/1987","dni","999999","1","Perez"),
	          new Parents("3","Juan","M","02/05/1987","dni","888888","1","Perez"),
	          new Parents("4","Marcos","M","02/05/1987","dni","123456","2","Perez"),
	          new Parents("5","Helena","f","02/05/1987","dni","999999","2","Perez"),
	          new Parents("6","Juan","M","02/05/1987","dni","888888","2","Perez"),
	          new Parents("7","Pedro","M","02/05/1987","dni","123456","3","Alvarado"),
	          new Parents("8","Ines","f","02/05/1987","dni","999999","3","Alvarado"),
	          new Parents("9","Pablo","M","02/05/1987","dni","888888","3","Alvarado"),
	          new Parents("10","Pedro","M","02/05/1987","dni","123456","4","Alvarado"),
	          new Parents("11","Ines","f","02/05/1987","dni","999999","4","Alvarado"),
	          new Parents("12","Pablo","M","02/05/1987","dni","888888","4","Alvarado")
	         )
	        .flatMap(parentsrepository::save)
	        .subscribe(Parents -> log.info("Parents: {}", Parents));

	    };
	  }*/
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceParentsApplication.class, args);
	}

}
