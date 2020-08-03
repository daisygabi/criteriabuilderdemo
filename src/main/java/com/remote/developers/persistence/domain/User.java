package com.remote.developers.persistence.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User extends DefaultDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "full_name")
    private String fullName;

    @Column(columnDefinition = "email")
    private String email;

    @Column(columnDefinition = "city")
    private String city;

    @Column(columnDefinition = "country")
    private String country;

    @Column(columnDefinition = "phone")
    private String phone;
}

