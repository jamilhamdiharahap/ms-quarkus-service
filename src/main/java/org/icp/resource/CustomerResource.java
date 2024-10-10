package org.icp.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.icp.dto.request.CustomerReq;
import org.icp.entity.Customer;
import org.icp.helper.MyResponse;
import org.icp.services.CustomerService;

@Path("customer")
public class CustomerResource {
    @Inject
    CustomerService customerService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCustomer() {
        return MyResponse.ok(customerService.doGetCustomer());
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCustomer(CustomerReq customerReq) {
        Customer customer = customerService.doAddCustomer(customerReq);
        return MyResponse.ok(customer);
    }
}
