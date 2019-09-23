package com.acconex.simulator.internal.direction;

import com.acconex.simulator.Position;

public class SouthDirection implements Direction{

  SouthDirection(){
    
  }
  
  @Override
  public DirectionLookup turnLeft() {
    return DirectionLookup.E;
  }

  @Override
  public DirectionLookup turnRight() {
    return DirectionLookup.W;
  }

//y coordinate should increase by given units
  @Override
  public Position advance(Position currentPosition, int units) {
    int newY = currentPosition.getY() + units;
    return new Position(currentPosition.getX(), newY, currentPosition.getDirection());
  }

}
