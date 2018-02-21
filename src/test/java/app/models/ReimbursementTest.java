package app.models;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class ReimbursementTest {

    private Reimbursement reimbursement;
    private LocalDate date;

    @Before
    public void setUp() {
        reimbursement = new Reimbursement();
        date = LocalDate.now();
    }

    @Test
    public void constructor() {
        Reimbursement reimbursement = new Reimbursement();
        assertTrue(reimbursement instanceof Reimbursement);
    }

    @Test
    public void id() {
        reimbursement.setId(1);
        assertEquals(1, reimbursement.getId());
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
    public void createdOn() {
        reimbursement.setCreatedOn(date);
        assertEquals(date, reimbursement.getCreatedOn());
    }

    @Test
    public void updatedOn() {
        reimbursement.setUpdatedOn(date);
        assertEquals(date, reimbursement.getUpdatedOn());
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