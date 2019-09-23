package com.acconex.simulator;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.junit.Before;
import org.junit.Test;
import com.acconex.simulator.Position;
import com.acconex.simulator.exception.OutofBoundException;
import com.acconex.simulator.internal.AdvanceCommand;
import com.acconex.simulator.internal.Bulldozer;
import com.acconex.simulator.internal.CommandExecutor;
import com.acconex.simulator.internal.LeftCommand;
import com.acconex.simulator.internal.RightCommand;
import com.acconex.simulator.internal.direction.DirectionLookup;
import com.acconex.simulator.land.Land;

public class BuldozerTest {
  private static Map <Integer,List<Character>>landMap= new HashMap<Integer,List<Character>>();

  private Land land ;
  private static final Consumer<Bulldozer> testQuit = b-> System.out.println("quit");
  private static CommandExecutor executor = new CommandExecutor();

  @Before
  public void setup(){
    List <Character>charList = new ArrayList<>();
    charList.add('o');
    charList.add('o');   
    charList.add('t');
    charList.add('o');
    charList.add('o');
    charList.add('o');
    charList.add('o');
    charList.add('o');
    charList.add('o');
    charList.add('o');

    landMap.put(0,charList);
    landMap.put(1,charList);
    landMap.put(2,charList);
    landMap.put(3,charList);
    landMap.put(4,charList);
    landMap.put(5,charList);
     land = new Land(landMap);

  }
  
  @Test
  public void sendCommandsToBuldozerTest(){
    
    Position initialPosition = new Position(-1, 0, DirectionLookup.E);
    Bulldozer bulldozer = new Bulldozer(land,initialPosition,testQuit);
    executor.executeOperation(new AdvanceCommand(bulldozer,2));
    executor.executeOperation(new RightCommand(bulldozer));
    executor.executeOperation(new AdvanceCommand(bulldozer,2));
    executor.executeOperation(new LeftCommand(bulldozer));

    Position expectedPostion = new Position(1, 2, DirectionLookup.E); 

    assertEquals("Bulldozer should face east",expectedPostion.getDirection(), bulldozer.getCurrentPosition().getDirection());
    assertEquals("Bulldozer should stay at X coordinate",expectedPostion.getX(), bulldozer.getCurrentPosition().getX());
    assertEquals("Bulldozer should stay at Y coordinate",expectedPostion.getY(), bulldozer.getCurrentPosition().getY());
  
  }

  @Test(expected=OutofBoundException.class)
  public void sendOutOfBoundCommandsToBuldozerTest(){
    
    Position initialPosition = new Position(-1, 0, DirectionLookup.E);
    Bulldozer bulldozer = new Bulldozer(land,initialPosition,testQuit);
    executor.executeOperation(new AdvanceCommand(bulldozer,2));
    executor.executeOperation(new RightCommand(bulldozer));
    executor.executeOperation(new AdvanceCommand(bulldozer,7));
    }


  
}
