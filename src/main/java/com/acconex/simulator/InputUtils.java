package com.acconex.simulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import com.acconex.simulator.io.FileUtils;

public class InputUtils {
  private static final String QUIT = "q";
  private static final String INPUT_PROMPT  ="(l)eft, (r)ight, (a)dvance <n>, (q)uit: "  ;
 private InputUtils(){
   
 }
 
 public static Map <Integer,List<Character>> loadMap(File input, Map <Integer,List<Character>> landMap){
  try {
   List<String> st = reads(FileUtils.newFileReader(input));
   int i=0;

   for(String s : st){
    List<Character> chars = s.chars().mapToObj(e -> (char)e).collect(Collectors.toList()); 
    landMap.put(i, chars);
    i++;
   }
   System.out.println();
   System.out.println(" This is the map of the site");
  //print map   
   landMap.forEach( 
       (row, column) -> { 
             System.out.println();  
             column.forEach(ch ->{ System.out.print(ch+ " ");});
             }); 
   
  } catch (FileNotFoundException e) {
    
   throw new UncheckedIOException(e);
  }
    
   return landMap;   
 }
 

 private static List<String>  reads(Reader contentReader){
   try(BufferedReader reader = new BufferedReader(contentReader)){   
     return reader.lines().collect(Collectors.toList());
   } catch (IOException e) {
     throw new UncheckedIOException(e);
  }
   
 }
  
 public static void readCommands(InputStreamReader reader,Consumer<String> messageConsumer){

   try( Scanner s = new Scanner(reader)){
     System.out.print(INPUT_PROMPT);
     while(s.hasNext()){
       String input = s.nextLine().trim();
       messageConsumer.accept( input);
       
       if(input.equals(QUIT)){
         break;
       }      
       System.out.print(INPUT_PROMPT);
     }
 } 
 }
}
