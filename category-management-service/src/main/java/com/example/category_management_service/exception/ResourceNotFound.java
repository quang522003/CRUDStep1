package com.example.category_management_service.exception;

public class ResourceNotFound extends RuntimeException{
    String message;
    public ResourceNotFound(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}

