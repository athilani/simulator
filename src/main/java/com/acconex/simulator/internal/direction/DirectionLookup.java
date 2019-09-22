package com.acconex.simulator.internal.direction;

import java.util.function.Supplier;

public enum DirectionLookup {
  E("EAST",EastDirection::new),
  W("WEST",WestDirection::new),
  N("NORTH",NorthDirection::new),
  S("SOUTH",SouthDirection::new);
  
  private String direction;
  private Direction directionObject;
  
  DirectionLookup(String direction,Supplier<Direction> type){
    this.direction = direction;
    this.directionObject = type.get();
  }
  
  public Direction getDirectionObject() {
    return directionObject;
  }
  
}
