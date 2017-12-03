package tn.iit.service.imp;

import javax.jws.WebService;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import tn.iit.dao.SalleDAO;
import tn.iit.entity.Salle;
import tn.iit.service.SalleService;
 

@Path("/")
@Produces("application/json")
@WebService(name="salleService")
public class SalleServiceImpl implements SalleService{

	@Autowired
	private SalleDAO salleDao;
	
	

	@Override
	public Response getAllSalles() {
		return Response.ok("",MediaType.APPLICATION_JSON_TYPE).build();
	}

	@Override
	public Response getSalleById(Integer id) {
		salleDao.findOne(id);
		return null;
	}

	@Override
	public Response createUpdateSalle(Salle salle) {
		salleDao.saveAndFlush(salle);
		return Response.ok("status: ok",MediaType.APPLICATION_JSON).build();
	}

}