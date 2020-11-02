package br.com.luisergio.cardealership.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarDto {
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;
    private boolean sold;
    private String created;
    private String updated;
}
