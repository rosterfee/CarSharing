package ru.itis.javalab.services;

import ru.itis.javalab.models.CarImage;
import ru.itis.javalab.repositories.CarImagesRepository;

import java.io.InputStream;
import java.util.List;

public class CarImagesServiceImpl implements CarImagesService {

    CarImagesRepository carImagesRepository;

    public CarImagesServiceImpl(CarImagesRepository carImagesRepository) {
        this.carImagesRepository = carImagesRepository;
    }

    @Override
    public List<CarImage> getAllByCarId(long carId) {
        return carImagesRepository.findAllByCarId(carId);
    }

    @Override
    public void save(InputStream inputStream, long carId) {
        carImagesRepository.save(inputStream, carId);
    }
}
