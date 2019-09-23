package com.acconex.simulator.internal.direction;

import com.acconex.simulator.Position;

public class NorthDirection implements Direction{

  NorthDirection(){
    
  }
  
  @Override
  public DirectionLookup turnLeft() {
    return DirectionLookup.W;
  }

  @Override
  public DirectionLookup turnRight() {
   return DirectionLookup.E;
  }

  @Override
//y coordinate should decrease by given units
  public Position advance(Position currentPosition, int units) {
    int newY = currentPosition.getY() - units;
    return new Position(currentPosition.getX(), newY, currentPosition.getDirection());
  }
}
