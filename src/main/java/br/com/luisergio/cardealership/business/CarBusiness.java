package br.com.luisergio.cardealership.business;

import br.com.luisergio.cardealership.dto.CarDto;
import br.com.luisergio.cardealership.dto.CarRequestDto;
import br.com.luisergio.cardealership.dto.ItemIdDto;

import java.util.List;

/**
 * The interface Car business.
 */
public interface CarBusiness {

    /**
     * Gets all.
     *
     * @return the all
     */
    List<CarDto> getAll();

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    CarDto getById(Long id);

    /**
     * Add car item id dto.
     *
     * @param carRequestDto the car request dto
     * @return the item id dto
     */
    ItemIdDto addCar(CarRequestDto carRequestDto);

    /**
     * Update car car dto.
     *
     * @param carRequestDto the car request dto
     * @param id            the id
     * @return the car dto
     */
    CarDto updateCar(CarRequestDto carRequestDto, Long id);

    /**
     * Delete car car dto.
     *
     * @param id the id
     * @return the car dto
     */
    void deleteCar(Long id);
}
