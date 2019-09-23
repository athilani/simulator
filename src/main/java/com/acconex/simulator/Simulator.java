package com.acconex.simulator;

import java.io.File;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.acconex.simulator.internal.Bulldozer;
import com.acconex.simulator.internal.Command;
import com.acconex.simulator.internal.CommandExecutor;
import com.acconex.simulator.internal.direction.DirectionLookup;
import com.acconex.simulator.land.Land;

public class Simulator 
{

  private static String FILE_NAME ="input.txt";
  private static final int INITIAL_X = -1;
  private static final int INITIAL_Y = 0;
  private Land land;
  private Bulldozer bulldozer;
  private CommandExecutor executor ;
  private static Map <Integer,List<Character>> landMap = new HashMap <Integer,List<Character>>();

  
  public static void main( String[] args )
  {
    Simulator simulator = new Simulator();
    simulator.init();

    InputUtils.readCommands(new InputStreamReader(System.in),simulator::setCommandToController);
  }

  private  void init() {
    File input;
    try{     
       input = new File(Simulator.class.getResource("/"+FILE_NAME).toURI());
     
    } catch (URISyntaxException e) {
      throw new IllegalStateException(e);
    }
      
      InputUtils.loadMap(input, landMap);
      land = new Land(landMap);
    //top left corner coordinate taken as (-1,0)
      //and the bulldozer is facing  east
      Position initialPosition = new Position(INITIAL_X, INITIAL_Y, DirectionLookup.E);
      bulldozer =  new Bulldozer(land,initialPosition,this::printSummary);
      executor = new CommandExecutor();

   

  }

  private  void setCommandToController(String userCommand){

   Command bulldozerCommand = CommandConverter.prepareCommand(userCommand, bulldozer);
   executor.executeOperation(bulldozerCommand);

  }
  
  private  void printSummary(Bulldozer buldozer){
    executor.getCommands().stream().forEach(c -> System.out.print(c));
    return ;
  }

}
