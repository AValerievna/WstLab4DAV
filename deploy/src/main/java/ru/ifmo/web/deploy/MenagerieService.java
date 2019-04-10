package ru.ifmo.web.deploy;

import ru.ifmo.web.database.dao.MenagerieDAO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.Date;

@RequestScoped
@Path("/menagerie")
@Produces({MediaType.APPLICATION_JSON})
public class MenagerieService {
    @Inject
    private MenagerieDAO menagerieDAO;

    @WebMethod
    @GET
    @Path("/all")
    public MenagerieWrapper findAll() throws SQLException {
        return new MenagerieWrapper( menagerieDAO.findAllValues());
    }

    @WebMethod
    @GET
    @Path("/filter")
    public MenagerieWrapper findWithFilters(@QueryParam("id") Long id, @QueryParam("name") String name,
                                          @QueryParam("title") String title, @QueryParam("position") String position,
                                          @QueryParam("planet") String planet, @QueryParam("birthdate") Date birthdate) throws SQLException {
        return new MenagerieWrapper(menagerieDAO.filterValues(id, name, title, position, planet, birthdate));
    }
}
