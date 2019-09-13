package com.domain.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.domain.main.model.Parents;

import com.domain.main.service.ParentsService;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/API/Parents")
public class ParentsController {

	 
	private  ParentsService parentservice;
	
	@Autowired
	public ParentsController(ParentsService parentservice) {
		// TODO Auto-generated constructor stub
		this.parentservice = parentservice;
	}

	//Lista todos los estudiantes
	@GetMapping
	public Flux<Parents> getall()
	{
		return parentservice.getAll();
	}
	
	//Lista los estudiantes por nombre
	@GetMapping("/idstudent/{id}")
	public Flux <Parents> findbyname(@PathVariable String id)
	{
		return parentservice.findbyidstudent(id);
	}
	
	//Lista los estudiantes por familia
		@GetMapping("/family/{fam}")
		public Flux <Parents> findbyfamily(@PathVariable String fam)
		{
			return parentservice.findbyidfamilyt(fam);
		}
	
	
	
	//Busqueda por id de parientes
	@GetMapping("/FindParents/{id}")
	public Mono <Parents> findbyid(@PathVariable String fam)
	{
		return parentservice.findbyidparent(fam);
	}
	
	//Crea un nuevo pariente
	@PostMapping("/Parents/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Parents> createStudent(@RequestBody Parents parents)
	{
		return parentservice.createParents(parents);
		
	}
	
	//Actualiza un pariente
		@PutMapping("/update/{id}")
		public Mono<Parents> updateStudent(@PathVariable String id,@RequestBody Parents parents)
		{
		return parentservice.Modifyparents(id, parents);
			}
	
		//Elimina un pariente
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteStudents(@PathVariable String id) {
		
		return parentservice.deleteById(id);
	}
	
	
}
