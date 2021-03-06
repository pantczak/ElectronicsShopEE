package pl.web.electronics_shop.rest;

import pl.web.electronics_shop.model.resoucre.Laptop;
import pl.web.electronics_shop.service.ResourceService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/devices")
public class ResourceResource {
    @Inject
    private ResourceService resourceService;

    @GET
    @Path("{uuid}")
    public Response getDevice(@PathParam("uuid") String uuid) {
        return Response.status(Response.Status.OK)
                .entity(resourceService.getResourceByUuid(UUID.fromString(uuid))).build();
    }

    @GET
    public Response getAllDevices() {
        return Response.status(200).entity(resourceService.getAllResources()).build();
    }

//    @PUT
//    @Path("/laptop")
//    public Response updateLaptop(Laptop laptop) {
//        if (resourceService.updateResource(laptop)) {
//            return Response.status(200).build();
//        }
//        return Response.status(422).build();
//
//    }
//}
