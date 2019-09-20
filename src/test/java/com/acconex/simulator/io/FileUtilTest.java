package com.acconex.simulator.io;

import static org.junit.Assert.assertNotNull;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import org.junit.Test;

public class FileUtilTest {

  
  @Test
  public void newFileReaderShouldBeReturned() throws FileNotFoundException, URISyntaxException{
    File input =new File( this.getClass().getResource("/testInput.txt").toURI());
    assertNotNull(input);
    assertNotNull(FileUtil.newFileReader(input));
  }
}
