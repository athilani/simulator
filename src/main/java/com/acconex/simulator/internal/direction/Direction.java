package com.acconex.simulator.internal.direction;

import com.acconex.simulator.Position;

public interface Direction {
  public Direction turnLeft();
  
  public Direction turnRight();
 
  public Position advance(Position currentPosition, int units);
}
