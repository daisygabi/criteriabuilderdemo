package com.remote.developers.persistence.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "trade")
@Getter
@Setter
public class Trade extends DefaultDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "name")
    private String name;
}
