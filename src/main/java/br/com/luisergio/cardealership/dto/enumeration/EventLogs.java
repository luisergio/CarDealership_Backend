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
     * Try add car event logs.
     */
    TRY_ADD_CAR("0007"),

    /**
     * Success add car event logs.
     */
    SUCCESS_ADD_CAR("0008"),

    /**
     * Try update car event logs.
     */
    TRY_UPDATE_CAR("0009"),

    /**
     * Sucess update car event logs.
     */
    SUCCESS_UPDATE_CAR("0010"),

    /**
     * Try delete car event logs.
     */
    TRY_DELETE_CAR("0011"),

    /**
     * Sucess delete car event logs.
     */
    SUCCESS_DELETE_CAR("0012"),



    /**
     * Error generic event logs.
     */
    ERROR_GENERIC("0100"),

    /**
     * Error item not found event logs.
     */
    ERROR_ITEM_NOT_FOUND("0101"),


    /**
     * Error invalid request event logs.
     */
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
