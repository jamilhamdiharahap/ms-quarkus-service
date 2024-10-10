package org.icp.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import org.icp.dto.request.CustomerReq;
import org.icp.entity.Customer;
import org.icp.entity.User;
import org.icp.repository.CustomerRepository;
import org.icp.repository.UserRepository;

import java.util.List;

@ApplicationScoped
public class CustomerService {
    @Inject
    CustomerRepository customerRepository;
    @Inject
    UserRepository userRepository;

    @Transactional
    public Customer doAddCustomer(CustomerReq req) {
        if(customerRepository.findByUserId(req.getUserId()).isPresent())
            throw new WebApplicationException("user id " + req.getUserId() + " existing customer");

        User user = userRepository.findByIdOptional(req.getUserId()).orElseThrow(()-> new WebApplicationException("user id "+ req.getUserId() +" not found"));
        Customer customer = req.toCustomerReq(user);
        customerRepository.persist(customer);

        return customer;
    }

    public List<Customer> doGetCustomer() {
        return customerRepository.findAllRoleCustomer();
    }
}
