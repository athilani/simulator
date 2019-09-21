package com.acconex.simulator;

import java.io.File;
import java.net.URISyntaxException;


public class TestUtils {
  
  public static File resourceAsFile(Object testObject, String resource) {
    Class<?> type = testObject.getClass();
    try {
       return new File( type.getClass().getResource(resource).toURI());

    } catch (URISyntaxException e) {
      throw new IllegalStateException(e);
    }
  }
}
