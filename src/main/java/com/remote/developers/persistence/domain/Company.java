package com.remote.developers.persistence.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "company")
@Getter
@Setter
public class Company extends DefaultDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "username")
    private String username;

    @Column(columnDefinition = "email")
    private String email;

    @Column(columnDefinition = "address")
    private String address;

    @Column(columnDefinition = "city")
    private String city;

    @Column(columnDefinition = "country")
    private String country;

    @Column(columnDefinition = "cif")
    private String cif;

    @Column(columnDefinition = "public_name")
    private String publicName;

    @Column(columnDefinition = "phone")
    private String phone;
}

