package ru.itis.javalab.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Feedback {

    long id;
    String text;
    String date;
    User user;

}
