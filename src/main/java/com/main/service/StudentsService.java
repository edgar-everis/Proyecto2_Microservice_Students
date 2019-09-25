package com.main.service;

import java.time.LocalDate;

import com.main.model.Students;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentsService {


	
	Flux<Students> getAll();

	Mono<Students> findByFullname(String fullname);

	Mono<Students> findByDocument(String document); 

	Flux<Students>findByBirthdateBetween(LocalDate from, LocalDate to);	

	Mono<Students> createStudent( Students student);

	Mono<Students> modifyStudent(String id, Students student);

	Mono<Void> deleteById(String id);

	Mono<Students> findbyId(String id);
}
