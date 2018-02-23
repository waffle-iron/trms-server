package app.models;

import app.seeds.SeedFactory;
import app.utilities.TestCase;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.Assert.*;

public class UserTest extends TestCase {

    @Test
    public void hasEmptyConstructor() {
        assertTrue(new User() instanceof User);
    }

    @Test
    public void constructor() {
        LocalDateTime date = LocalDateTime.now();
        User u = SeedFactory.createDbUser();
        assertEquals(1, u.getId());
        assertEquals(date, u.getDateCreated());
        assertEquals(date, u.getLastUpdated());
        assertEquals("firstname", u.getFirstName());
        assertEquals("lastname", u.getLastName());
        assertEquals("job title", u.getJobTitle());
        assertEquals("email", u.getEmail());
        assertTrue(u.getRoleId() > 0);
        assertEquals("password", u.getPassword());
        assertTrue(u.getDirectSupervisorId() > 0);
        assertTrue(u.getDepartmentHeadId() > 0);

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
        user.setRoleId(100);
        assertEquals(100, user.getRoleId());
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
        User directSupervisor = SeedFactory.createDbUser();
        user.setDirectSupervisorId(directSupervisor.getId());
        assertEquals(directSupervisor.getId(), user.getDirectSupervisorId());
    }

    @Test
    public void departmentHead() {
        User user = new User();
        User departmentHead = SeedFactory.createDbUser();
        user.setDepartmentHeadId(departmentHead.getId());
        assertEquals(departmentHead.getId(), user.getDepartmentHeadId());
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