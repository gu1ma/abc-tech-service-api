package br.com.fiap.abctechservice.handler.exception;

import lombok.Getter;

@Getter
public class MinAssistsException extends RuntimeException {
    private String description;
    public MinAssistsException(String message, String description) {
        super(message);
        this.description = description;
    }
}
