package app.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Reimbursement extends Model {

    private int employeeId;
    private int eventId;
    private LocalDateTime directSupervisorApprovedOn;
    private boolean directSupervisorAutoApproved;
    private LocalDateTime departmentHeadApprovedOn;
    private boolean departmentHeadAutoApproved;
    private LocalDateTime benCoApprovedOn;
    private LocalDateTime deniedOn;
    private String deniedReason;

    public Reimbursement() {
    }

    public Reimbursement(int employeeId, int eventId, LocalDateTime directSupervisorApprovedOn, boolean directSupervisorAutoApproved, LocalDateTime departmentHeadApprovedOn, boolean departmentHeadAutoApproved, LocalDateTime benCoApprovedOn, LocalDateTime deniedOn, String deniedReason) {
        this.employeeId = employeeId;
        this.eventId = eventId;
        this.directSupervisorApprovedOn = directSupervisorApprovedOn;
        this.directSupervisorAutoApproved = directSupervisorAutoApproved;
        this.departmentHeadApprovedOn = departmentHeadApprovedOn;
        this.departmentHeadAutoApproved = departmentHeadAutoApproved;
        this.benCoApprovedOn = benCoApprovedOn;
        this.deniedOn = deniedOn;
        this.deniedReason = deniedReason;
    }

    public Reimbursement(int id, LocalDateTime dateCreated, LocalDateTime lastUpdated, int employeeId, int eventId, LocalDateTime directSupervisorApprovedOn, boolean directSupervisorAutoApproved, LocalDateTime departmentHeadApprovedOn, boolean departmentHeadAutoApproved, LocalDateTime benCoApprovedOn, LocalDateTime deniedOn, String deniedReason) {
        super(id, dateCreated, lastUpdated);
        this.employeeId = employeeId;
        this.eventId = eventId;
        this.directSupervisorApprovedOn = directSupervisorApprovedOn;
        this.directSupervisorAutoApproved = directSupervisorAutoApproved;
        this.departmentHeadApprovedOn = departmentHeadApprovedOn;
        this.departmentHeadAutoApproved = departmentHeadAutoApproved;
        this.benCoApprovedOn = benCoApprovedOn;
        this.deniedOn = deniedOn;
        this.deniedReason = deniedReason;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
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
                "employeeId=" + employeeId +
                ", eventId=" + eventId +
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
        return getEmployeeId() == that.getEmployeeId() &&
                getEventId() == that.getEventId() &&
                isDirectSupervisorAutoApproved() == that.isDirectSupervisorAutoApproved() &&
                isDepartmentHeadAutoApproved() == that.isDepartmentHeadAutoApproved() &&
                Objects.equals(getDirectSupervisorApprovedOn(), that.getDirectSupervisorApprovedOn()) &&
                Objects.equals(getDepartmentHeadApprovedOn(), that.getDepartmentHeadApprovedOn()) &&
                Objects.equals(getBenCoApprovedOn(), that.getBenCoApprovedOn()) &&
                Objects.equals(getDeniedOn(), that.getDeniedOn()) &&
                Objects.equals(getDeniedReason(), that.getDeniedReason());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getEmployeeId(), getEventId(), getDirectSupervisorApprovedOn(), isDirectSupervisorAutoApproved(), getDepartmentHeadApprovedOn(), isDepartmentHeadAutoApproved(), getBenCoApprovedOn(), getDeniedOn(), getDeniedReason());
    }
}
