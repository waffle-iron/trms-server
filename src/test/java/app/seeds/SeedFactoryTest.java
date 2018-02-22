package app.seeds;

import app.models.Reimbursement;
import app.models.Role;
import app.models.User;
import com.github.javafaker.Faker;
import org.junit.Test;

import static org.junit.Assert.*;

public class SeedFactoryTest {

    @Test
    public void fake() {
        assertTrue(SeedFactory.fake() instanceof Faker);
    }

    @Test
    public void number() {
        int number = SeedFactory.number(1,2);
        assertTrue(number >= 1 && number <=2);
    }

    @Test
    public void createUser() {
        User user = SeedFactory.createUser();
        assertEquals(0, user.getId());
        assertEquals(0, user.getDateCreated());
        assertEquals(0, user.getLastUpdated());
        assertTrue(user.getFirstName() instanceof String);
        assertTrue(user.getLastName() instanceof String);
        assertTrue(user.getJobTitle() instanceof String);
        assertTrue(user.getEmail() instanceof String);
        assertTrue(user.getRole() instanceof Role);
        assertEquals("secret", user.getPassword());
        assertNull(user.getDirectSupervisor());
        assertNull(user.getDirectSupervisor());
    }

    @Test
    public void createDbUser() {

    }

    @Test
    public void createRole() {
        Role role = SeedFactory.createRole("Employee");
        assertEquals(0, role.getId());
        assertEquals(0, role.getDateCreated());
        assertEquals(0, role.getLastUpdated());
        assertEquals("Employee", role.getName());
    }
}