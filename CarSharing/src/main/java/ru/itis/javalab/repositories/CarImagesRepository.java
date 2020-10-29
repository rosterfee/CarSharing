package ru.itis.javalab.repositories;

import ru.itis.javalab.models.CarImage;

import java.io.InputStream;
import java.util.List;

public interface CarImagesRepository extends CrudRepository<CarImage> {

    List<CarImage> findAllByCarId(long carId);

    void save(InputStream inputStream, long carId);

}
