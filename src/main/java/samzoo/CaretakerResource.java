package samzoo;
import cz.unicode.webapp.managers.CaretakerManager;
import cz.unicode.webapp.models.AnimalModel;
import cz.unicode.webapp.managers.AnimalManager;
import cz.unicode.webapp.models.CaretakerModel;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Path("caretakers")
public class CaretakerResource {
    @Inject
    private Caretaker manager;
    @GET
    public Response getAllCaretakers(){
        return Response.ok(manager.getAllCareTakers()).build();
    }

    @POST
    public Response addCareTaker(CaretakerModel careTaker) {

        manager.addCareTaker(careTaker);
        return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    public Response editCareTaker(@PathParam("id") int id, CaretakerModel careTaker) {

        if(manager.editCareTaker(id, careTaker)){
            return Response.ok("Caretaker edited").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }
    @DELETE
    @Path("{id}")
    public Response deleteCareTaker(@PathParam("id") int id) {
        if(manager.removeCareTaker(id)){
            return Response.ok("Caretaker removed").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }

    @GET
    @Path("{id}")
    public Response getCareTakerById(@PathParam("id") int id){
        return Response.ok(manager.returnCareTaker(id)).build();
    }

}
