package com.remote.developers.persistence.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "company_handy_person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyHandyPerson extends DefaultDomain {

    public CompanyHandyPerson(String comment, Long id) {
        this.comment = comment;
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "full_name")
    private String fullName;

    @Column(columnDefinition = "company_id")
    private Long companyId;

    @Column(columnDefinition = "trade_id")
    private Long tradeId;

    @Column(columnDefinition = "comment")
    private String comment;
}

