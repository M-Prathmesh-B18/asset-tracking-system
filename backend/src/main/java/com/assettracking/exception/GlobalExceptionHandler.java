package com.assettracking.exception;

import com.assettracking.dto.ErrorDTO.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.management.relation.RoleNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO>  handleResourceNotFoundException(ResourceNotFoundException ex){
        ErrorResponseDTO error=new ErrorResponseDTO(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage()
        );
        return ResponseEntity.
                status(HttpStatus.NOT_FOUND).
                body(error);
    }

    @ExceptionHandler(RoleAlreadyFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleRoleAlreadyFoundException(RoleNotFoundException ex){
        ErrorResponseDTO error=new ErrorResponseDTO(HttpStatus.CONFLICT.value(),
                ex.getMessage()
        );
        return ResponseEntity.
                status(HttpStatus.CONFLICT).
                body(error);

    }
}
