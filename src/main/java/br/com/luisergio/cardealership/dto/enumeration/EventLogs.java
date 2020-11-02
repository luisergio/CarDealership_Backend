package br.com.luisergio.cardealership.dto.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The enum Event logs.
 */
public enum EventLogs {


    /**
     * Try get all cars event logs.
     */
    TRY_GET_ALL_CARS("0001"),

    /**
     * Sucess get all cards event logs.
     */
    SUCCESS_GET_ALL_CARS("0002");


    /** Event code. */
    private String code;

    /**
     * Instantiates a new Create User event enum.
     *
     * @param code the code
     */
    EventLogs(String code) {
        this.code = code;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    @JsonValue
    public String getCode() {
        return code;
    }
}
