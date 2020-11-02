package br.com.luisergio.cardealership.business;

import br.com.luisergio.cardealership.dto.CarDto;

import java.util.List;

public interface CarBusiness {

    List<CarDto> getAll();

    CarDto getById(Long id);
}
