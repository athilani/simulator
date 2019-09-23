package com.acconex.simulator;

import com.acconex.simulator.exception.UnknownCommandException;
import com.acconex.simulator.internal.AdvanceCommand;
import com.acconex.simulator.internal.Bulldozer;
import com.acconex.simulator.internal.Command;
import com.acconex.simulator.internal.LeftCommand;
import com.acconex.simulator.internal.QuitCommand;
import com.acconex.simulator.internal.RightCommand;

public class CommandConverter {
  private static String ARG_SEPARATOR = " ";

  private CommandConverter(){

  }

  public static Command prepareCommand(String  userCommand,Bulldozer bulldozer){ 

    final Command c ;
    String command = userCommand;
    int arg = 0;
    if(userCommand.length() >1){
      try{
        String [] commandStr =  userCommand.split(ARG_SEPARATOR);
        command = commandStr[0];
        arg =Integer.parseInt( commandStr[1]);
      }catch(ArrayIndexOutOfBoundsException e){
        throw new UnknownCommandException("Unknown command :"+userCommand);
      }
    }

    switch(command.toUpperCase()){
      case ("A"):
        c = new AdvanceCommand(bulldozer, arg);
        break; 
      case("R"):
        c = new RightCommand(bulldozer);
        break;
      case("L"):
        c = new LeftCommand(bulldozer);
        break;
      case("Q"):
        c = new QuitCommand(bulldozer);
        break;
      default:              
        throw new UnknownCommandException(userCommand);
    }
    return c;
  }
}
