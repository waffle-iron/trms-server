package app.dao;

import app.models.User;
import app.seeds.SeedFactory;
import app.utilities.DaoUtility;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void fetch() {

    }

    @Test
    public void fetchAll() {
    }

    @Test
    public void create() {
        User user = SeedFactory.createUser();
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