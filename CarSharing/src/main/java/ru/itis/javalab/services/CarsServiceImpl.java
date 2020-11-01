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

    @Override
    public List<Car> getAllByLs(int from, int to) {
        return carsRepository.findByLs(from, to);
    }

    @Override
    public List<Car> getAllByLs(int from) {
        return carsRepository.findByLs(from);
    }

    @Override
    public List<Car> getAllByPrice(int from, int to) {
        return carsRepository.findByPrice(from, to);
    }

    @Override
    public List<Car> getAllByPrice(int from) {
        return carsRepository.findByPrice(from);
    }

    @Override
    public List<Car> getAllByMark(String mark) {
        return carsRepository.findByMark(mark);
    }

    @Override
    public List<Car> getAllExceptMarks(String mark1, String mark2, String mark3) {
        return carsRepository.findByExceptMarks(mark1, mark2, mark3);
    }

    @Override
    public List<Car> getAllByEngine(double from, double to) {
        return carsRepository.findByEngine(from ,to);
    }

    @Override
    public List<Car> getAllByEngine(double from) {
        return carsRepository.findByEngine(from);
    }

    @Override
    public List<Car> getAllByBox(String box) {
        return carsRepository.findByBox(box);
    }

    @Override
    public Optional<Car> getSuchCar(Car car) {
        return carsRepository.findSuchCar(car);
    }
}
