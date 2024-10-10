package org.icp.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.icp.entity.Role;

@ApplicationScoped
public class RoleRepository implements PanacheRepository<Role> {
    public Role findByRoleName(String name) {
        return find("roleName", name).firstResult();
    }

    public Role findByRoleId(String id) {
        return find("id", id).firstResult();
    }
}
