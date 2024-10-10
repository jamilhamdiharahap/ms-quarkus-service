package org.icp.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import org.icp.dto.request.RoleReq;
import org.icp.entity.Role;
import org.icp.repository.RoleRepository;

import java.util.List;

@ApplicationScoped
public class RoleService {
    @Inject
    RoleRepository roleRepository;

    public List<Role> doGetRoles() {
        return roleRepository.listAll();
    }

    @Transactional
    public RoleReq doGetCreate(RoleReq role) {
        if(roleRepository.findByRoleName(role.getRoleName().toString()) != null) {
            throw new WebApplicationException("Role with name " + role.getRoleName() + " already exists", 400);
        }

        Role roleEntity = new Role();
        roleEntity.setRoleName(role.getRoleName().name());

        roleRepository.persist(roleEntity);
        return role;
    }
}
