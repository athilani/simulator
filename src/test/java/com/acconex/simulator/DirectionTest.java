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

  @Test
  public void FaceEastTurnLeftTest(){
    Direction east = DirectionLookup.E.getDirectionObject();

    assertEquals("Bulldozer should face north",DirectionLookup.N, east.turnLeft());
  }

  @Test
  public void FaceEastTurnRightTest(){
    Direction east = DirectionLookup.E.getDirectionObject();

    assertEquals("Bulldozer should face south",DirectionLookup.S, east.turnRight());
  }

  @Test
  public void FaceEastAndadvance2UnitsToEastTest(){
    Direction east = DirectionLookup.E.getDirectionObject();
    Position initial = new Position(0, 0, DirectionLookup.E);
    Position updatedPosition = east.advance(initial, 2);

    assertEquals("Bulldozer should face east",DirectionLookup.E, updatedPosition.getDirection());
    assertEquals("Bulldozer should stay at X coordinate",2, updatedPosition.getX());
    assertEquals("Bulldozer should stay at Y coordinate",1, updatedPosition.getY());

  }


}
