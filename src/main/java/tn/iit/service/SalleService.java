package tn.iit.service;



import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.ResponseBody;

import tn.iit.entity.Salle;

public interface SalleService {
    
    @POST
    @Path("/create_update_salle")
    @ResponseBody
    Response createUpdateSalle(Salle salle);
    
    @GET
    @Path("/get_all_salles")
    @ResponseBody
    Response getAllSalles();

    @GET
    @Path("/get_salle/{id}")
    @ResponseBody
    Response getSalleById(@PathParam("id") Integer id);


}