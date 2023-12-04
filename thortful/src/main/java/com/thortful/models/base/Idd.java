package com.thortful.models.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Idd {

  @JsonProperty("root")
  private String root;

  @JsonProperty("suffixes")
  private List<String> suffixes;

  public String getRoot() {
    return root;
  }

  public void setRoot(String root) {
    this.root = root;
  }

  public List<String> getSuffixes() {
    return suffixes;
  }

  public void setSuffixes(List<String> suffixes) {
    this.suffixes = suffixes;
  }
}
