package com.moses.spring.mongodb.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.moses.spring.mongodb.reactive.model.Terminal;
import com.moses.spring.mongodb.reactive.service.TerminalService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class TerminalController {

  @Autowired
  TerminalService terminalService;

  @GetMapping("/terminals")
  @ResponseStatus(HttpStatus.OK)
  public Flux<Terminal> getAllTerminals(@RequestParam(required = false) String name) {
    System.out.println("Terminals endpoint invooked-- GET");
    if (name == null)
    {
        System.out.println("TerminalService.findAll() :"+terminalService.findAll().toString());
        return terminalService.findAll();
    }
    else
    {
        System.out.println("name :"+name);
        return terminalService.findByNameContaining(name);
    }
      
  }

  @GetMapping("/terminals/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Terminal> getTerminalById(@PathVariable("id") String id) {
    return terminalService.findById(id);
  }

  @PostMapping("/terminals")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Terminal> createTerminal(@RequestBody Terminal terminal) {
    System.out.println("createTerminal Terminal object - POST :"+terminal.toString());
    return terminalService.save(new Terminal(terminal.getCode(), terminal.getName(), false));
  }

  @PutMapping("/terminals/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Terminal> updateTerminal(@PathVariable("id") String id, @RequestBody Terminal terminal) {
    return terminalService.update(id, terminal);
  }

  @DeleteMapping("/terminals/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Mono<Void> deleteTerminal(@PathVariable("id") String id) {
    return terminalService.deleteById(id);
  }

  @DeleteMapping("/terminals")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Mono<Void> deleteAllTerminals() {
    return terminalService.deleteAll();
  }

  @GetMapping("/terminals/enabled")
  @ResponseStatus(HttpStatus.OK)
  public Flux<Terminal> findByEnabled() {
    return terminalService.findByEnabled(true);
  }
}
