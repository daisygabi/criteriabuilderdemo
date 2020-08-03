package com.remote.developers.persistence.services.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private Long id;
    private String fullName;
    private String email;
    private String city;
    private String country;
    private String phone;
}

