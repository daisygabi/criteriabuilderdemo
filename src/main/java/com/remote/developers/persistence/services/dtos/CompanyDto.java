package com.remote.developers.persistence.services.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDto {

    private Long id;
    private String username;
    private String email;
    private String address;
    private String city;
    private String country;
    private String cif;
    private String publicName;
    private String phone;
}
