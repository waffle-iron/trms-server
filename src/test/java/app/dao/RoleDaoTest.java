package app.dao;

import app.models.Role;
import app.utilities.DaoUtility;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoleDaoTest {

    @Test
    public void fetch() {
        Role role = DaoUtility.getRoleDao().fetch(1);
        assertEquals(1, role.getId());
    }

    @Test
    public void fetchAll() {
    }

    @Test
    public void create() {
        Role role = new Role("Administrator");
        assertTrue(DaoUtility.getRoleDao().create(role));
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