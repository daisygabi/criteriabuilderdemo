package com.remote.developers.persistence.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_request_service")
@Getter
@Setter
public class Job extends DefaultDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "user_id")
    private Long userId;

    @Column(columnDefinition = "handyman_id")
    private Long handymanId;

    @Column(columnDefinition = "request_status")
    private String requestStatus;

    @Column(columnDefinition = "user_feedback_title")
    private String userFeedbackTitle;

    @Column(columnDefinition = "user_feedback_description")
    private String userFeedbackDescription;
}

