package com.main.service;

import java.time.LocalDate;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.main.model.Students;

public interface StudentsService {

  Mono<Students> createStudent(Students student);

  Mono<Void> deleteById(String id);

  Flux<Students> findByBirthdateBetween(LocalDate from, LocalDate to);

  Mono<Students> findByDocument(String document);

  Mono<Students> findByFullname(String fullname);

  Mono<Students> findbyId(String id);

  Flux<Students> getAll();

  Mono<Students> modifyStudent(String id, Students student);
}
