package com.assettracking.exception;

public class RoleAlreadyFoundException extends  RuntimeException{
    public RoleAlreadyFoundException(String msg){
        super(msg);
    }
}
