package com.acconex.simulator.internal;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {
  private final List<Command> commands = new ArrayList<>();;
  
  public void executeOperation(Command command) {
    commands.add(command);
    command.execute();
}

  public List<Command> getCommands() {
    return commands;
  }
   
}
