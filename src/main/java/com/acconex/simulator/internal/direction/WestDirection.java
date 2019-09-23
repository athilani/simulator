package com.acconex.simulator.internal.direction;

import com.acconex.simulator.Position;

public class WestDirection implements Direction{

  WestDirection(){
    
  }
  
  @Override
  public DirectionLookup turnLeft() {
    return DirectionLookup.S;
  }

  @Override
  public DirectionLookup turnRight() {
    return DirectionLookup.N;
  }

//x coordinate should decrease by given units
  @Override
  public Position advance(Position currentPosition, int units) {
    int newX = currentPosition.getX() - units;
    return new Position(newX, currentPosition.getY(), currentPosition.getDirection());
  }

}
