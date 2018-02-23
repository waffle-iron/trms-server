package app.seeds;

import app.models.*;
import app.utilities.TestCase;
import com.github.javafaker.Faker;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class SeedFactoryTest extends TestCase {

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
    public void makeUser() {
        User user = SeedFactory.makeUser();
        assertEquals(0, user.getId());
        assertNull(user.getDateCreated());
        assertNull(user.getLastUpdated());
        assertNotNull(user.getFirstName());
        assertNotNull(user.getLastName());
        assertNotNull(user.getJobTitle());
        assertNotNull(user.getEmail());
        assertTrue(user.getRoleId() > 0);
        assertEquals("secret", user.getPassword());
        assertEquals(0, user.getDirectSupervisorId());
        assertEquals(0, user.getDepartmentHeadId());
    }

    @Test
    public void createUser() {
        User user = SeedFactory.createUser();
        assertTrue(user instanceof User);
    }

    @Test
    public void createRole() {
        Role role = SeedFactory.createRole();
        assertEquals(6, role.getId());
        assertTrue(role.getDateCreated() instanceof LocalDateTime);
        assertTrue(role.getLastUpdated() instanceof LocalDateTime);
        assertNotNull(role.getName());
    }

    @Test
    public void createReimbursement() {
        User u = SeedFactory.createUser();
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