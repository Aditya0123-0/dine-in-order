package com.example.dio.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {

/**
 * Helps to create success response with data including the Http status code , message and data itself
 * @param status it specifies the status code of the request
 * @param message it specifies the success message of the request
 * @param data  it specifies the data which is involved .
 * @return it returns the data of type ResponseEntity<ResponseStructure<T>>
 * */
    public static <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status, String message, T data) {
        ResponseStructure<T> structure = ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(structure);
    }

    public static <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status, HttpHeaders headers, String message, T data) {
        ResponseStructure<T> structure = ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(headers)
                .body(structure);

    }

    /**
     * Helps to invoke success() response with data including the Http status code , message and data itself
     * @param message it specifies the success message of the request
     * @param data  it specifies the data which is involved .
     * @return it returns the data of type ResponseEntity<ResponseStructure<T>>
     * */

    public static <T> ResponseEntity<ResponseStructure<T>> ok(T data, String message){
        return success(HttpStatus.OK,message,data);
    }
    /**
     * Helps to invoke the success() response with data including the Http status code , message and data itself
     * @param message it specifies the success message of the request
     * @param data  it specifies the data which is involved .
     * @return it returns the data of type ResponseEntity<ResponseStructure<T>>
     * */
    public static <T> ResponseEntity<ResponseStructure<T>> created(T data,String message){
        return success(HttpStatus.CREATED, message,data);
    }

    /**
     * Helps to create the error response including HttpStatus code, message itself,
     * @param status returns the status type and status code of an error
     * @param message returns the message of the error
     * @return it returns the data of type ResponseEntity<SimpleErrorResponse>>
     * */
    public static ResponseEntity<SimpleErrorResponse> error(HttpStatus status, String message) {
        SimpleErrorResponse error = SimpleErrorResponse.builder()
                .type(status.name())
                .message(message)
                .status(status.value())
                .build();

        return ResponseEntity.status(status)
                .body(error);
    }

    /**
     * Used to invoke  the error() including HttpStatus code, message itself,
     * @param message returns the message of the error
     * @return it returns the data of type ResponseEntity<SimpleErrorResponse>>
     * */
    public static ResponseEntity<SimpleErrorResponse> notFound(String message){
        return error(HttpStatus.NOT_FOUND,message);
    }

}
