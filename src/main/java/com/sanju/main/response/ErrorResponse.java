package com.sanju.main.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private String mssg;
	private LocalDateTime time;
    private String  status;
    
    public ErrorResponse(LocalDateTime time,String mssg, String status) {
    	this.time = time;
        this.mssg = mssg;
        this.status = status;
    }
}
