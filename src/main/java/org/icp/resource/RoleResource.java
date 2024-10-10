package org.icp.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.icp.dto.request.RoleReq;
import org.icp.helper.MyResponse;
import org.icp.services.RoleService;

@Path("role")
public class RoleResource {
    @Inject
    RoleService roleService;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getRole() {
        return MyResponse.ok(roleService.doGetRoles());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addRole(RoleReq roleName) {
        RoleReq roleReq = roleService.doGetCreate(roleName);
        return MyResponse.ok(roleReq);
    }
}
