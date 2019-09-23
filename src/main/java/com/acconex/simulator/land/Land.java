package com.acconex.simulator.land;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import com.acconex.simulator.Position;
import com.acconex.simulator.exception.OutofBoundException;

public final class Land {

  private final Map<Integer,List<Character>> artifactsMap;
  private int upperBoundX = 5;
  private int upperBoundY = 5;
  private final int lowerBoundX = 0;
  private final int lowerBoundY = 0;

  public Land(Map<Integer,List<Character>>artifactsMap){
    this.artifactsMap = artifactsMap;
  }
  
  public void validateMove(Position from , Position to){
    if(! isValidX().and(isValidY()).test(to)){     
        throw new OutofBoundException("Bulldozer navigate beyond the boundaries of site");
    }
  }
  public  Predicate<Position> isValidX() {
    return x -> x.getX() >= 0 && x.getX() <= upperBoundX;
  }
  
  public  Predicate<Position> isValidY() {
    return y -> y.getY() >= 0 && y.getY() <= upperBoundY;
  }

}
