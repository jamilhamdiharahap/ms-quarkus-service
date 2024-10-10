package org.icp.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.icp.entity.Customer;
import org.icp.entity.enums.RoleType;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CustomerRepository implements PanacheRepositoryBase<Customer, String> {
    public List<Customer> findAllRoleCustomer() {
        return find("user.roles.roleName", RoleType.CUSTOMER.name()).list();
    }

    public Optional<Customer> findByUserId(String userId) {
        return find("userId", userId).firstResultOptional();
    }
}
