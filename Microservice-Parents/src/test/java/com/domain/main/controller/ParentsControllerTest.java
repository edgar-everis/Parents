package com.domain.main.controller;

import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.domain.main.model.Parents;

import com.domain.main.service.ParentsService;

import reactor.core.publisher.Mono;




@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParentsControllerTest {

	@Autowired
	private WebTestClient client;
	
	@Autowired
	private ParentsService service;
	
	
	
	@Test
	public void testGetall() {
		
		client.get().uri("/API/Parents")
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		.expectBodyList(Parents.class)
		.consumeWith(response -> {
            List<Parents> parents = response.getResponseBody();
            parents.forEach(p -> {
                System.out.println(p.getFullname());
            });

            Assertions.assertThat(parents.size()>0).isTrue();
		  });
	}

	
	
	@Test
	public void testFindbyId() {
		Parents pa = service.findByIdstudent("1").blockFirst();
        client.get()
                .uri("/API/Parents" + "/idstudent/{id}", Collections.singletonMap("id", pa.getId()))
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBodyList(Parents.class)
                .consumeWith(response -> {
                    List<Parents> parents = response.getResponseBody();
                    parents.forEach(p -> {
                        System.out.println(p.getFullname());
                    });

                    Assertions.assertThat(parents.size()>0).isTrue();
        		  });
	}

	
	
	@Test
	public void testFindbyIdfamily() {
		
		Parents pa = service.findByIdfamily("Perez").blockFirst();
        client.get()
                .uri("/API/Parents" + "/family/{fam}", Collections.singletonMap("fam", pa.getIdfamily()))
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBodyList(Parents.class)
                .consumeWith(response -> {
                    List<Parents> parents = response.getResponseBody();
                    parents.forEach(p -> {
                        System.out.println(p.getFullname());
                    });

                    Assertions.assertThat(parents.size()>0).isTrue();
        		  });
	}

	@Test
	public void testFindbyid() {
		Parents stu = service.findbyidparent("1").block();
        client.get()
                .uri("/API/Parents" + "/FindParents/{id}", Collections.singletonMap("id", stu.getId()))
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBody(Parents.class)
                .consumeWith(response -> {
                    Parents s = response.getResponseBody();
                    Assertions.assertThat(s.getFullname()).isNotEmpty();
                    Assertions.assertThat(s.getFullname().length()>0).isTrue();
                    System.out.println(s.getFullname());

                });
	}

	@Test
	public void testCreateParents() {
		Parents stu = new Parents("7","Javier","M","02/05/1987","dni","8888888","1","Roman");

        client.post().uri("/API/Parents/Parents/create")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(stu), Parents.class)
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBody()
        		.jsonPath("$.id").isNotEmpty()
        		.jsonPath("$.fullname").isEqualTo("Javier");
        		System.out.println(stu.getFullname());
	}

	@Test
	public void testUpdateParents() {
		Parents parents = service.findbyidparent("1").block();


        Parents editparents = new Parents("1", "Neo","M","02/05/1987","dni","999999","1","Roman");

        client.put().uri("/API/Parents" + "/update/{id}", Collections.singletonMap("id", parents.getId()))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(editparents), Parents.class)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBody()
                .jsonPath("$.id").isNotEmpty()
                .jsonPath("$.id").isEqualTo("1")
                ;
	}

	@Test
	public void testDeleteParents() {
		Parents par = service.findbyidparent("1").block();
        client.delete()
                .uri("/API/Parents" + "/delete/{id}", Collections.singletonMap("id", par.getId()))
                .exchange()
                .expectStatus().isNoContent()
                .expectBody()
                .isEmpty();
	}

}
