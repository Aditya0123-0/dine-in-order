package com.example.dio.util;

import com.example.dio.module.User;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStructure<T> {
    private int status;
    private String message;
    private T data;

//    Created factor method for ResponseStructure<T> by creating Generic factory method
    public static <T> ResponseStructure<T> create(HttpStatus status,String message,T data){
        ResponseStructure<T> response = new ResponseStructure<>();
        response.status= status.value();
        response.message=message;
        response.data = data;
        return  response;
    }
}
