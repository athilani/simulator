package com.acconex.simulator.exception;

public class InvalidArgumentException extends UnknownCommandException{
  public InvalidArgumentException(){
    super();
}

public InvalidArgumentException(String message){
    super(message);   
}
}
