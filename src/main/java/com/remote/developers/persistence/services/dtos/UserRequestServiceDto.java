package com.remote.developers.persistence.services.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestServiceDto {
    private Long id;
    private Long userId;
    private Long handymanId;
    private String requestStatus;
    private String userFeedbackTitle;
    private String userFeedbackDescription;
}
