package ru.ifmo.web.service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.postgresql.ds.PGSimpleDataSource;
import ru.ifmo.web.database.dao.MenagerieDAO;
import ru.ifmo.web.database.entity.Menagerie;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Data
@Slf4j
@Path("/menagerie")
@Produces({MediaType.APPLICATION_JSON})
public class MenagerieService {
    private MenagerieDAO menagerieDAO;

    public MenagerieService() {
        PGSimpleDataSource source = new PGSimpleDataSource();

        source.setServerName("localhost");
        source.setDatabaseName("astartes_db");
        source.setUser("webuser");
        source.setPassword("webpassword");
        this.menagerieDAO = new MenagerieDAO(source);
    }

    @GET
    @Path("/all")
    public List<Menagerie> findAll() throws SQLException {
        return menagerieDAO.findAllValues();
    }

    @GET
    @Path("/filter")
    public List<Menagerie> findWithFilters(@QueryParam("id") Long id, @QueryParam("name") String name,
                                          @QueryParam("title") String title, @QueryParam("position") String position,
                                          @QueryParam("planet") String planet, @QueryParam("birthdate") Date birthdate) throws SQLException {
        return menagerieDAO.filterValues(id, name, title, position, planet, birthdate);
    }
}
