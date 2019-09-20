package com.acconex.simulator.model;

public enum Direction {
  E("EAST"),
  W("WEST"),
  N("NORTH"),
  S("SOUTH");
  
  private String direction;
  Direction(String direction){
    this.direction = direction;
  }
  
}
