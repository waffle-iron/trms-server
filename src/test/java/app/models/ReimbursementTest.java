package app.models;

import app.seeds.SeedFactory;
import app.utilities.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class ReimbursementTest extends TestCase {

    private Reimbursement reimbursement;
    private LocalDateTime date;

    @Before
    public void setUp() {
        reimbursement = new Reimbursement();
        date = LocalDateTime.now();
    }

    @Test
    public void constructor() {
        LocalDateTime date = LocalDateTime.now();
        User u = SeedFactory.createDbUser();
        Reimbursement r = SeedFactory.createReimbursement(u.getId());
        assertEquals(1, r.getId());
        assertEquals(date, r.getDateCreated());
        assertEquals(date, r.getLastUpdated());
        assertEquals(u.getId(), r.getEmployeeId());
        assertEquals(1, r.getEventId());
        assertEquals(date, r.getDirectSupervisorApprovedOn());
        assertFalse(r.isDirectSupervisorAutoApproved());
        assertEquals(date, r.getDepartmentHeadApprovedOn());
        assertFalse(r.isDepartmentHeadAutoApproved());
        assertEquals(date, r.getBenCoApprovedOn());
        assertEquals(date, r.getDeniedOn());
        assertEquals("denied reason", r.getDeniedReason());
    }

    @Test
    public void constructor2() {
        LocalDateTime date = LocalDateTime.now();
        User u = SeedFactory.createDbUser();
        Reimbursement r = SeedFactory.createReimbursement(u.getId());
        assertEquals(0, r.getId());
        assertEquals(null, r.getDateCreated());
        assertEquals(null, r.getLastUpdated());
        assertEquals(u.getId(), r.getEmployeeId());
        assertEquals(1, r.getEventId());
        assertEquals(date, r.getDirectSupervisorApprovedOn());
        assertFalse(r.isDirectSupervisorAutoApproved());
        assertEquals(date, r.getDepartmentHeadApprovedOn());
        assertFalse(r.isDepartmentHeadAutoApproved());
        assertEquals(date, r.getBenCoApprovedOn());
        assertEquals(date, r.getDeniedOn());
        assertEquals("denied reason", r.getDeniedReason());
    }

    @Test
    public void constructor1() {
        Reimbursement reimbursement = new Reimbursement();
        assertTrue(reimbursement instanceof Reimbursement);
    }

    @Test
    public void employeeId() {
        User employee = SeedFactory.createDbUser();
        reimbursement.setEmployeeId(employee.getId());
        assertEquals(employee, reimbursement.getEmployeeId());
    }

    @Test
    public void eventId() {
        Event event = SeedFactory.createEvent();
        reimbursement.setEventId(event.getId());
        assertEquals(event, reimbursement.getEventId());
    }

    @Test
    public void directSupervisorApprovedOn() {
        reimbursement.setDirectSupervisorApprovedOn(date);
        assertEquals(date, reimbursement.getDirectSupervisorApprovedOn());
    }

    @Test
    public void directSupervisorAutoApproved() {
        reimbursement.setDirectSupervisorAutoApproved(true);
        assertTrue(reimbursement.isDirectSupervisorAutoApproved());
    }

    @Test
    public void departmentHeadApprovedOn() {
        reimbursement.setDepartmentHeadApprovedOn(date);
        assertEquals(date, reimbursement.getDepartmentHeadApprovedOn());
    }

    @Test
    public void departmentHeadAutoApproved() {
        reimbursement.setDepartmentHeadAutoApproved(true);
        assertTrue(reimbursement.isDepartmentHeadAutoApproved());
    }

    @Test
    public void benCoApprovedOn() {
        reimbursement.setBenCoApprovedOn(date);
        assertEquals(date, reimbursement.getBenCoApprovedOn());
    }

    @Test
    public void deniedOn() {
        reimbursement.setDeniedOn(date);
        assertEquals(date, reimbursement.getDeniedOn());
    }

    @Test
    public void deniedReason() {
        reimbursement.setDeniedReason("because");
        assertEquals("because", reimbursement.getDeniedReason());
    }

    @Test
    public void toStringOverride() {
        Reimbursement reimbursement1 = new Reimbursement();
        assertTrue(reimbursement.toString().equals(reimbursement1.toString()));
    }

    @Test
    public void equalsOverride() {
        Reimbursement reimbursement1 = new Reimbursement();
        assertTrue(reimbursement1.equals(reimbursement));
        assertTrue(reimbursement.equals(reimbursement1));
    }

    @Test
    public void hashCodeOverride() {
        assertNotNull(reimbursement.hashCode());
    }

}