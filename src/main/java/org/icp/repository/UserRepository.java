package org.icp.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.icp.dto.response.UserDtoRes;
import org.icp.entity.User;

import java.util.List;

@ApplicationScoped
public class UserRepository implements PanacheRepositoryBase<User, String> {
    public List<UserDtoRes> findAllUserDto() {
        return find("SELECT u.id, u.username, u.userStatus, u.roles.roleName, u.isOnline, u.createdAt FROM User u")
                .project(UserDtoRes.class)
                .list();
    }
}
