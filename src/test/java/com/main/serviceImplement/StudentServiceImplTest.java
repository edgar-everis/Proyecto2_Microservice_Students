package com.main.serviceImplement;

import static org.junit.Assert.*;
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

import com.main.model.Students;

import com.main.repository.StudentsRepository;
import com.main.serviceimplement.StudentServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class StudentServiceImplTest {

    @Mock private StudentsRepository Repository;

    @InjectMocks private StudentServiceImpl Service;
    
  @Test
  public void testCreateStudent() {
      LocalDate date = LocalDate.parse("2018-05-05");
      Students student = new Students();
      student.setId("1");
      student.setFullname("Pedro");
      student.setGender("M");
      student.setBirthdate(date);
      student.setTypedoc("dni");
      student.setDocument("555555");
      when(Repository.save(student)).thenReturn(Mono.just(student));
      Mono<Students> actual = Service.createStudent(student);
      assertResults(actual, student);
  }

  @Test
  public void testDeleteById() {
      LocalDate date = LocalDate.parse("2018-05-05");
      Students student = new Students();
      student.setId("1");
      student.setFullname("Carlos");
      student.setBirthdate(date);
      student.setGender("M");
      student.setTypedoc("dni");
      student.setDocument("111111");
      when(Repository.delete(student)).thenReturn(Mono.empty());
  }

  @Test
  public void testFindByBirthdateBetween() {
      Students stu = new Students();
      stu.setId("1");
      stu.setFullname("Pedro");
      stu.setBirthdate(LocalDate.of(1996, 05, 05));
      stu.setGender("M");
      stu.setTypedoc("dni");
      stu.setDocument("999999");
      when(Repository.findByBirthdateBetween(LocalDate.of(1991, 05, 05), LocalDate.of(2000, 05, 02)))
          .thenReturn(Flux.just(stu));
      Flux<Students> actual =
          Service.findByBirthdateBetween(LocalDate.of(1991, 05, 05), LocalDate.of(2000, 05, 02));
      assertResults(actual, stu);
  }

  @Test
  public void testFindByDocument() {
      LocalDate date = LocalDate.parse("2018-05-05");
      Students stu = new Students();
      stu.setId("1");
      stu.setFullname("Carlos");
      stu.setBirthdate(date);
      stu.setGender("M");
      stu.setTypedoc("M");
      stu.setDocument("555555");

      when(Repository.findByDocument("111111")).thenReturn(Mono.just(stu));
      Mono<Students> actual = Service.findByDocument("111111");
      assertResults(actual, stu);
  }

  @Test
  public void testFindByFullname() {
      LocalDate date = LocalDate.parse("2018-05-05");
      Students teacher = new Students();
      teacher.setId("3");
      teacher.setFullname("Andres");
      teacher.setBirthdate(date);
      teacher.setGender("M");
      teacher.setDocument("888888");
      teacher.setTypedoc("dni");

      when(Repository.findByFullname("Andres")).thenReturn(Mono.just(teacher));
      Mono<Students> actual = Service.findByFullname("Andres");
      assertResults(actual, teacher);
      System.out.println(actual);
      System.out.println(teacher.getFullname());
  }

  @Test
  public void testFindbyId() {
      LocalDate date = LocalDate.parse("2018-05-05");
      Students stu = new Students();
      stu.setId("4");
      stu.setFullname("Andres");
      stu.setBirthdate(date);
      stu.setGender("M");
      stu.setDocument("888888");
      stu.setTypedoc("dni");

      when(Repository.findById("4")).thenReturn(Mono.just(stu));
      Mono<Students> actual = Service.findbyId("4");
      assertResults(actual, stu);
      System.out.println(actual);
      System.out.println(stu.getFullname());
  }

  @Test
  public void testGetAll() {
      LocalDate date = LocalDate.parse("2018-05-05");
      Students stu = new Students();
      stu.setId("1");
      stu.setFullname("Andres");
      stu.setGender("M");
      stu.setBirthdate(date);
      stu.setTypedoc("dni");
      stu.setDocument("555555");
      when(Service.getAll()).thenReturn(Flux.just(stu));
      Flux<Students> actual = Service.getAll();
      assertResults(actual, stu);
  }

 
 

  private void assertResults(Publisher<Students> publisher, Students... expectedProducts) {
    StepVerifier.create(publisher).expectNext(expectedProducts).verifyComplete();
  }
}
