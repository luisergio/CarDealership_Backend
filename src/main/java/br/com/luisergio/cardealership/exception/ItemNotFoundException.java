package br.com.luisergio.cardealership.exception;

public class ItemNotFoundException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public ItemNotFoundException(String message) {
        super(message);
    }
}
