package app.models;

import java.time.LocalDate;
import java.util.Objects;

public class Reimbursement extends Model {

    private User employee;
    private Event event;
    private LocalDate createdOn;
    private LocalDate updatedOn;
    private LocalDate directSupervisorApprovedOn;
    private boolean directSupervisorAutoApproved;
    private LocalDate departmentHeadApprovedOn;
    private boolean departmentHeadAutoApproved;
    private LocalDate benCoApprovedOn;
    private LocalDate deniedOn;
    private String deniedReason;

    public Reimbursement() {
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

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDate getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDate updatedOn) {
        this.updatedOn = updatedOn;
    }

    public LocalDate getDirectSupervisorApprovedOn() {
        return directSupervisorApprovedOn;
    }

    public void setDirectSupervisorApprovedOn(LocalDate directSupervisorApprovedOn) {
        this.directSupervisorApprovedOn = directSupervisorApprovedOn;
    }

    public boolean isDirectSupervisorAutoApproved() {
        return directSupervisorAutoApproved;
    }

    public void setDirectSupervisorAutoApproved(boolean directSupervisorAutoApproved) {
        this.directSupervisorAutoApproved = directSupervisorAutoApproved;
    }

    public LocalDate getDepartmentHeadApprovedOn() {
        return departmentHeadApprovedOn;
    }

    public void setDepartmentHeadApprovedOn(LocalDate departmentHeadApprovedOn) {
        this.departmentHeadApprovedOn = departmentHeadApprovedOn;
    }

    public boolean isDepartmentHeadAutoApproved() {
        return departmentHeadAutoApproved;
    }

    public void setDepartmentHeadAutoApproved(boolean departmentHeadAutoApproved) {
        this.departmentHeadAutoApproved = departmentHeadAutoApproved;
    }

    public LocalDate getBenCoApprovedOn() {
        return benCoApprovedOn;
    }

    public void setBenCoApprovedOn(LocalDate benCoApprovedOn) {
        this.benCoApprovedOn = benCoApprovedOn;
    }

    public LocalDate getDeniedOn() {
        return deniedOn;
    }

    public void setDeniedOn(LocalDate deniedOn) {
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
                ", employee=" + employee +
                ", event=" + event +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
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
        return getId() == that.getId() &&
                isDirectSupervisorAutoApproved() == that.isDirectSupervisorAutoApproved() &&
                isDepartmentHeadAutoApproved() == that.isDepartmentHeadAutoApproved() &&
                Objects.equals(getEmployee(), that.getEmployee()) &&
                Objects.equals(getEvent(), that.getEvent()) &&
                Objects.equals(getCreatedOn(), that.getCreatedOn()) &&
                Objects.equals(getUpdatedOn(), that.getUpdatedOn()) &&
                Objects.equals(getDirectSupervisorApprovedOn(), that.getDirectSupervisorApprovedOn()) &&
                Objects.equals(getDepartmentHeadApprovedOn(), that.getDepartmentHeadApprovedOn()) &&
                Objects.equals(getBenCoApprovedOn(), that.getBenCoApprovedOn()) &&
                Objects.equals(getDeniedOn(), that.getDeniedOn()) &&
                Objects.equals(getDeniedReason(), that.getDeniedReason());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getEmployee(), getEvent(), getCreatedOn(), getUpdatedOn(), getDirectSupervisorApprovedOn(), isDirectSupervisorAutoApproved(), getDepartmentHeadApprovedOn(), isDepartmentHeadAutoApproved(), getBenCoApprovedOn(), getDeniedOn(), getDeniedReason());
    }
}
