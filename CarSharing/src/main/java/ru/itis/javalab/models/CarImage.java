package ru.itis.javalab.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarImage {

    long id;
    String image;
    long car_id;

}
