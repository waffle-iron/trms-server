package app.models;

import java.util.Objects;

public class Reimbursement extends Model {

    private User employee;
    private Event event;
    private int directSupervisorApprovedOn;
    private boolean directSupervisorAutoApproved;
    private int departmentHeadApprovedOn;
    private boolean departmentHeadAutoApproved;
    private int benCoApprovedOn;
    private int deniedOn;
    private String deniedReason;

    public Reimbursement() {
    }

    public Reimbursement(User employee, Event event, int directSupervisorApprovedOn, boolean directSupervisorAutoApproved, int departmentHeadApprovedOn, boolean departmentHeadAutoApproved, int benCoApprovedOn, int deniedOn, String deniedReason) {
        this.employee = employee;
        this.event = event;
        this.directSupervisorApprovedOn = directSupervisorApprovedOn;
        this.directSupervisorAutoApproved = directSupervisorAutoApproved;
        this.departmentHeadApprovedOn = departmentHeadApprovedOn;
        this.departmentHeadAutoApproved = departmentHeadAutoApproved;
        this.benCoApprovedOn = benCoApprovedOn;
        this.deniedOn = deniedOn;
        this.deniedReason = deniedReason;
    }

    public Reimbursement(int id, int dateCreated, int lastUpdated, User employee, Event event, int directSupervisorApprovedOn, boolean directSupervisorAutoApproved, int departmentHeadApprovedOn, boolean departmentHeadAutoApproved, int benCoApprovedOn, int deniedOn, String deniedReason) {
        super(id, dateCreated, lastUpdated);
        this.employee = employee;
        this.event = event;
        this.directSupervisorApprovedOn = directSupervisorApprovedOn;
        this.directSupervisorAutoApproved = directSupervisorAutoApproved;
        this.departmentHeadApprovedOn = departmentHeadApprovedOn;
        this.departmentHeadAutoApproved = departmentHeadAutoApproved;
        this.benCoApprovedOn = benCoApprovedOn;
        this.deniedOn = deniedOn;
        this.deniedReason = deniedReason;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getDirectSupervisorApprovedOn() {
        return directSupervisorApprovedOn;
    }

    public void setDirectSupervisorApprovedOn(int directSupervisorApprovedOn) {
        this.directSupervisorApprovedOn = directSupervisorApprovedOn;
    }

    public boolean isDirectSupervisorAutoApproved() {
        return directSupervisorAutoApproved;
    }

    public void setDirectSupervisorAutoApproved(boolean directSupervisorAutoApproved) {
        this.directSupervisorAutoApproved = directSupervisorAutoApproved;
    }

    public int getDepartmentHeadApprovedOn() {
        return departmentHeadApprovedOn;
    }

    public void setDepartmentHeadApprovedOn(int departmentHeadApprovedOn) {
        this.departmentHeadApprovedOn = departmentHeadApprovedOn;
    }

    public boolean isDepartmentHeadAutoApproved() {
        return departmentHeadAutoApproved;
    }

    public void setDepartmentHeadAutoApproved(boolean departmentHeadAutoApproved) {
        this.departmentHeadAutoApproved = departmentHeadAutoApproved;
    }

    public int getBenCoApprovedOn() {
        return benCoApprovedOn;
    }

    public void setBenCoApprovedOn(int benCoApprovedOn) {
        this.benCoApprovedOn = benCoApprovedOn;
    }

    public int getDeniedOn() {
        return deniedOn;
    }

    public void setDeniedOn(int deniedOn) {
        this.deniedOn = deniedOn;
    }

    public String getDeniedReason() {
        return deniedReason;
    }

    public void setDeniedReason(String deniedReason) {
        this.deniedReason = deniedReason;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "employee=" + employee +
                ", event=" + event +
                ", directSupervisorApprovedOn=" + directSupervisorApprovedOn +
                ", directSupervisorAutoApproved=" + directSupervisorAutoApproved +
                ", departmentHeadApprovedOn=" + departmentHeadApprovedOn +
                ", departmentHeadAutoApproved=" + departmentHeadAutoApproved +
                ", benCoApprovedOn=" + benCoApprovedOn +
                ", deniedOn=" + deniedOn +
                ", deniedReason='" + deniedReason + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reimbursement)) return false;
        Reimbursement that = (Reimbursement) o;
        return getDirectSupervisorApprovedOn() == that.getDirectSupervisorApprovedOn() &&
                isDirectSupervisorAutoApproved() == that.isDirectSupervisorAutoApproved() &&
                getDepartmentHeadApprovedOn() == that.getDepartmentHeadApprovedOn() &&
                isDepartmentHeadAutoApproved() == that.isDepartmentHeadAutoApproved() &&
                getBenCoApprovedOn() == that.getBenCoApprovedOn() &&
                getDeniedOn() == that.getDeniedOn() &&
                Objects.equals(getEmployee(), that.getEmployee()) &&
                Objects.equals(getEvent(), that.getEvent()) &&
                Objects.equals(getDeniedReason(), that.getDeniedReason());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getEmployee(), getEvent(), getDirectSupervisorApprovedOn(), isDirectSupervisorAutoApproved(), getDepartmentHeadApprovedOn(), isDepartmentHeadAutoApproved(), getBenCoApprovedOn(), getDeniedOn(), getDeniedReason());
    }
}
