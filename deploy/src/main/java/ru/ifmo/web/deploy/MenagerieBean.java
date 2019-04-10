package ru.ifmo.web.deploy;

import lombok.Data;
import ru.ifmo.web.database.dao.MenagerieDAO;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

@Data
@ApplicationScoped
public class MenagerieBean {
    @Resource(lookup = "jdbc/menagerie")
    private DataSource dataSource;

    @Produces
    public MenagerieDAO marineDAO() {
        return new MenagerieDAO(dataSource);
    }
}
