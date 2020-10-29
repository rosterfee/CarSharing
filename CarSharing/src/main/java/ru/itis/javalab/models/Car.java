package ru.itis.javalab.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Car {

    long id;
    String mark;
    String model;
    int price;
    int powers;
    double engine;
    String transmission;
    int maxSpeed;
    double racing;
    String description;
    List<CarImage> photos;
}
