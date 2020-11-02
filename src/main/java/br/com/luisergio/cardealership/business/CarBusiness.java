package br.com.luisergio.cardealership.business;

import br.com.luisergio.cardealership.dto.CarDto;
import br.com.luisergio.cardealership.dto.CarRequestDto;
import br.com.luisergio.cardealership.dto.ItemIdDto;

import java.util.List;

public interface CarBusiness {

    List<CarDto> getAll();

    CarDto getById(Long id);

    ItemIdDto addCar(CarRequestDto carRequestDto);

    CarDto updateCar(CarRequestDto carRequestDto, Long id);
}
