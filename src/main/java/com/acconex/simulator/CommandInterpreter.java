package com.acconex.simulator;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import com.acconex.simulator.exception.InvalidArgumentException;
import com.acconex.simulator.exception.UnknownCommandException;
import com.acconex.simulator.internal.AdvanceCommand;
import com.acconex.simulator.internal.Bulldozer;
import com.acconex.simulator.internal.Command;
import com.acconex.simulator.internal.LeftCommand;
import com.acconex.simulator.internal.QuitCommand;
import com.acconex.simulator.internal.RightCommand;
import com.acconex.simulator.internal.direction.DirectionLookup;


public final class CommandInterpreter {
  private static String ARG_SEPARATOR = " ";
  private CommandInterpreter(){
    
  }
  
  public static Command prepareCommand(String  userCommand,Bulldozer bulldozer,Consumer<Bulldozer>callbackFunction){ 
    final Command c ;
     String command = userCommand;
     int arg = 0;
    if(userCommand.length() >1){
      
     String [] commandStr =  userCommand.split(ARG_SEPARATOR);
     command = commandStr[0];
     arg =Integer.parseInt( commandStr[1]);
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
  
 
  public static  Optional<String> getArgs(String  userCommand){
    if(userCommand.length() >= 2){
      String [] args = userCommand.split(ARG_SEPARATOR);
      return Optional.ofNullable(args[1]);
    }
    else{
      throw new InvalidArgumentException();  
    }
  }

  public static Position getPlaceArgs(String[] args) {
    Position position = null;
    if(args.length == 2){     
      position = new Position(Integer.parseInt(args[0]), Integer.parseInt(args[1]),DirectionLookup.E);
    }
    else{
      throw new InvalidArgumentException("Invalid arguments received "+ Arrays.asList(args));
    }
   return position;
  }
}
