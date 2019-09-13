package com.domain.main;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.domain.main.controller.ParentsController;
import com.domain.main.model.Parents;
import com.domain.main.service.ParentsServiceImpl;
import reactor.core.publisher.Flux;



@ExtendWith(SpringExtension.class)
class ParentTestController {

	  @Mock
	  private ParentsServiceImpl parentservice;
	  private WebTestClient client;
	  private List <Parents> expectedparents;
	
	
	@BeforeEach
	void setUp() throws Exception {
		client = WebTestClient
		        .bindToController(new ParentsController(parentservice))
		        .configureClient()
		        .baseUrl("/API/Parents")
		        .build();
		
				expectedparents = Arrays.asList(
			
			Parents.builder().id("1").fullname("Marcos").gender("m").birthday("05/04/1987").Type_doc("dni").document("99999").idstudent("1").idfamily("perez").build(),
			Parents.builder().id("2").fullname("Helena").gender("f").birthday("03/04/1987").Type_doc("dni").document("777779").idstudent("1").idfamily("perez").build(),
			Parents.builder().id("3").fullname("Juan").gender("m").birthday("05/04/1987").Type_doc("dni").document("66666666").idstudent("1").idfamily("perez").build(),
			Parents.builder().id("4").fullname("Erick").gender("m").birthday("07/04/1987").Type_doc("dni").document("7777777").idstudent("2").idfamily("Alvarado").build(),
			Parents.builder().id("5").fullname("Marcela").gender("f").birthday("05/04/1987").Type_doc("dni").document("66666666").idstudent("2").idfamily("Alarado").build(),
			Parents.builder().id("6").fullname("Pepe").gender("m").birthday("05/04/1990").Type_doc("dni").document("44444444").idstudent("2").idfamily("Alvarado").build());
	}

	@Test
	void testGetall() {
		when(parentservice.getAll()).thenReturn(Flux.fromIterable(expectedparents));

	    client.get().uri("/").exchange()
	        .expectStatus().isOk()
	        .expectBodyList(Parents.class).isEqualTo(expectedparents);
	}

	@Test
	void testFindbyname() {
		
	}

	@Test
	void testFindbyfamily() {
		
	}

	@Test
	void testFindbyid() {
		
	}

	@Test
	void testCreateStudent() {
		
	}

	@Test
	void testUpdateStudent() {
		
	}

	@Test
	void testDeleteStudents() {
		
	}

}
