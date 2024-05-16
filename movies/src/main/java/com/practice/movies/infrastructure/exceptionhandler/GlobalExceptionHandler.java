package com.practice.movies.infrastructure.exceptionhandler;


import com.practice.movies.infrastructure.entrypoint.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.validation.FieldError;


import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> businessExceptionHandler(BusinessException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ResponseDto.builder()
                        .data(null)
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message(ex.getMessage())
                        .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<String> errores = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .toList();
        ResponseDto response = ResponseDto.builder()
                .data(null)
                .status(HttpStatus.BAD_REQUEST.value())
                .message(String.join(";"+System.lineSeparator(), errores))
                .build();
        System.out.println(String.join(";", errores));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }


}
