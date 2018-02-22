package app.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Reimbursement extends Model {

    private User employee;
    private Event event;
    private LocalDateTime directSupervisorApprovedOn;
    private boolean directSupervisorAutoApproved;
    private LocalDateTime departmentHeadApprovedOn;
    private boolean departmentHeadAutoApproved;
    private LocalDateTime benCoApprovedOn;
    private LocalDateTime deniedOn;
    private String deniedReason;

    public Reimbursement() {
    }

    public Reimbursement(User employee, Event event, LocalDateTime directSupervisorApprovedOn, boolean directSupervisorAutoApproved, LocalDateTime departmentHeadApprovedOn, boolean departmentHeadAutoApproved, LocalDateTime benCoApprovedOn, LocalDateTime deniedOn, String deniedReason) {
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

    public Reimbursement(int id, LocalDateTime dateCreated, LocalDateTime lastUpdated, User employee, Event event, LocalDateTime directSupervisorApprovedOn, boolean directSupervisorAutoApproved, LocalDateTime departmentHeadApprovedOn, boolean departmentHeadAutoApproved, LocalDateTime benCoApprovedOn, LocalDateTime deniedOn, String deniedReason) {
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

    public LocalDateTime getDirectSupervisorApprovedOn() {
        return directSupervisorApprovedOn;
    }

    public void setDirectSupervisorApprovedOn(LocalDateTime directSupervisorApprovedOn) {
        this.directSupervisorApprovedOn = directSupervisorApprovedOn;
    }

    public boolean isDirectSupervisorAutoApproved() {
        return directSupervisorAutoApproved;
    }

    public void setDirectSupervisorAutoApproved(boolean directSupervisorAutoApproved) {
        this.directSupervisorAutoApproved = directSupervisorAutoApproved;
    }

    public LocalDateTime getDepartmentHeadApprovedOn() {
        return departmentHeadApprovedOn;
    }

    public void setDepartmentHeadApprovedOn(LocalDateTime departmentHeadApprovedOn) {
        this.departmentHeadApprovedOn = departmentHeadApprovedOn;
    }

    public boolean isDepartmentHeadAutoApproved() {
        return departmentHeadAutoApproved;
    }

    public void setDepartmentHeadAutoApproved(boolean departmentHeadAutoApproved) {
        this.departmentHeadAutoApproved = departmentHeadAutoApproved;
    }

    public LocalDateTime getBenCoApprovedOn() {
        return benCoApprovedOn;
    }

    public void setBenCoApprovedOn(LocalDateTime benCoApprovedOn) {
        this.benCoApprovedOn = benCoApprovedOn;
    }

    public LocalDateTime getDeniedOn() {
        return deniedOn;
    }

    public void setDeniedOn(LocalDateTime deniedOn) {
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
        return isDirectSupervisorAutoApproved() == that.isDirectSupervisorAutoApproved() &&
                isDepartmentHeadAutoApproved() == that.isDepartmentHeadAutoApproved() &&
                Objects.equals(getEmployee(), that.getEmployee()) &&
                Objects.equals(getEvent(), that.getEvent()) &&
                Objects.equals(getDirectSupervisorApprovedOn(), that.getDirectSupervisorApprovedOn()) &&
                Objects.equals(getDepartmentHeadApprovedOn(), that.getDepartmentHeadApprovedOn()) &&
                Objects.equals(getBenCoApprovedOn(), that.getBenCoApprovedOn()) &&
                Objects.equals(getDeniedOn(), that.getDeniedOn()) &&
                Objects.equals(getDeniedReason(), that.getDeniedReason());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getEmployee(), getEvent(), getDirectSupervisorApprovedOn(), isDirectSupervisorAutoApproved(), getDepartmentHeadApprovedOn(), isDepartmentHeadAutoApproved(), getBenCoApprovedOn(), getDeniedOn(), getDeniedReason());
    }
}
