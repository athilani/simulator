package com.acconex.simulator.exception;

public class UnknownCommandException extends RuntimeException {

public UnknownCommandException(){
    super();
}

public UnknownCommandException(String error){
    super(error);   
    System.out.println(error);
}
}
