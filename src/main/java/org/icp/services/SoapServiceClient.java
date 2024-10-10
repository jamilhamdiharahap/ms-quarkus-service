package org.icp.services;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("services/default/SOA_Master/WS_MASTER_REF_GROUP_ITEM")
@RegisterRestClient(configKey = "soap-material-api")
public interface SoapServiceClient {
    @POST
    @Consumes(MediaType.TEXT_XML)
    @Produces(MediaType.TEXT_XML)
    Response sendRequest(String ReqSoa);
}