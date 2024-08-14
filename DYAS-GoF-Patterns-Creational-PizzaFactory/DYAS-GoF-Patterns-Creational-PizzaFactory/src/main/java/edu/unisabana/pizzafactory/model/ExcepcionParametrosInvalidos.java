
package edu.unisabana.pizzafactory.model;

/**
 *
 * @author cesarvefe
 */
//Lo que hace esta funcion es sacarme las excepciones 
public class ExcepcionParametrosInvalidos extends Exception {

    public ExcepcionParametrosInvalidos(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcepcionParametrosInvalidos(String message) {
        super(message);
    }
    
    
    
}
