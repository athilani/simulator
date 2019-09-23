package com.acconex.simulator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.acconex.simulator.internal.direction.Direction;
import com.acconex.simulator.internal.direction.DirectionLookup;
import com.acconex.simulator.internal.direction.EastDirection;
import com.acconex.simulator.internal.direction.NorthDirection;
import com.acconex.simulator.internal.direction.SouthDirection;
import com.acconex.simulator.internal.direction.WestDirection;

public class DirectionTest {

  @Test
  public void getDirectionObjectForGivenDirection(){
    assertEquals("EastDirection object",EastDirection.class, DirectionLookup.E.getDirectionObject().getClass());
    assertEquals("WestDirection object",WestDirection.class, DirectionLookup.W.getDirectionObject().getClass());
    assertEquals("SouthDirection object",SouthDirection.class, DirectionLookup.S.getDirectionObject().getClass());
    assertEquals("NorthDirection object",NorthDirection.class, DirectionLookup.N.getDirectionObject().getClass());   
  }
// test for east direction
  @Test
  public void FaceEastTurnLeftTest(){
    Direction east = DirectionLookup.E.getDirectionObject();

    assertEquals("Bulldozer should face north", DirectionLookup.N,east.turnLeft());
  }

  @Test
  public void FaceEastTurnRightTest(){
    Direction east = DirectionLookup.E.getDirectionObject();

    assertEquals("Bulldozer should face south",DirectionLookup.S, east.turnRight());
  }

  @Test
  public void FaceEastAndadvance2UnitsToEastTest(){
    Direction east = DirectionLookup.E.getDirectionObject();
    Position initial = new Position(-1, 0, DirectionLookup.E);
    Position updatedPosition = east.advance(initial, 2);

    assertEquals("Bulldozer should face east",DirectionLookup.E, updatedPosition.getDirection());
    assertEquals("Bulldozer should stay at X coordinate",1, updatedPosition.getX());
    assertEquals("Bulldozer should stay at Y coordinate",0, updatedPosition.getY());
  }
 
//test for west direction
  @Test
  public void FaceWestTurnLeftTest(){
    Direction west = DirectionLookup.W.getDirectionObject();

    assertEquals("Bulldozer should face south",DirectionLookup.S, west.turnLeft());
  }

  @Test
  public void FaceWestTurnRightTest(){
    Direction west = DirectionLookup.W.getDirectionObject();

    assertEquals("Bulldozer should face north",DirectionLookup.N, west.turnRight());
  }
  
  @Test
  public void FaceWestAndadvance2UnitsTest(){
    Direction west = DirectionLookup.W.getDirectionObject();
    Position initial = new Position(2, 2, DirectionLookup.W);
    Position updatedPosition = west.advance(initial, 2);

    assertEquals("Bulldozer should face west",DirectionLookup.W, updatedPosition.getDirection());
    assertEquals("Bulldozer should stay at X coordinate",0, updatedPosition.getX());
    assertEquals("Bulldozer should stay at Y coordinate",2, updatedPosition.getY());
  }

//test for south direction
  @Test
  public void FaceSouthTurnLeftTest(){
    Direction south = DirectionLookup.S.getDirectionObject();

    assertEquals("Bulldozer should face east",DirectionLookup.E, south.turnLeft());
  }

  @Test
  public void FaceSouthTurnRightTest(){
    Direction south = DirectionLookup.S.getDirectionObject();

    assertEquals("Bulldozer should face south",DirectionLookup.W, south.turnRight());
  }
  
  @Test
  public void FaceSouthAndadvance2UnitsTest(){
    Direction south = DirectionLookup.S.getDirectionObject();
    Position initial = new Position(2, 2, DirectionLookup.S);
    Position updatedPosition = south.advance(initial, 2);

    assertEquals("Bulldozer should face south",DirectionLookup.S, updatedPosition.getDirection());
    assertEquals("Bulldozer should stay at X coordinate",2, updatedPosition.getX());
    assertEquals("Bulldozer should stay at Y coordinate",4, updatedPosition.getY());
  }

//test for north direction
  @Test
  public void FaceNorthTurnLeftTest(){
    Direction north = DirectionLookup.N.getDirectionObject();

    assertEquals("Bulldozer should face west",DirectionLookup.W, north.turnLeft());
  }

  @Test
  public void FaceNorthTurnRightTest(){
    Direction north = DirectionLookup.N.getDirectionObject();

    assertEquals("Bulldozer should face east",DirectionLookup.E, north.turnRight());
  }
  
  @Test
  public void FaceNorthAndadvance2UnitsTest(){
    Direction north = DirectionLookup.N.getDirectionObject();
    Position initial = new Position(2, 2, DirectionLookup.N);
    Position updatedPosition = north.advance(initial, 2);

    assertEquals("Bulldozer should face north",DirectionLookup.N, updatedPosition.getDirection());
    assertEquals("Bulldozer should stay at X coordinate",2, updatedPosition.getX());
    assertEquals("Bulldozer should stay at Y coordinate",0, updatedPosition.getY());
  }


}
