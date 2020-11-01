package ru.itis.javalab.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private long id;
    private String firstName;
    private String lastName;
    private String login;
    private String email;
    private String phone;
    private String password;
    private String avatar;
    private String city;

}
