package com.acconex.simulator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.acconex.simulator.exception.UnknownCommandException;
import com.acconex.simulator.internal.AdvanceCommand;
import com.acconex.simulator.internal.Command;
import com.acconex.simulator.internal.LeftCommand;
import com.acconex.simulator.internal.QuitCommand;
import com.acconex.simulator.internal.RightCommand;

public class CommandConverterTest {

  @Test
  public void parseValidCommandTest(){
    String command = "A 1";
   Command c = CommandConverter.prepareCommand(command, null);
   assertEquals("Advance command", AdvanceCommand.class,c.getClass());
   
   assertEquals("Right command", RightCommand.class, CommandConverter.prepareCommand("R", null).getClass());
   assertEquals("Left command", LeftCommand.class, CommandConverter.prepareCommand("L", null).getClass());
   assertEquals("Left command", QuitCommand.class, CommandConverter.prepareCommand("Q", null).getClass());

   
   assertEquals("Right command", RightCommand.class, CommandConverter.prepareCommand("r", null).getClass());
   assertEquals("Left command", LeftCommand.class, CommandConverter.prepareCommand("l", null).getClass());
   assertEquals("Left command", QuitCommand.class, CommandConverter.prepareCommand("q", null).getClass());

  }
  
  @Test(expected=UnknownCommandException.class)
  public void parseInValidCommandTest(){
    String command = "ABC";
   Command c = CommandConverter.prepareCommand(command, null);
   assertEquals("Advance command", AdvanceCommand.class,c.getClass());
 
}
  
}
