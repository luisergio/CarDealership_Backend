package br.com.luisergio.cardealership.exception;

/**
 * The type Item not found exception.
 */
public class ItemNotFoundException extends BusinessException {

    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new Item not found exception.
     *
     * @param message the message
     */
    public ItemNotFoundException(String message) {
        super(message);
    }
}
