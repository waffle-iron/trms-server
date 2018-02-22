package app.models;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class RoleTest {

    @Test
    public void id() {
        Role role = new Role();
        role.setId(1L);
        assertEquals(Optional.of(1L), role.getId());
    }

    @Test
    public void name() {
        Role role = new Role();
        role.setName("employee");
        assertEquals("employee", role.getName());
    }

}