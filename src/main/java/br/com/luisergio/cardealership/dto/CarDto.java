package br.com.luisergio.cardealership.dto;

import lombok.Builder;
import lombok.Data;

/**
 * The type Car dto.
 */
@Data
@Builder
public class CarDto {
    private Long id;
    private String name;
    private String brand;
    private Integer year;
    private String description;
    private boolean sold;
    private String created;
    private String updated;
}
