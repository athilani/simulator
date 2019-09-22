package com.acconex.simulator.internal;

public class AdvanceCommand implements Command{

 private Bulldozer bulldozer;
 int units ;
  public AdvanceCommand(Bulldozer bulldozer,int units){
    this.bulldozer = bulldozer;
    this.units = units;
  }

  @Override
  public void execute() {
    bulldozer.advance(units);
  }
}
