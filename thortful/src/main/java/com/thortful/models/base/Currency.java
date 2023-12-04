package com.thortful.models.base;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Currency {

  @JsonProperty("name")
  private String name;

  @JsonProperty("symbol")
  private String symbol;

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
