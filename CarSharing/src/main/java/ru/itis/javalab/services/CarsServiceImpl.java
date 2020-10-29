package ru.itis.javalab.services;

import ru.itis.javalab.models.Car;
import ru.itis.javalab.repositories.CarsRepository;

import java.util.List;
import java.util.Optional;

public class CarsServiceImpl implements CarsService {

    CarsRepository carsRepository;

    public CarsServiceImpl(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public void save(Car entity) {
        carsRepository.save(entity);
    }

    @Override
    public List<Car> getAll() {
        return carsRepository.findAll();
    }

    @Override
    public Optional<Car> getCarByName(String name) {
        return carsRepository.findCarByName(name);
    }

    @Override
    public Optional<Car> getCarById(long id) {
        return carsRepository.findById(id);
    }
}
