package com.moses.spring.mongodb.reactive.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moses.spring.mongodb.reactive.model.Terminal;
import com.moses.spring.mongodb.reactive.repository.TerminalRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TerminalService {

  @Autowired
  TerminalRepository terminalRepository;

  public Flux<Terminal> findAll() {
    System.out.println("terminalRepository.findAll() :"+terminalRepository.findAll().toString());    
    return terminalRepository.findAll();
  }

  public Flux<Terminal> findByNameContaining(String name) {
    return terminalRepository.findByNameContaining(name);
  }

  public Mono<Terminal> findById(String id) {
    return terminalRepository.findById(id);
  }

  public Mono<Terminal> save(Terminal terminal) {
    System.out.println("TerminalService save called :"+terminal.toString());
    return terminalRepository.save(terminal);
  }

  public Mono<Terminal> update(String id, Terminal terminal) {
    return terminalRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
        .flatMap(optionalTerminal -> {
          if (optionalTerminal.isPresent()) {
            terminal.setId(id);
            return terminalRepository.save(terminal);
          }

          return Mono.empty();
        });
  }

  public Mono<Void> deleteById(String id) {
    return terminalRepository.deleteById(id);
  }

  public Mono<Void> deleteAll() {
    return terminalRepository.deleteAll();
  }

  public Flux<Terminal> findByEnabled(boolean isEnabled) {
    return terminalRepository.findByEnabled(isEnabled);
  }
}
