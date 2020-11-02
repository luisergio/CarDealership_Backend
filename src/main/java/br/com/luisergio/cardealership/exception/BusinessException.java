package br.com.luisergio.cardealership.exception;

/**
 * The Class used for handling business errors.
 */
public class BusinessException extends RuntimeException {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new business exception.
	 */
	public BusinessException() {

	}

	/**
	 * Instantiates a new business exception.
	 *
	 * @param message the message
	 */
	public BusinessException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new business exception.
	 *
	 * @param cause the cause
	 */
	public BusinessException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new business exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new business exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 * @param enableSuppression the enable suppression
	 * @param writableStackTrace the writable stack trace
	 */
	public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
