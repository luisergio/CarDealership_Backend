package br.com.luisergio.cardealership;

import br.com.luisergio.cardealership.entity.Car;
import br.com.luisergio.cardealership.repository.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;

/**
 * The type Car dealership application.
 */
@SpringBootApplication
public class CarDealershipApplication {

	private static final Logger log = LoggerFactory.getLogger(CarDealershipApplication.class);

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
			log.info("Car found with findAll():");
			log.info("-------------------------------");
			for (Car car : repository.findAll()) {
				log.info(car.toString());
			}
			log.info("");

			// fetch an individual car by ID
			Car car = repository.findById(1L);
			log.info("Car found with findById(1L):");
			log.info("--------------------------------");
			log.info(car.toString());
			log.info("");

			// Update an individual car
			car.setYear(2012);
			repository.save(car);
			car = repository.findById(1L);
			log.info("Car found with findById(1L) after year update:");
			log.info("--------------------------------");
			log.info(car.toString());
			log.info("");

			// fetch cars by brand
			log.info("Car found with findByBrand('Fiat'):");
			log.info("--------------------------------------------");
			repository.findByBrand("Fiat").forEach(fiat -> {
				log.info(fiat.toString());
			});
			log.info("");

			// fetch cars by period
			log.info("Car found with findByYearPeriod(2010,2019):");
			log.info("--------------------------------------------");
			repository.findByYearPeriod(2010, 2019).forEach(fiat -> {
				log.info(fiat.toString());
			});

			log.info("");
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
