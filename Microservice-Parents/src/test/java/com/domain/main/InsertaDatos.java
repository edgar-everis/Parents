package com.domain.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.domain.main.model.Parents;

import com.domain.main.repository.ParentsRepository;


import reactor.core.publisher.Flux;

@Component
public class InsertaDatos implements CommandLineRunner {

	@Autowired
	private ParentsRepository parentrepository;
	private Logger log = LoggerFactory.getLogger(this.getClass());
	

	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		  
		    	 parentrepository.deleteAll();
		      Flux.just(
		          new Parents("1","Pedro","M","05/02/1990","dni","3333333","1", "Perez"),
		          new Parents("2","Ana","F","06/02/1987","dni","22222222","1", "Perez"),
		          new Parents("3","Juan","M","05/02/1992","dni","4444444","1", "Perez"),
		          new Parents("4","Marcos","M","02/07/1990","dni","77777777","2", "Ruiz"),
		          new Parents("5","Andrea","F","09/02/1987","dni","99999999","2", "Ruiz"),
		          new Parents("6","Andres","M","01/02/1990","dni","11111111","2", "Ruiz")
		         )
		        .flatMap(parentrepository::save)
		        .subscribe(Parents -> log.info("Parents: {}", Parents));

		    };
	}


