package com.acconex.simulator.internal;

public enum CommandType {
  A("Advance"),
  L("Left"),
  R("Right"),
  Q("Quit");
  
  private String command;
  CommandType(String command){
    this.command = command;
  }
 public  String getCommand(){
   return this.command;
 }
}
