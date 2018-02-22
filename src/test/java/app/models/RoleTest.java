package app.models;

import app.utilities.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoleTest extends TestCase {

    @Test
    public void name() {
        Role role = new Role();
        role.setName("employee");
        assertEquals("employee", role.getName());
    }

}