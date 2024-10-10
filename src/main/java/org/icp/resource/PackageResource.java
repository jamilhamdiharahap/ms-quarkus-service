package org.icp.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.icp.dto.request.PackageReq;
import org.icp.entity.Package;
import org.icp.helper.MyResponse;
import org.icp.services.PackageService;

import java.util.List;

@Path("/package")
public class PackageResource {
    @Inject
    PackageService packageService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPackage(PackageReq pkg) {
        String message = packageService.doAddPackage(pkg);
        return MyResponse.ok(message);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPackages() {
        List<Package> packages = packageService.doGetPackages();
        return MyResponse.ok(packages);
    }

    @POST
    @Path("/by-id")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletePackage(@QueryParam("id") String id) {
        String message = packageService.doDeletePackage(id);
        return MyResponse.ok(message);
    }

    @GET
    @Path("/by-id")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPackage(@QueryParam("id") String id) {
        Package pkg = packageService.doGetPackage(id);
        return MyResponse.ok(pkg);
    }
}
