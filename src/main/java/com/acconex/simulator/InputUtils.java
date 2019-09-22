package com.acconex.simulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.function.Consumer;

public class InputUtils {
 private InputUtils(){
   
 }
 
 public static Map<Integer,String> loadMap(File input,Map<Integer,String>landMap){
   return landMap;   
 }
 
 
 public static void readCommands(InputStreamReader reader,Consumer<String> messageConsumer){
   BufferedReader in = new BufferedReader(reader);
   //fix
   in.lines().filter(i -> !i.equalsIgnoreCase("Q")).forEach(messageConsumer);
 }
}
