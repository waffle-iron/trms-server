package app.models;

import app.seeds.SeedFactory;
import app.utilities.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReimbursementTest extends TestCase {

    private Reimbursement reimbursement;
    private int date;

    @Before
    public void setUp() {
        reimbursement = new Reimbursement();
        date = SeedFactory.unix();
    }

    @Test
    public void constructor() {
        int date = SeedFactory.unix();
        Reimbursement r = new Reimbursement(
                1,
                date,
                date,
                new User(),
                new Event(),
                date,
                false,
                date,
                false,
                date,
                date,
                "denied reason"
        );
        assertEquals(1, r.getId());
        assertEquals(date, r.getDateCreated());
        assertEquals(date, r.getLastUpdated());
        assertTrue(r.getEmployee() instanceof User);
        assertTrue(r.getEvent() instanceof Event);
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
        User employee = new User();
        reimbursement.setEmployee(employee);
        assertEquals(employee, reimbursement.getEmployee());
    }

    @Test
    public void eventId() {
        Event event = new Event();
        reimbursement.setEvent(event);
        assertEquals(event, reimbursement.getEvent());
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