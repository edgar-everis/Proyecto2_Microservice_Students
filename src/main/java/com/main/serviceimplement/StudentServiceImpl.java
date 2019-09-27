package com.main.serviceimplement;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.Students;
import com.main.repository.StudentsRepository;
import com.main.service.StudentsService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements StudentsService {

  @Autowired private StudentsRepository repository;

  @Override
  public Mono<Students> createStudent(Students student) {
    // TODO Auto-generated method stub
    return repository.save(student);
  }

  @Override
  public Mono<Void> deleteById(String id) {
    // TODO Auto-generated method stub
    return repository.deleteById(id);
  }

  @Override
  public Flux<Students> findByBirthdateBetween(LocalDate from, LocalDate to) {
    // TODO Auto-generated method stub
    return repository.findByBirthdateBetween(from, to);
  }

  @Override
  public Mono<Students> findByDocument(String document) {
    // TODO Auto-generated method stub
    return repository.findByDocument(document);
  }

  @Override
  public Mono<Students> findByFullname(String fullname) {
    // TODO Auto-generated method stub
    return repository.findByFullname(fullname);
  }

  @Override
  public Mono<Students> findbyId(String id) {
    // TODO Auto-generated method stub
    return repository.findById(id);
  }

  @Override
  public Flux<Students> getAll() {
    // TODO Auto-generated method stub
    return repository.findAll();
  }

  @Override
  public Mono<Students> modifyStudent(String id, Students student) {
    // TODO Auto-generated method stub
    student.setId(id);
    return repository.save(student);
  }
}
