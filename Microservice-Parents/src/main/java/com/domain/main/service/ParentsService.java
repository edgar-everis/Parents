package com.domain.main.service;
import com.domain.main.model.Parents;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ParentsService {

    Flux<Parents> getAll();
	
    Flux<Parents> findByIdstudent(String idstudent);
    
    Mono <Parents> findbyidparent(String id);
	
    Mono<Parents> Modifyparents(String id,Parents parents);
    
	Mono<Parents> createParents( Parents parents);
  
	Mono<Void> deleteById(String id);
	
	Flux<Parents> findByIdfamily(String  idfamily);
}
