package br.com.luisergio.cardealership.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The type Car request dto.
 */
@Data
@Builder
public class CarRequestDto {
    @NotBlank(message = "The field 'name' is required.")
    private String name;

    @NotBlank(message = "The field 'brand' is required.")
    private String brand;

    @NotNull(message = "The field 'year' is required.")
    private Integer year;

    @NotBlank(message = "The field 'description' is required.")
    @Size(min = 1, max = 1024, message = "The max size for 'Description' is 1024 characters.")
    private String description;

    @NotNull(message = "The field 'sold' is required.")
    private boolean sold;
}
