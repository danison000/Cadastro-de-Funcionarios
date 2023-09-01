package com.dan.br.cadastrodefuncionario.infra;


import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dan.br.cadastrodefuncionario.web.DTO.ResponseExceptionDto;

/**
 * ControllerExceptionHandler
 */
@RestControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> violacaoIntegridade(DataIntegrityViolationException e) {

        ResponseExceptionDto error = new ResponseExceptionDto("Não foi possível excluir pois possui entidades relacionadas", "400");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleMinhaExcecao(Exception e) {
       

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseExceptionDto(e.getMessage(), "400"));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> errosFields(MethodArgumentNotValidException e) {

        HashMap<String, String> errors = new HashMap<>();

        BindingResult binding = e.getBindingResult();
        binding.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

      
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(errors);
    }



}