package app.models;

import app.seeds.SeedFactory;
import app.utilities.TestCase;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class UserTest extends TestCase {

    @Test
    public void hasEmptyConstructor() {
        assertTrue(new User() instanceof User);
    }

    @Test
    public void constructor() {
        int date = SeedFactory.unix();
        User u = new User(
                1,
                date,
                date,
                "firstname",
                "lastname",
                "job title",
                "email",
                new Role(),
                "password",
                new User(),
                new User()
        );
        assertEquals(1, u.getId());
        assertEquals(date, u.getDateCreated());
        assertEquals(date, u.getLastUpdated());
        assertEquals("firstname", u.getFirstName());
        assertEquals("lastname", u.getLastName());
        assertEquals("job title", u.getJobTitle());
        assertEquals("email", u.getEmail());
        assertTrue(u.getRole() instanceof Role);
        assertEquals("password", u.getPassword());
        assertTrue(u.getDirectSupervisor() instanceof User);
        assertTrue(u.getDepartmentHead() instanceof User);

    }

    @Test
    public void firstName() {
        User user = new User();
        user.setFirstName("bobby");
        assertEquals("bobby", user.getFirstName());
    }

    @Test
    public void lastName() {
        User user = new User();
        user.setLastName("tables");
        assertEquals("tables", user.getLastName());
    }

    @Test
    public void jobTitle() {
        User user = new User();
        user.setJobTitle("engineer");
        assertEquals("engineer", user.getJobTitle());
    }

    @Test
    public void email() {
        User user = new User();
        user.setEmail("bobby@tables.com");
        assertEquals("bobby@tables.com", user.getEmail());
    }

    @Test
    public void role() {
        User user = new User();
        user.setRole(new Role());
        assertTrue(user.getRole() instanceof Role);
    }

    @Test
    public void password() {
        User user = new User();
        user.setPassword("secret");
        assertEquals("secret", user.getPassword());
    }

    @Test
    public void directSupervisor() {
        User user = new User();
        User directSupervisor = new User();
        user.setDirectSupervisor(directSupervisor);
        assertTrue(user.getDirectSupervisor() instanceof User);
    }

    @Test
    public void departmentHead() {
        User user = new User();
        User departmentHead = new User();
        user.setDepartmentHead(departmentHead);
        assertTrue(user.getDepartmentHead().equals(departmentHead));
    }

    @Test
    public void toStringOverride() {
        User user1 = new User();
        User user2 = new User();
        String usr1 = user1.toString();
        String usr2 = user2.toString();
        assertEquals(usr1, usr2);
    }

    @Test
    public void hashCodeOverride() {
        User user = new User();
        assertNotNull(user.hashCode());
    }
}