package br.com.luisergio.cardealership.controller;

import br.com.luisergio.cardealership.business.CarBusiness;
import br.com.luisergio.cardealership.dto.CarDto;
import br.com.luisergio.cardealership.dto.CarRequestDto;
import br.com.luisergio.cardealership.dto.ItemIdDto;
import br.com.luisergio.cardealership.dto.enumeration.EventLogs;
import br.com.luisergio.cardealership.utils.GlobalConstants;
import br.com.luisergio.cardealership.utils.LoggerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Car controller.
 */
@RestController
@Slf4j
@RequestMapping(GlobalConstants.API_ROOT_URL)
public class CarController {

    /**
     * The Logger service.
     */
    @Autowired
    private LoggerService loggerService;

    @Autowired
    private CarBusiness carBusiness;

    /**
     * Get all cars list.
     *
     * @return the list
     */
    @GetMapping()
    public List<CarDto> getAllCars(){

        loggerService.log(EventLogs.TRY_GET_ALL_CARS);

        List<CarDto> result = carBusiness.getAll();

        loggerService.log(EventLogs.SUCCESS_GET_ALL_CARS);

        return result;
    }

    /**
     * Gets car by id.
     *
     * @param id the id
     * @return the car by id
     */
    @GetMapping(GlobalConstants.URL_PATH_ID)
    public CarDto getCarById(@PathVariable(GlobalConstants.PATH_ID) Long id){

        loggerService.log(EventLogs.TRY_GET_CAR_BY_ID);

        CarDto result = carBusiness.getById(id);

        loggerService.log(EventLogs.SUCCESS_GET_CAR_BY_ID);

        return result;
    }

    /**
     * Add car response entity.
     *
     * @param car the car
     * @return the response entity
     */
    @PostMapping()
    public ResponseEntity<ItemIdDto> addCar(@Valid @RequestBody CarRequestDto car) {

        loggerService.log(EventLogs.TRY_ADD_CAR);

        ItemIdDto id = carBusiness.addCar(car);
        ResponseEntity<ItemIdDto> responseEntity = new ResponseEntity<>(id, null, HttpStatus.CREATED);

        loggerService.log(EventLogs.SUCCESS_ADD_CAR);

        return responseEntity;
    }

    /**
     * Update car car dto.
     *
     * @param car the car
     * @param id  the id
     * @return the car dto
     */
    @PutMapping(GlobalConstants.URL_PATH_ID)
    public CarDto updateCar(@Valid @RequestBody CarRequestDto car,
            @PathVariable(GlobalConstants.PATH_ID) Long id) {

        loggerService.log(EventLogs.TRY_UPDATE_CAR);

        CarDto CarDto = carBusiness.updateCar(car, id);

        loggerService.log(EventLogs.SUCCESS_UPDATE_CAR);

        return CarDto;
    }

    @DeleteMapping(GlobalConstants.URL_PATH_ID)
    public ResponseEntity deleteCar(@PathVariable(GlobalConstants.PATH_ID) Long id) {

        loggerService.log(EventLogs.TRY_DELETE_CAR);

        carBusiness.deleteCar(id);

        loggerService.log(EventLogs.SUCCESS_DELETE_CAR);

        return new ResponseEntity(null,null,HttpStatus.OK);
    }

}
