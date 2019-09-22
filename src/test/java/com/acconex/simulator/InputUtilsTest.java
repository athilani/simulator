package com.acconex.simulator;

import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class InputUtilsTest {
 private static Map <Integer,String > landMap= new HashMap<Integer, String>();
    
  @Test
  public void loadMapFileTest() throws FileNotFoundException{
    File input = TestUtils.resourceAsFile(this, "/testInput.txt");
     assertEquals(5, InputUtils.loadMap(input,landMap).size());
  }
  
  @Test
  public void readCommandsTest(){
    String string = "a 4";
    InputStream stringStream = new java.io.ByteArrayInputStream(string.getBytes());
    InputUtils.readCommands(new InputStreamReader(stringStream),this::returnValue);
  }
  
  private void returnValue(String command){
    assertEquals("a 4", command);

  }
}
