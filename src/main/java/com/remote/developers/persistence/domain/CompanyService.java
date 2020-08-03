package com.remote.developers.persistence.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "company_service")
@Getter
@Setter
public class CompanyService extends DefaultDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "trade_id")
    private Long tradeId;

    @Column(columnDefinition = "company_id")
    private Long companyId;
}

