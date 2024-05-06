package com.turkcell.rentacar.inventoryService.core.utilities.exception.types;

public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }
}
