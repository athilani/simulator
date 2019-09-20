package com.acconex.simulator.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class FileUtil {
  private FileUtil(){
    
  }
  
  public static Reader newFileReader(File file) throws FileNotFoundException {
    return new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
  }
}
