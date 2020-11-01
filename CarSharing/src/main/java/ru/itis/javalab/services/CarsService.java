package ru.itis.javalab.services;

import ru.itis.javalab.models.Car;

import java.util.List;
import java.util.Optional;

public interface CarsService {

    void save(Car entity);

    List<Car> getAll();

    Optional<Car> getCarByName(String name);

    Optional<Car> getCarById(long id);

    List<Car> getAllByLs(int from, int to);

    List<Car> getAllByLs(int from);

    List<Car> getAllByPrice(int from, int to);

    List<Car> getAllByPrice(int from);

    List<Car> getAllByMark(String mark);

    List<Car> getAllExceptMarks(String mark1, String mark2, String mark3);

    List<Car> getAllByEngine(double from, double to);

    List<Car> getAllByEngine(double from);

    List<Car> getAllByBox(String box);

    Optional<Car> getSuchCar(Car car);
}
