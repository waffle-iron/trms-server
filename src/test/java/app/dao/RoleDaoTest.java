package app.dao;

import app.config.Config;
import app.models.Role;
import app.utilities.DaoUtility;
import app.utilities.TestCase;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RoleDaoTest extends TestCase {

    @Test
    public void fetch() {
        Role role = DaoUtility.getRoleDao().fetch(1);
        assertEquals(1, role.getId());
        assertEquals("Benefits Coordinator", role.getName());
    }

    @Test
    public void fetchAll() {
        List<Role> roles = DaoUtility.getRoleDao().fetchAll(Config.PAGINATE, 0);
        assertEquals(5, roles.size());
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