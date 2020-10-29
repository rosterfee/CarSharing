package ru.itis.javalab.services;

import ru.itis.javalab.models.CarImage;

import java.io.InputStream;
import java.util.List;

public interface CarImagesService {

    List<CarImage> getAllByCarId(long carId);

    void save(InputStream inputStream, long carId);

}
