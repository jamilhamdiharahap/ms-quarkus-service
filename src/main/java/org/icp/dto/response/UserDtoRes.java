package org.icp.dto.response;

import java.sql.Timestamp;

public class UserDtoRes {
    private final String id;
    private final String username;
    private final String roleName;
    private final String userStatus;
    private final Boolean isOnline;
    private final Timestamp createdAt;

    public UserDtoRes(String id, String username, String status, String roleName, Boolean isOnline, Timestamp createdAt) {
        this.id = id;
        this.username = username;
        this.userStatus = status;
        this.roleName = roleName;
        this.isOnline = isOnline;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public Boolean getOnline() {
        return isOnline;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
}
