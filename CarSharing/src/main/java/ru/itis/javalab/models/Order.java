package ru.itis.javalab.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {

    long id;
    long userId;
    long carId;
    String date;
    String active;

}
