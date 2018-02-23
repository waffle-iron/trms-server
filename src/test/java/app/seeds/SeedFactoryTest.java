package app.seeds;

import app.models.*;
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
        assertNull(user.getDateCreated());
        assertNull(user.getLastUpdated());
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
        assertNull(role.getDateCreated());
        assertNull(role.getLastUpdated());
        assertEquals("Employee", role.getName());
    }

    @Test
    public void createReimbursement() {
        Reimbursement r = SeedFactory.createReimbursement();
        assertTrue(r.getEvent() instanceof Event);
        assertTrue(r.getEmployee() instanceof User);
        assertEquals(false,r.isDepartmentHeadAutoApproved());
        assertEquals(false, r.isDepartmentHeadAutoApproved());
    }

    @Test
    public void createEvent() {
        Event e = SeedFactory.createEvent();
        assertTrue(e.getEventType() instanceof EventType);
        assertNotNull(e.getDatetime());
        assertTrue(e.getLocation() instanceof String);
        assertTrue(e.getDescription() instanceof String);
        assertTrue(e.getJustification() instanceof String);
        assertTrue(e.getCost() <= 1000);
        assertTrue(e.getGradingFormat() instanceof GradingFormat);
        assertTrue(e.getPassingGradeCutoff() instanceof String);
        assertNull(e.getCompletedOn());
    }

    @Test
    public void createEventType() {
        EventType e = SeedFactory.createEventType();
        assertTrue(e.getName() instanceof String);
        assertTrue(e.getPercentage() <= 100);
    }

    @Test
    public void createGradingFormat() {
        GradingFormat g = SeedFactory.createGradingFormat();
        assertTrue(g.getFormat() instanceof String);
        assertTrue(g.getDescription() instanceof String);
    }

    @Test
    public void createStatus() {

    }
}