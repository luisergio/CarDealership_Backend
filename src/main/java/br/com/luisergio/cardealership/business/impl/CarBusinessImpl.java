package br.com.luisergio.cardealership.business.impl;

import br.com.luisergio.cardealership.business.BaseBusiness;
import br.com.luisergio.cardealership.business.CarBusiness;
import br.com.luisergio.cardealership.dto.CarDto;
import br.com.luisergio.cardealership.dto.CarRequestDto;
import br.com.luisergio.cardealership.dto.ItemIdDto;
import br.com.luisergio.cardealership.entity.Car;
import br.com.luisergio.cardealership.exception.ItemNotFoundException;
import br.com.luisergio.cardealership.repository.CarRepository;
import br.com.luisergio.cardealership.utils.GlobalConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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
        return this.getDto(this.getEntityById(id));
    }

    @Override
    public ItemIdDto addCar(CarRequestDto carRequestDto) {
        Car car = this.getEntity(carRequestDto);
        carRepository.save(car);
        return ItemIdDto.builder().id(car.getId()).build();
    }

    @Override
    public CarDto updateCar(CarRequestDto carRequestDto, Long id) {
        Car car = this.getEntityById(id);

        car.setName(carRequestDto.getName());
        car.setBrand(carRequestDto.getBrand());
        car.setYear(carRequestDto.getYear());
        car.setDescription(carRequestDto.getDescription());
        car.setSold(carRequestDto.isSold());
        car.setUpdated(new Timestamp(System.currentTimeMillis()));
        carRepository.save(car);

        return this.getDto(car);
    }

    private Car getEntityById(Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);

        if(optionalCar.isPresent())
            return optionalCar.get();
        else
            throw new ItemNotFoundException(GlobalConstants.ERROR_ITEM_NOT_FOUND);
    }

    public CarDto getDto(Car car){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy' 'HH:mm:ss:S");

        Date createdDate = new Date(car.getCreated().getTime());
        Date updatedDate = new Date(car.getUpdated().getTime());

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

    private Car getEntity(CarRequestDto carRequestDto) {
        return Car.builder()
                .name(carRequestDto.getName())
                .brand(carRequestDto.getBrand())
                .year(carRequestDto.getYear())
                .description(carRequestDto.getDescription())
                .sold(carRequestDto.isSold())
                .created(new Timestamp(System.currentTimeMillis()))
                .updated(new Timestamp(System.currentTimeMillis()))
                .build();
    }
}
