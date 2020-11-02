package br.com.luisergio.cardealership.controller;

import br.com.luisergio.cardealership.business.CarBusiness;
import br.com.luisergio.cardealership.dto.CarDto;
import br.com.luisergio.cardealership.dto.enumeration.EventLogs;
import br.com.luisergio.cardealership.entity.Car;
import br.com.luisergio.cardealership.utils.GlobalConstants;
import br.com.luisergio.cardealership.utils.LoggerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping()
    public List<CarDto> getAllCars(){

        loggerService.log(EventLogs.TRY_GET_ALL_CARS);

        List<CarDto> result = carBusiness.getAll();

        loggerService.log(EventLogs.SUCCESS_GET_ALL_CARS);

        return result;
    }

    @GetMapping(GlobalConstants.URL_PATH_ID)
    public CarDto getCarById(@PathVariable(GlobalConstants.PATH_ID) Long id){

        loggerService.log(EventLogs.TRY_GET_CAR_BY_ID);

        CarDto result = carBusiness.getById(id);

        loggerService.log(EventLogs.SUCCESS_GET_CAR_BY_ID);

        return result;
    }

}
