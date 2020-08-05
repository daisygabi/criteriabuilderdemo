package com.remote.developers.persistence.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 * Status of a request initiated by a user
 * A handy person is the person that does the job
 */
public enum RequestStatus implements GrantedAuthority {
    INITIALISED("Initialised", 0),
    ACCEPTED("Accepted", 1),
    IN_PROGRESS("In Progress", 2),
    PAUSED("Paused", 3),
    FINISHED_BY_HANDY_PERSON("Finished by handy person", 4),
    FINISHED_FROM_USER_POINT_OF_VIEW("Finished from user point of view", 5),
    STOPPED("Stopped", 6);

    private String typeName;
    private int typeId;

    RequestStatus(String typeName, int typeId) {
        this.typeName = typeName;
        this.typeId = typeId;
    }

    @Override
    public String getAuthority() {
        return name();
    }

    public static RequestStatus getByTypeName(String name) {
        for (RequestStatus value : values()) {
            if (value.typeName.equals(name)) return value;
        }
        return null;
    }
}
