package br.com.luisergio.cardealership.business.impl;

import br.com.luisergio.cardealership.business.BaseBusiness;
import br.com.luisergio.cardealership.business.CarBusiness;
import br.com.luisergio.cardealership.dto.CarDto;
import br.com.luisergio.cardealership.entity.Car;
import br.com.luisergio.cardealership.exception.ItemNotFoundException;
import br.com.luisergio.cardealership.repository.CarRepository;
import br.com.luisergio.cardealership.utils.GlobalConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * The type Car business.
 */
@Service
public class CarBusinessImpl extends BaseBusiness<CarDto, Car> implements CarBusiness {

    /**
     * The Car repository.
     */
    @Autowired
    CarRepository carRepository;

    @Override
    public List<CarDto> getAll() {
        return this.iterableToList(carRepository.findAll());
    }

    @Override
    public CarDto getById(Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);

        if(optionalCar.isPresent())
            return this.getDto(optionalCar.get());
        else
            throw new ItemNotFoundException(GlobalConstants.ERROR_ITEM_NOT_FOUND);
    }

    public CarDto getDto(Car car){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy' 'HH:mm:ss:S");

        Date createdDate = new Date(car.getCreated().getTime());
        Date updatedDate = new Date(car.getCreated().getTime());

        return CarDto.builder()
                .id(car.getId())
                .name(car.getName())
                .brand(car.getBrand())
                .year(car.getYear())
                .description(car.getDescription())
                .sold(car.isSold())
                .created(simpleDateFormat.format(createdDate))
                .updated(simpleDateFormat.format(updatedDate))
                .build();
    }
}
