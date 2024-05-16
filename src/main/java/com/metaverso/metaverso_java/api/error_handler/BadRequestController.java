package com.metaverso.metaverso_java.api.error_handler;

import com.metaverso.metaverso_java.api.dto.errors.BaseErrorRespo;
import com.metaverso.metaverso_java.api.dto.errors.ErrorsRespo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class BadRequestController {
    //esto es un observador que revisa toda la aplicacion y dependiendo del error ejecuta un metodo u otro
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseErrorRespo handleBadRequest(MethodArgumentNotValidException exception){

        List<Map<String,String>> errors=new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(e->{
            Map<String,String>error=new HashMap<>();
            error.put("error", e.getDefaultMessage());
            error.put("field",e.getField());
            errors.add(error);
        });
        return ErrorsRespo.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.name())
                .errors(errors)
                .build();

    }
}
