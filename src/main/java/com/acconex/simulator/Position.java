package com.acconex.simulator;

import com.acconex.simulator.model.Direction;

public class Position {
  private  int x ;
  private int y ;
  private Direction moveDirection;
  
  public Position(int x, int y, Direction moveDirection) {
    this.x = x;
    this.y = y;
    this.moveDirection = moveDirection;
  }

}
