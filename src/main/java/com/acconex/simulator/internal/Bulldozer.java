package com.acconex.simulator.internal;

import java.util.function.Consumer;
import com.acconex.simulator.Position;
import com.acconex.simulator.exception.DestroyProtectedTreeException;
import com.acconex.simulator.exception.OutofBoundException;
import com.acconex.simulator.internal.direction.Direction;
import com.acconex.simulator.internal.direction.DirectionLookup;
import com.acconex.simulator.land.Land;

public class Bulldozer {
  public static int INITIAL_X = 0;
  public static int INITIAL_Y = 0;

  private Position currentPosition;
  private final Land land;
  private Consumer<Bulldozer> callBackToTerminate;

  public Bulldozer(Land land,Position currentPosition,Consumer<Bulldozer> callBackToTerminate) {
    this.land = land;
    this.currentPosition = currentPosition;
    this.callBackToTerminate = callBackToTerminate;
  }

  public Position getCurrentPosition() {
    if(currentPosition !=null){
      return new Position(currentPosition.getX(), currentPosition.getY(), currentPosition.getDirection());
    }
    return null;
  }  

  void advance(int units){
      Position newPostion = getDirectionObject().advance(getCurrentPosition(), units);
      Position fromPosition =  new Position(currentPosition.getX(), currentPosition.getY(), currentPosition.getDirection());
      //to do validate position bounds with land ,check for obstacles with land
      try{
       land.validateMove(fromPosition, newPostion);
      }catch(OutofBoundException | DestroyProtectedTreeException e){
        quit();
        throw e;
      }
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
  
  void quit(){
    callBackToTerminate.accept(this);
  }
}
