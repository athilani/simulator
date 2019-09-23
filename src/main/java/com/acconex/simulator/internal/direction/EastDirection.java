package com.acconex.simulator.internal.direction;

import com.acconex.simulator.Position;

public class EastDirection implements Direction{

  EastDirection(){
    
  }
  
  @Override
  public DirectionLookup turnLeft() {
   return DirectionLookup.N;
  }

  @Override
  public DirectionLookup turnRight() {
   return DirectionLookup.S;
  }
  
//x coordinate should increase by given units
  @Override
  public Position advance(Position currentPosition, int units) {
    int newX = currentPosition.getX() + units;
    return new Position(newX, currentPosition.getY(), currentPosition.getDirection());
  }

}
