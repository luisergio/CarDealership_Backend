package br.com.luisergio.cardealership;

import br.com.luisergio.cardealership.entity.Car;
import br.com.luisergio.cardealership.filter.MdcLogEnhancerFilter;
import br.com.luisergio.cardealership.repository.CarRepository;
import br.com.luisergio.cardealership.utils.LoggerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.sql.Timestamp;

/**
 * The type Car dealership application.
 */
@ComponentScan(basePackages = "br.com.luisergio",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
                classes = MdcLogEnhancerFilter.class))
@SpringBootApplication
public class CarDealershipApplication {

    /**
     * The Logger service.
     */
    @Autowired
	private LoggerService loggerService;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
		SpringApplication.run(CarDealershipApplication.class, args);
	}

    /**
     * Demo command line runner.
     *
     * @param repository the repository
     * @return the command line runner
     */
    @Bean
	public CommandLineRunner demo(CarRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(getCar("Palio", "Fiat", 1990));
			repository.save(getCar("Uno", "Fiat", 1995));
			repository.save(getCar("Ka", "Ford", 2010));
			repository.save(getCar("Prisma", "Chevrolet", 2015));
			repository.save(getCar("CRV", "Honda", 2020));

			// fetch all cars
            loggerService.log("Car found with findAll():");
            loggerService.log("-------------------------------");
			for (Car car : repository.findAll()) {
                loggerService.log(car.toString());
			}
            loggerService.log("");

			// fetch an individual car by ID
			Car car = repository.findById(1L);
			loggerService.log("Car found with findById(1L):");
			loggerService.log("--------------------------------");
			loggerService.log(car.toString());
			loggerService.log("");

			// Update an individual car
			car.setYear(2012);
			repository.save(car);
			car = repository.findById(1L);
			loggerService.log("Car found with findById(1L) after year update:");
			loggerService.log("--------------------------------");
			loggerService.log(car.toString());
			loggerService.log("");

			// fetch cars by brand
			loggerService.log("Car found with findByBrand('Fiat'):");
			loggerService.log("--------------------------------------------");
			repository.findByBrand("Fiat").forEach(fiat -> {
				loggerService.log(fiat.toString());
			});
			loggerService.log("");

			// fetch cars by period
			loggerService.log("Car found with findByYearPeriod(2010,2019):");
			loggerService.log("--------------------------------------------");
			repository.findByYearPeriod(2010, 2019).forEach(fiat -> {
				loggerService.log(fiat.toString());
			});

			loggerService.log("");
		};
	}

	private Car getCar(String name, String brand, Integer year){
		return Car.builder()
				.name(name)
				.brand(brand)
				.year(year)
				.description("")
				.sold(false)
				.created(new Timestamp(System.currentTimeMillis()))
				.updated(new Timestamp(System.currentTimeMillis()))
				.build();
	}

}
