package com.practice.movies.infrastructure.entrypoint.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class ResponseDto <T>{
    private T data;
    private Integer status;
    private String message;
}