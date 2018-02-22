package app.models;

import app.utilities.TestCase;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class UserTest extends TestCase {

    @Test
    public void hasEmptyConstructor() {
        assertTrue(new User() instanceof User);
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
    public void createdOn() {
        User user = new User();
        LocalDate date = LocalDate.now();
        user.setCreatedOn(date);
        assertEquals(date, user.getCreatedOn());
    }

    @Test
    public void updatedOn() {
        User user = new User();
        LocalDate date = LocalDate.now();
        user.setUpdatedOn(date);
        assertEquals(date, user.getUpdatedOn());
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