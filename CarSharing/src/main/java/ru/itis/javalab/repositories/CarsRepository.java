package ru.itis.javalab.repositories;

import ru.itis.javalab.models.Car;

import java.util.Optional;

public interface CarsRepository extends CrudRepository<Car> {

    Optional<Car> findCarByName(String carName);

}
