package com.acconex.simulator.internal;

import com.acconex.simulator.Land;
import com.acconex.simulator.Position;



public class Bulldozer {
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

  }
  void turnLeft(){

  }
  void turnRight(){

  }


}
