package com.acconex.simulator.exception;

public class OutofBoundException extends RuntimeException{
  public OutofBoundException(){
    super();
}

public OutofBoundException(String message){
    super(message);   
}
}
