package com.acconex.simulator;

import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import com.acconex.simulator.internal.AdvanceCommand;
import com.acconex.simulator.internal.Bulldozer;
import com.acconex.simulator.internal.CommandExecutor;
import com.acconex.simulator.internal.LeftCommand;
import com.acconex.simulator.internal.RightCommand;
import com.acconex.simulator.internal.direction.DirectionLookup;

public class BuldozerTest {
  private static Map <Integer,String > landMap= new HashMap<Integer, String>();

  private static final Land land = new Land(landMap);
  private static CommandExecutor executor = new CommandExecutor();

  
  @Test
  public void sendCommandsToBuldozerTest(){
      Position initialPosition = new Position(-1, 0, DirectionLookup.E);
    Bulldozer bulldozer = new Bulldozer(land,initialPosition);
    executor.executeOperation(new AdvanceCommand(bulldozer,2));
    executor.executeOperation(new RightCommand(bulldozer));
    executor.executeOperation(new AdvanceCommand(bulldozer,2));
    executor.executeOperation(new LeftCommand(bulldozer));

    Position expectedPostion = new Position(1, 2, DirectionLookup.E); 

    assertEquals("Bulldozer should face east",expectedPostion.getDirection(), bulldozer.getCurrentPosition().getDirection());
    assertEquals("Bulldozer should stay at X coordinate",expectedPostion.getX(), bulldozer.getCurrentPosition().getX());
    assertEquals("Bulldozer should stay at Y coordinate",expectedPostion.getY(), bulldozer.getCurrentPosition().getY());
  }
}
