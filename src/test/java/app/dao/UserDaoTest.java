package app.dao;

import app.config.Config;
import app.models.User;
import app.seeds.SeedFactory;
import app.utilities.DaoUtility;
import app.utilities.TestCase;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserDaoTest extends TestCase {

    @Test
    public void canConnectToDatabase() {
        assertTrue(Config.ENVIRONMENT.equals("Testing"));
        assertTrue(DaoUtility.getUserDao().connection() instanceof Connection);
    }

    @Test
    public void fetch() {
        DaoUtility.getUserDao().create(SeedFactory.createUser());
        User user = DaoUtility.getUserDao().fetch(1);
        assertEquals(1, user.getId());
    }

    @Test
    public void fetchAll() {
        DaoUtility.getUserDao().create(SeedFactory.createUser());
        DaoUtility.getUserDao().create(SeedFactory.createUser());
        DaoUtility.getUserDao().create(SeedFactory.createUser());
        List<User> users = DaoUtility.getUserDao().fetchAll(10, 0);
        assertEquals(3, users.size());
    }

    @Test
    public void create() {
        User user = SeedFactory.createUser();
        assertTrue(DaoUtility.getUserDao().create(user) instanceof User);
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}