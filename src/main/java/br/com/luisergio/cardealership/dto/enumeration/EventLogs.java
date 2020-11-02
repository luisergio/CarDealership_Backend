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
    SUCCESS_GET_ALL_CARS("0002"),

    /**
     * Try get all cars event logs.
     */
    TRY_GET_CAR_BY_ID("0003"),

    /**
     * Sucess get all cards event logs.
     */
    SUCCESS_GET_CAR_BY_ID("0004"),


    /**
     * Try get all cars event logs.
     */
    TRY_GET_CAR_BY_CUSTOM_FILTER("0005"),

    /**
     * Sucess get all cards event logs.
     */
    SUCCESS_GET_CAR_BY_CUSTOM_FILTER("0006"),



    /**
     * Error generic event logs.
     */
    ERROR_GENERIC("0100"),

    /**
     * Error item not found event logs.
     */
    ERROR_ITEM_NOT_FOUND("0101"),

    
    ERROR_INVALID_REQUEST("0102");


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
