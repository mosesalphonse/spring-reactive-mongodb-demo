package com.moses.spring.mongodb.reactive.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Terminal {

  @Id
  private String id;

  private String code;

  private String name;

  private boolean enabled;

  public Terminal() {

  }

  public Terminal(String code, String name, boolean enabled) {
    this.code = code;
    this.name = name;
    this.enabled = enabled;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  @Override
  public String toString() {
    return "Terminal [id=" + id + ", code=" + code + ", name=" + name + ", enabled=" + enabled + "]";
  }

}
