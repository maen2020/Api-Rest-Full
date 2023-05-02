package com.maen.app.exceptions.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Clase plantilla la cual sera mostrada en la aplicacion cliente.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {

    /**
     * Atributos de la clase
     * Mensaje a mostrar cuando se detone la exception
     * Verbo el cual se mostrara en la exception.
     */
    private HttpStatus status;
    private String message;
}