package ru.itis.javalab.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {

    long id;
    User user;
    Car car;
    String date;
    String active;
    String address;
    String timeOfOrderTaking;
    int price;

}
