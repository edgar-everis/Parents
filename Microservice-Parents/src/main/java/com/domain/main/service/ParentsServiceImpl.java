package com.domain.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.main.model.Parents;
import com.domain.main.repository.ParentsRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ParentsServiceImpl implements ParentsService{

	@Autowired
	private ParentsRepository parentsrepository;
	
	@Override
	public Flux<Parents> getAll() {
		// TODO Auto-generated method stub
		return parentsrepository.findAll();
	}

	

	@Override
	public Mono<Parents> createParents(Parents parents) {
		// TODO Auto-generated method stub
		return parentsrepository.save(parents);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		System.out.println("eliminado");
		return parentsrepository.deleteById(id);
	}



	@Override
	public Flux<Parents> findByIdstudent(String idstudent) {
		// TODO Auto-generated method stub
		return parentsrepository.findByIdstudent(idstudent);
	}



	@Override
	public Mono <Parents> findbyidparent(String id) {
		// TODO Auto-generated method stub
		return parentsrepository.findById(id);
	}



	@Override
	public Flux<Parents> findByIdfamily(String idfamily) {
		// TODO Auto-generated method stub
		return parentsrepository.findByIdfamily(idfamily);
	}



	@Override
	public Mono<Parents> Modifyparents(String id, Parents parents) {
		// TODO Auto-generated method stub
		parents.setId(id);
		return parentsrepository.save(parents);
	}

}
