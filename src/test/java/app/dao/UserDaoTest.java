package app.dao;

import app.config.Config;
import app.models.User;
import app.seeds.SeedFactory;
import app.utilities.DaoUtility;
import app.utilities.TestCase;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class UserDaoTest extends TestCase {

    @Test
    public void canConnectToDatabase() {
        assertTrue(Config.ENVIRONMENT.equals("Testing"));
        assertTrue(DaoUtility.getUserDao().connection() instanceof Connection);
    }

    @Test
    public void fetch() {

    }

    @Test
    public void fetchAll() {
    }

    @Test
    public void create() {
        User user = SeedFactory.createUser();
        System.out.println(DaoUtility.getUserDao().create(user));
        assertTrue(DaoUtility.getUserDao().create(user));
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void buildObject() {
    }
}