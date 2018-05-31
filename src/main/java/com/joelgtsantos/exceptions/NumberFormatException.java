/**
 * 
 */
package com.joelgtsantos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Joel Santos
 *
 * recipe-app
 * 2018
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NumberFormatException extends RuntimeException {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NumberFormatException() {
        super();
    }

    public NumberFormatException(String message) {
        super(message);
    }

    public NumberFormatException(String message, Throwable cause) {
        super(message, cause);
    }


}
