package com.remote.developers.persistence.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "company_handy_person")
@Getter
@Setter
public class CompanyHandyPerson extends DefaultDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "full_name")
    private String fullName;

    @Column(columnDefinition = "company_id")
    private Long companyId;

    @Column(columnDefinition = "trade_id")
    private Long tradeId;
}

