package com.acconex.simulator.internal;

public class RightCommand implements Command{

 private Bulldozer bulldozer;
  
  public RightCommand(Bulldozer bulldozer){
    this.bulldozer = bulldozer;
  }

  @Override
  public void execute() {
  }
}
