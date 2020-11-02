package br.com.luisergio.cardealership.repository;

import br.com.luisergio.cardealership.entity.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The interface Car repository.
 */
public interface CarRepository extends CrudRepository<Car, Long> {

    /**
     * Find by brand list.
     *
     * @param brand the brand
     * @return the list
     */
    List<Car> findByBrand(String brand);

    /**
     * Find by sold list.
     *
     * @param sold the sold
     * @return the list
     */
    List<Car> findBySold(boolean sold);

    /**
     * Find by year list.
     *
     * @param year the year
     * @return the list
     */
    List<Car> findByYear(Integer year);

    /**
     * Find by year period list.
     *
     * @param firstYear the first year
     * @param lastYear  the last year
     * @return the list
     */
    @Query("SELECT c FROM Car c WHERE c.year >= :firstYear and c.year <= :lastYear")
    List<Car> findByYearPeriod(Integer firstYear, Integer lastYear);

    /**
     * Find by id car.
     *
     * @param id the id
     * @return the car
     */
    Car findById(long id);

}
