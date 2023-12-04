package com.thortful.models.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Car {

  @JsonProperty("signs")
  private List<String> signs;

  @JsonProperty("side")
  private String side;

  public List<String> getSigns() {
    return signs;
  }

  public void setSigns(List<String> signs) {
    this.signs = signs;
  }

  public String getSide() {
    return side;
  }

  public void setSide(String side) {
    this.side = side;
  }
}
