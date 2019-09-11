package com.domain.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.domain.main.model.Parents;

import com.domain.main.service.ParentsService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ParentsController {

	@Autowired 
	private  ParentsService parentservice;
	
	//Lista todos los estudiantes
	@RequestMapping("/Parents")
	public Flux<Parents> getall()
	{
		return parentservice.getAll();
	}
	
	//Lista los estudiantes por nombre
	@GetMapping("/Parents/idstudent")
	public Flux <Parents> findbyname(@RequestParam("id") String id)
	{
		return parentservice.findbyidstudent(id);
	}
	
	//Lista los estudiantes por familia
		@GetMapping("/Parents/family")
		public Flux <Parents> findbyfamily(@RequestParam("fam") String fam)
		{
			return parentservice.findbyidfamilyt(fam);
		}
	
	
	
	//Busqueda por id de parientes
	@GetMapping("/Parents/id")
	public Mono <Parents> findbyid(@RequestParam("filtro") String filtro)
	{
		return parentservice.findbyidparent(filtro);
	}
	
	@PostMapping("/Parents/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Parents> createStudent(@RequestBody Parents parents)
	{
		return parentservice.createParents(parents);
		
	}
	
    @DeleteMapping("/Parents/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteStudents(@PathVariable String id) {
		
		return parentservice.deleteById(id);
	}
	
	
}
