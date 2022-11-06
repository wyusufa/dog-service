package com.example.dogservice.model.dto_for_crud.response_message;


public class NotFound {
    public String status;
    public String message;
    public int code;

    public NotFound(String status, String message, int code) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

}
