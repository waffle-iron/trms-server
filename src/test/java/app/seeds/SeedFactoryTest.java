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
        assertNotNull(user.getFirstName());
        assertNotNull(user.getLastName());
        assertNotNull(user.getJobTitle());
        assertNotNull(user.getEmail());
        assertTrue(user.getRoleId() > 0);
        assertEquals("secret", user.getPassword());
        assertTrue(user.getDirectSupervisorId() > 0);
        assertTrue(user.getDirectSupervisorId() > 0);
    }

    @Test
    public void createDbUser() {

    }

    @Test
    public void createRole() {
        Role role = SeedFactory.createRole();
        assertEquals(0, role.getId());
        assertNull(role.getDateCreated());
        assertNull(role.getLastUpdated());
        assertEquals("Employee", role.getName());
    }

    @Test
    public void createReimbursement() {
        User u = SeedFactory.createDbUser();
        Reimbursement r = SeedFactory.createReimbursement(u.getId());
        assertTrue(r.getEventId() > 0);
        assertTrue(r.getEmployeeId() > 0);
        assertEquals(false,r.isDepartmentHeadAutoApproved());
        assertEquals(false, r.isDepartmentHeadAutoApproved());
    }

    @Test
    public void createEvent() {
        Event e = SeedFactory.createEvent();
        assertTrue(e.getEventTypeId() > 0);
        assertNotNull(e.getDatetime());
        assertNotNull(e.getLocation());
        assertNotNull(e.getDescription());
        assertNotNull(e.getJustification());
        assertTrue(e.getCost() <= 1000);
        assertTrue(e.getGradingFormatId() > 0);
        assertNotNull(e.getPassingGradeCutoff());
        assertNull(e.getCompletedOn());
    }

    @Test
    public void createEventType() {
        EventType e = SeedFactory.createEventType();
        assertNotNull(e.getName());
        assertTrue(e.getPercentage() <= 100);
    }

    @Test
    public void createGradingFormat() {
        GradingFormat g = SeedFactory.createGradingFormat();
        assertNotNull(g.getFormat());
        assertNotNull(g.getDescription());
    }

    @Test
    public void createStatus() {

    }
}