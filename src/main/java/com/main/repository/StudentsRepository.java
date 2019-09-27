package com.main.repository;

import com.main.model.Students;
import java.time.LocalDate;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface StudentsRepository extends ReactiveMongoRepository<Students, String> {

  Flux<Students> findByBirthdateBetween(LocalDate from, LocalDate to);

  Mono<Students> findByDocument(String document);

  Mono<Students> findByFullname(String fullname);
}
