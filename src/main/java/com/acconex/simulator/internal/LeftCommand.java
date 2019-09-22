package com.acconex.simulator.internal;

public class LeftCommand implements Command{

 private Bulldozer bulldozer;
  
  public LeftCommand(Bulldozer bulldozer){
    this.bulldozer = bulldozer;
  }

  @Override
  public void execute() {
    bulldozer.turnLeft();
  }
}
