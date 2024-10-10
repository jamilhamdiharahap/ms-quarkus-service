package org.icp.resource;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.icp.dto.request.LoginReq;
import org.icp.dto.request.RegisterReq;
import org.icp.dto.response.UserDtoRes;
import org.icp.helper.MyResponse;
import org.icp.services.UserService;

import java.util.List;

@Path("user")
public class UserResource {
    @Inject
    UserService userService;

    @Path("login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginReq user) {
        return MyResponse.ok(user);
    }

    @Path("register")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(RegisterReq user) {
        RegisterReq req = userService.doRegister(user);
        return MyResponse.ok(req);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getUser() {
        List<UserDtoRes> users = userService.doGetAll();
        return MyResponse.ok(users);
    }

    @Path("update-status")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUserStatus(@QueryParam("id") String id) {
        String status = userService.doUpdateStatus(id);
        return MyResponse.ok(status);
    }

}
