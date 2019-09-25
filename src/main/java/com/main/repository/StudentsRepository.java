package com.main.repository;

import java.time.LocalDate;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.main.model.Students;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface StudentsRepository extends ReactiveMongoRepository<Students, String> {

	Mono<Students> findByFullname(String fullname);

	Mono <Students> findByDocument(String document);

	Flux<Students> findByBirthdateBetween(LocalDate from, LocalDate to);
}
