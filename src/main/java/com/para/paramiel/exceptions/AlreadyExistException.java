package com.para.paramiel.exceptions;

public class AlreadyExistException extends  RuntimeException {

   public AlreadyExistException(String msg){
        super(msg+" Already exist");
    }

    public AlreadyExistException(){
        super(" Already exist");
    }
}
