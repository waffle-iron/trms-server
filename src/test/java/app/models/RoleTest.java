package app.models;

import app.seeds.SeedFactory;
import app.utilities.TestCase;
import org.junit.Test;

import java.util.Date;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RoleTest extends TestCase {

    @Test
    public void name() {
        Role role = new Role();
        role.setName("employee");
        assertEquals("employee", role.getName());
    }

    @Test
    public void constructor() {
        int date = SeedFactory.unix();
        Role r = new Role(
                1,
                date,
                date,
                "name"
        );
        assertEquals(1, r.getId());
        assertEquals(date, r.getDateCreated());
        assertEquals(date, r.getLastUpdated());
        assertEquals("name", r.getName());
    }

    @Test
    public void equalsOverride() {
        Role r1 = new Role();
        Role r2 = new Role();
        assertTrue(r1.equals(r2));
    }

    @Test
    public void hashCodeOverride() {
        Role r = new Role();
        assertNotNull(r.hashCode());
    }

    @Test
    public void toStringOverride() {
        Role r1 = new Role();
        Role r2 = new Role();
        assertTrue(r1.toString().equals(r2.toString()));
    }

}