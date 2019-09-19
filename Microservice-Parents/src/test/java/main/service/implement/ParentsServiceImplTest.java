package main.service.implement;


import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.reactivestreams.Publisher;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import main.model.Parents;
import main.repository.ParentsRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


@RunWith(SpringRunner.class)
@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ParentsServiceImplTest {

    @Mock
    private ParentsRepository parentRepository;
    
    @InjectMocks
    private ParentsServiceImpl parentService;

    @Test
    public void getAll() {
        Parents parent = new Parents();
       
        when(parentService.getAll()).thenReturn(Flux.just(parent));
        Flux<Parents> actual = parentService.getAll();
        assertResults(actual, parent);
    }
    
    @Test
    public void findByIdstudent() {
    	LocalDate birthday = LocalDate.parse("1987-05-02");
    	Parents parent = new Parents();
       parent.setId("1");
       parent.setFullname("Marcos");
       parent.setBirthday(birthday);
       parent.setGender("m");
       parent.setIdstudent("1");
       parent.setIdfamily("Romero");
       parent.setTypedoc("dni");
       parent.setDocument("6666666");
       
         when(parentRepository.findByIdstudent("1")).thenReturn(Flux.just(parent));
         Flux<Parents> actual = parentService.findByIdstudent("1");
         assertResults(actual,parent);
         System.out.println(actual);
         System.out.println(parent.getFullname());
    }
    
    @Test
    public void findByIdparent() {
    	LocalDate birthday = LocalDate.parse("1987-05-02");
    	Parents parent = new Parents();
       parent.setId("2");
       parent.setFullname("Morfeo");
       parent.setBirthday(birthday);
       parent.setGender("M");
       parent.setIdstudent("1");
       parent.setIdfamily("Romero");
       parent.setTypedoc("dni");
       parent.setDocument("44782165");
       
         when(parentRepository.findById("2")).thenReturn(Mono.just(parent));
         Mono<Parents> actual = parentService.findByIdparent("2");
         assertResults(actual,parent);
         System.out.println(actual);
         System.out.println(parent.getFullname());
    }
    
    @Test
    public void save() {
    	LocalDate birthday = LocalDate.parse("1987-05-02");
    	Parents parent = new Parents();
        parent.setId("4");
        parent.setFullname("Neo");
        parent.setBirthday(birthday);
        parent.setGender("m");
        parent.setIdfamily("Crespo");
        parent.setIdstudent("5");
        parent.setTypedoc("dni");
        parent.setDocument("333333");
       
        when(parentRepository.save(parent)).thenReturn(Mono.just(parent));
        Mono<Parents> actual = parentService.createParents(parent);
        assertResults(actual, parent);
    }
    
    @Test
    public void findByIdfamily() {
    	LocalDate birthday = LocalDate.parse("1987-05-02");
    	Parents parent = new Parents();
       parent.setId("1");
       parent.setFullname("Marcos");
       parent.setBirthday(birthday);
       parent.setGender("m");
       parent.setIdstudent("1");
       parent.setIdfamily("Ospina");
       parent.setTypedoc("dni");
       parent.setDocument("6666666");
       
         when(parentRepository.findByIdfamily("Ospina")).thenReturn(Flux.just(parent));
         Flux<Parents> actual = parentService.findByIdfamily("Ospina");
         assertResults(actual,parent);
         System.out.println(actual);
         System.out.println(parent.getFullname());
    }
    
    @Test
    public void Delete() {
    	LocalDate birthday = LocalDate.parse("1987-05-02");
        Parents parent = new Parents();
        parent.setId("1");
        parent.setFullname("Jorge");
        parent.setBirthday(birthday);
        parent.setIdfamily("Romero");
        parent.setTypedoc("dni");
        parent.setGender("M");
        parent.setIdstudent("1");
        parent.setDocument("666666");
        when(parentRepository.delete(parent)).thenReturn(Mono.empty());
    }
    
    
    
    private void assertResults(Publisher<Parents> publisher, Parents... expectedProducts) {
        StepVerifier
            .create(publisher)
            .expectNext(expectedProducts)
            .verifyComplete();

}
}
