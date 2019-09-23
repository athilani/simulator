package com.acconex.simulator.internal;


public class QuitCommand implements Command{

 private Bulldozer bulldozer;
 
  public QuitCommand(Bulldozer bulldozer){
    this.bulldozer = bulldozer;
  }

  @Override
  public void execute() {
    bulldozer.quit();
  }
  
  @Override
  public String toString(){
    return CommandType.Q.getCommand() ;
  }
}
