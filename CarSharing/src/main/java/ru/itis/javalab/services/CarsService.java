package ru.itis.javalab.services;

import ru.itis.javalab.models.Car;

import java.util.List;
import java.util.Optional;

public interface CarsService {

    void save(Car entity);

    List<Car> getAll();

    Optional<Car> getCarByName(String name);

    Optional<Car> getCarById(long id);
}
