package com.acconex.simulator.internal;

import com.acconex.simulator.Land;
import com.acconex.simulator.Position;
import com.acconex.simulator.internal.direction.Direction;
import com.acconex.simulator.internal.direction.DirectionLookup;

public class Bulldozer {
  public static int INITIAL_X = 0;
  public static int INITIAL_Y = 0;

  private Position currentPosition;
  private final Land land;

  public Bulldozer(Land land,Position currentPosition) {
    this.land = land;
    this.currentPosition = currentPosition;
  }

  public Position getCurrentPosition() {
    if(currentPosition !=null){
      return new Position(currentPosition.getX(), currentPosition.getY(), currentPosition.getDirection());
    }
    return null;
  }  

  void advance(int units){
      Position newPostion = getDirectionObject().advance(getCurrentPosition(), units);
      //to do validate position bounds with land ,check for obstacles with land
      this.currentPosition = new Position(newPostion.getX(), newPostion.getY(), newPostion.getDirection());
  }
  
  void turnLeft(){
    DirectionLookup newDirection = getDirectionObject().turnLeft();
    currentPosition.setDirection(newDirection);
  }
  
  void turnRight(){
    DirectionLookup newDirection = getDirectionObject().turnRight();
    currentPosition.setDirection(newDirection);
  }
  
  private Direction getDirectionObject(){
   return currentPosition.getDirection().getDirectionObject();
  }
}
