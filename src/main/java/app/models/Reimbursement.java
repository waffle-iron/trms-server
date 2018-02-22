package app.models;

import java.util.Date;
import java.util.Objects;

public class Reimbursement extends Model {

    private User employee;
    private Event event;
    private Date directSupervisorApprovedOn;
    private boolean directSupervisorAutoApproved;
    private Date departmentHeadApprovedOn;
    private boolean departmentHeadAutoApproved;
    private Date benCoApprovedOn;
    private Date deniedOn;
    private String deniedReason;

    public Reimbursement() {
    }

    public Reimbursement(Long id, Date dateCreated, Date lastUpdated, User employee, Event event, Date directSupervisorApprovedOn, boolean directSupervisorAutoApproved, Date departmentHeadApprovedOn, boolean departmentHeadAutoApproved, Date benCoApprovedOn, Date deniedOn, String deniedReason) {
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

    public Date getDirectSupervisorApprovedOn() {
        return directSupervisorApprovedOn;
    }

    public void setDirectSupervisorApprovedOn(Date directSupervisorApprovedOn) {
        this.directSupervisorApprovedOn = directSupervisorApprovedOn;
    }

    public boolean isDirectSupervisorAutoApproved() {
        return directSupervisorAutoApproved;
    }

    public void setDirectSupervisorAutoApproved(boolean directSupervisorAutoApproved) {
        this.directSupervisorAutoApproved = directSupervisorAutoApproved;
    }

    public Date getDepartmentHeadApprovedOn() {
        return departmentHeadApprovedOn;
    }

    public void setDepartmentHeadApprovedOn(Date departmentHeadApprovedOn) {
        this.departmentHeadApprovedOn = departmentHeadApprovedOn;
    }

    public boolean isDepartmentHeadAutoApproved() {
        return departmentHeadAutoApproved;
    }

    public void setDepartmentHeadAutoApproved(boolean departmentHeadAutoApproved) {
        this.departmentHeadAutoApproved = departmentHeadAutoApproved;
    }

    public Date getBenCoApprovedOn() {
        return benCoApprovedOn;
    }

    public void setBenCoApprovedOn(Date benCoApprovedOn) {
        this.benCoApprovedOn = benCoApprovedOn;
    }

    public Date getDeniedOn() {
        return deniedOn;
    }

    public void setDeniedOn(Date deniedOn) {
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
