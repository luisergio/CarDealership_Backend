package br.com.luisergio.cardealership.controller;

import br.com.luisergio.cardealership.dto.enumeration.EventLogs;
import br.com.luisergio.cardealership.exception.ItemNotFoundException;
import br.com.luisergio.cardealership.utils.LoggerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The Class ResourceExceptionHandler. Responsible for the centralized handling of exceptions.
 */
@ControllerAdvice

/** The Constant log. */
@Slf4j
public class ResourceExceptionHandler {

	/**
	 * The Logger service.
	 */
	@Autowired
	private LoggerService loggerService;

    /**
     * General handle for not expected error.
     *
     * @param ex the exception
     * @return the response entity
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleGeneralException(Exception ex) {
		loggerService.logError(EventLogs.ERROR_GENERIC,ex);
        return createStandardError(HttpStatus.INTERNAL_SERVER_ERROR);
    }

	/**
	 * General handle for item not found.
	 *
	 * @param ex the exception
	 * @return the response entity
	 */
	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity handleItemNotFoundException(ItemNotFoundException ex) {
		loggerService.logError(EventLogs.ERROR_ITEM_NOT_FOUND,ex);
		return createStandardError(HttpStatus.NOT_FOUND);
	}

	/**
	 * General handle for item not found.
	 *
	 * @param ex the exception
	 * @return the response entity
	 */
	@ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
	public ResponseEntity handleItemNotFoundException(Exception ex) {
		loggerService.logError(EventLogs.ERROR_INVALID_REQUEST,ex);
		return createStandardError(HttpStatus.BAD_REQUEST);
	}


	/**
	 * Creates the standard error.
	 *
	 * @param status the status
	 * @return the response entity
	 */
	private ResponseEntity createStandardError(HttpStatus status) {
		return ResponseEntity.status(status).build();
	}

	
}
