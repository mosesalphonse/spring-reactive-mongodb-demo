package com.moses.spring.mongodb.reactive.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.moses.spring.mongodb.reactive.model.Terminal;

import reactor.core.publisher.Flux;

@Repository
public interface TerminalRepository extends ReactiveMongoRepository<Terminal, String> {
  Flux<Terminal> findByEnabled(boolean enabled);

  Flux<Terminal> findByNameContaining(String name);
}
