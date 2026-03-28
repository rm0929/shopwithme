package com.shopwithme.cart.exception.advice;

import com.shopwithme.cart.exception.CartAlreadyExistsException;
import com.shopwithme.cart.exception.CartItemNotFoundException;
import com.shopwithme.cart.exception.CartNotFoundException;
import com.shopwithme.cart.exception.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(CartNotFoundException.class)
        public ResponseEntity<ErrorResponse> handleCartNotFoundException(
                        CartNotFoundException ex,
                        HttpServletRequest request) {

                ErrorResponse error = ErrorResponse.builder()
                                .status(HttpStatus.NOT_FOUND.value())
                                .message(ex.getMessage())
                                .path(request.getRequestURI())
                                .timestamp(LocalDateTime.now())
                                .build();

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }

        @ExceptionHandler(CartItemNotFoundException.class)
        public ResponseEntity<ErrorResponse> handleCartItemNotFoundException(
                        CartItemNotFoundException ex,
                        HttpServletRequest request) {

                ErrorResponse error = ErrorResponse.builder()
                                .status(HttpStatus.NOT_FOUND.value())
                                .message(ex.getMessage())
                                .path(request.getRequestURI())
                                .timestamp(LocalDateTime.now())
                                .build();

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }

        @ExceptionHandler(CartAlreadyExistsException.class)
        public ResponseEntity<ErrorResponse> handleCartAlreadyExistsException(
                        CartAlreadyExistsException ex,
                        HttpServletRequest request) {

                ErrorResponse error = ErrorResponse.builder()
                                .status(HttpStatus.CONFLICT.value())
                                .message(ex.getMessage())
                                .path(request.getRequestURI())
                                .timestamp(LocalDateTime.now())
                                .build();

                return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Map<String, String>> handleValidationException(
                        MethodArgumentNotValidException ex) {

                Map<String, String> errors = new HashMap<>();
                ex.getBindingResult()
                                .getAllErrors()
                                .forEach(error -> {
                                        String fieldName = ((FieldError) error).getField();
                                        String message = error.getDefaultMessage();
                                        errors.put(fieldName, message);
                                });

                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<ErrorResponse> handleGenericException(
                        Exception ex,
                        HttpServletRequest request) {

                ErrorResponse error = ErrorResponse.builder()
                                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                                .message("An unexpected error occurred")
                                .path(request.getRequestURI())
                                .timestamp(LocalDateTime.now())
                                .build();

                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
}