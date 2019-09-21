package com.acconex.simulator;

import java.io.File;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import com.acconex.simulator.model.Direction;

public class Simulator 
{
  private static Map <Integer,String > landMap = new HashMap<Integer, String>();
   private static String FILE_NAME ="input.txt";
   private static int INITIAL_X = 0;
   private static int INITIAL_Y = 0;
   
   public static void main( String[] args )
    {
      init();
     
      Land land = new Land(landMap);    
      //top left corner coordinate taken as (0,0)
      //and the bulldozer is facing  east
      Position initialPosition = new Position(INITIAL_X, INITIAL_Y, Direction.E);
      Bulldozer bulldozer = new Bulldozer(initialPosition,land);
      InputUtils.readCommands(new InputStreamReader(System.in),Simulator::sendCommandToBulldozer);
    }
    
    private static void init() {
     try{     
         File input = new File(Simulator.class.getResource("/"+FILE_NAME).toURI());
         InputUtils.loadMap(input, landMap);
         
    } catch (URISyntaxException e) {
      throw new IllegalStateException(e);
    }
     
    }
    
    private static void sendCommandToBulldozer(String command){
      System.out.println("Command"+command);
    }
    
}
