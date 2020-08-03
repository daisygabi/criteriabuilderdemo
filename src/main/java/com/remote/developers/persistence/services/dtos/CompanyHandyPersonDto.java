package com.remote.developers.persistence.services.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyHandyPersonDto {

    private Long id;
    private String fullName;
    private Long companyId;
    private Long tradeId;
}
