package org.icp.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import org.icp.dto.request.RegisterReq;
import org.icp.dto.response.UserDtoRes;
import org.icp.entity.Role;
import org.icp.entity.User;
import org.icp.entity.enums.UserStatus;
import org.icp.repository.RoleRepository;
import org.icp.repository.UserRepository;

import java.sql.Timestamp;
import java.util.List;

@ApplicationScoped
public class UserService {
    @Inject
    UserRepository userRepository;

    @Inject
    RoleRepository roleRepository;

    @Transactional
    public RegisterReq doRegister(RegisterReq req) {
        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(req.getPassword());
        user.setUserStatus(UserStatus.ACTIVE.name());
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        Role role = roleRepository.findByRoleId(req.getRoleId());
        if (role == null) {
            throw new WebApplicationException("Role not found");
        }
        user.setRoles(role);

        userRepository.persist(user);
        return req;
    }

    public List<UserDtoRes> doGetAll() {
        return userRepository.findAllUserDto();
    }

    @Transactional
    public String doUpdateStatus(String id) {
        User user = userRepository.findById(id);

        if (user == null) {
            throw new WebApplicationException("User not found");
        }

        switch (user.getUserStatus()) {
            case "ACTIVE":
                user.setUserStatus(UserStatus.INACTIVE.name());
                user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
                userRepository.persistAndFlush(user);
                return "User updated";
            case "INACTIVE":
                user.setUserStatus(UserStatus.ACTIVE.name());
                user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
                userRepository.persistAndFlush(user);
                return "User updated";
            default:
                return "User tidak ditemukan";
        }
    }
}
