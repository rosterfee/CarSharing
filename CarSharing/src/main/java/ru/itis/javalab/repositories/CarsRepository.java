package ru.itis.javalab.repositories;

import ru.itis.javalab.models.Car;

import java.util.List;
import java.util.Optional;

public interface CarsRepository extends CrudRepository<Car> {

    Optional<Car> findCarByName(String carName);

    List<Car> findByLs(int from, int to);

    List<Car> findByLs(int from);

    List<Car> findByPrice(int from, int to);

    List<Car> findByPrice(int from);

    List<Car> findByMark(String mark);

    List<Car> findByExceptMarks(String mark1, String mark2, String mark3);

    List<Car> findByEngine(double from, double to);

    List<Car> findByEngine(double from);

    List<Car> findByBox(String box);

}
