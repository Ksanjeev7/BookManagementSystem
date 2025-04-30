package com.sanju.main.response;
import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiResponse<T> {

	private T data;
	private String mssg;
	private HttpStatus status;
	private ErrorResponse error;
	
	public static<T> ApiResponse<T> success(T data){
		
		ApiResponse<T> response = new ApiResponse<T>();
		response.setData(data);
		response.setMssg("Success");
		response.setStatus(HttpStatus.OK);
		return response;
	}
	
	public static<T> ApiResponse<T> error(ErrorResponse error, HttpStatus status){
		ApiResponse<T> response = new ApiResponse<T>();
		response.setError(error);
		response.setStatus(status);
		response.setMssg("Error");
		return response;
	}
	/*
	 * The benefits of these approaches: 
	 * Type Safety : Better compile-time type checking
	 * 
	 * Clear API Contract : Clients know exactly what to expect
	 * 
	 * Better Documentation : API documentation tools can generate more accurate
	 * docs
	 * 
	 * Consistent Response Structure : Standardized response format
	 * 
	 * Separation of Concerns : Error handling is separated from business logic
	 */
}
