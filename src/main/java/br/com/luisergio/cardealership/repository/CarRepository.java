package br.com.luisergio.cardealership.repository;

import br.com.luisergio.cardealership.entity.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findByBrand(String brand);

    List<Car> findBySold(boolean sold);

    List<Car> findByYear(Integer year);

    @Query("SELECT c FROM Car c WHERE c.year >= :firstYear and c.year <= :lastYear")
    List<Car> findByYearPeriod(Integer firstYear, Integer lastYear);

    Car findById(long id);

}
