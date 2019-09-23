package com.acconex.simulator.land;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import com.acconex.simulator.Position;
import com.acconex.simulator.exception.OutofBoundException;
import com.acconex.simulator.internal.direction.DirectionLookup;

public final class Land {

  private final Map<Integer,List<Character>> artifactsMap;
  private int upperBoundX ;
  private int upperBoundY ;
  private final int lowerBoundX = 0;
  private final int lowerBoundY = 0;
  private InternalGraph graph;
  public Land(Map<Integer,List<Character>>artifactsMap){
    this.artifactsMap = artifactsMap;
    graph = new InternalGraph(artifactsMap);
    setBounds();
  }
  
  private void setBounds() {
    upperBoundX =artifactsMap.values().size();
    upperBoundY = artifactsMap.keySet().size();  
  }

  public void validateMove(Position from , Position to){
    if(! isValidX().and(isValidY()).test(to)){     
        throw new OutofBoundException("Bulldozer navigate beyond the boundaries of site");
    }
    markVisited(from, to);
  }
  
  private void markVisited(Position from , Position to){
    //make it a set
   ArrayList list =  new ArrayList<Position>();
    visitedXPosition(from,to,list );
    visitedYPosition(from, to, list);
  }
  
  public  Predicate<Position> isValidX() {
    return x -> x.getX() >= lowerBoundX  && x.getX() <= upperBoundX;
  }
  
  public  Predicate<Position> isValidY() {
    return y -> y.getY() >= lowerBoundY && y.getY() <= upperBoundY;
  }

  private List<Position> visitedXPosition(Position from , Position to,List<Position> list){
    Position visited;
    if(from.getX() == to.getX())
      return list;
    else 
    {
      if(from.getDirection().equals(DirectionLookup.E)){
        visited =  new Position(from.getX()+1, from.getY(), from.getDirection());
      }
      else{
        visited =  new Position(from.getX()-1, from.getY(), from.getDirection());

      }
      list.add(visited);
    }

    return visitedXPosition(visited ,  to,list);

  }
  
  private List<Position> visitedYPosition(Position from , Position to,List<Position> list){
    Position visited;
    if(from.getY() == to.getY())
      return list;
    else 
    {
      if(from.getDirection().equals(DirectionLookup.S)){

      visited =  new Position(from.getX(), from.getY()+1, from.getDirection());
      }
      else{
        visited =  new Position(from.getX(), from.getY()-1, from.getDirection());

      }
      list.add(visited);

    }
    
    return visitedXPosition(visited ,  to,list);

  }
}
