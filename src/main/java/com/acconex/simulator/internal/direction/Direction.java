package com.acconex.simulator.internal.direction;

import com.acconex.simulator.Position;

public interface Direction {
 
  public DirectionLookup turnLeft();
  
  public DirectionLookup turnRight();
 
  public Position advance(Position currentPosition, int units);
}
