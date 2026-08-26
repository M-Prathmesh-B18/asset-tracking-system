package com.assettracking.exception;


public class DuplicateResourceFoundException extends RuntimeException{
    public DuplicateResourceFoundException(String msg){
        super(msg);
    }

}
