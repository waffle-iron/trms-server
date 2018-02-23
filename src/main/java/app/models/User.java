package app.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class User extends Model {

    private String firstName;
    private String lastName;
    private String jobTitle;
    private String email;
    private int roleId;
    private String password;
    private int directSupervisorId;
    private int departmentHeadId;

    public User() {
    }

    public User(String firstName, String lastName, String jobTitle, String email, int roleId, String password, int directSupervisorId, int departmentHeadId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.email = email;
        this.roleId = roleId;
        this.password = password;
        this.directSupervisorId = directSupervisorId;
        this.departmentHeadId = departmentHeadId;
    }

    public User(int id, LocalDateTime dateCreated, LocalDateTime lastUpdated, String firstName, String lastName, String jobTitle, String email, int roleId, String password, int directSupervisorId, int departmentHeadId) {
        super(id, dateCreated, lastUpdated);
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.email = email;
        this.roleId = roleId;
        this.password = password;
        this.directSupervisorId = directSupervisorId;
        this.departmentHeadId = departmentHeadId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDirectSupervisorId() {
        return directSupervisorId;
    }

    public void setDirectSupervisorId(int directSupervisorId) {
        this.directSupervisorId = directSupervisorId;
    }

    public int getDepartmentHeadId() {
        return departmentHeadId;
    }

    public void setDepartmentHeadId(int departmentHeadId) {
        this.departmentHeadId = departmentHeadId;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", email='" + email + '\'' +
                ", roleId=" + roleId +
                ", password='" + password + '\'' +
                ", directSupervisorId=" + directSupervisorId +
                ", departmentHeadId=" + departmentHeadId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getRoleId() == user.getRoleId() &&
                getDirectSupervisorId() == user.getDirectSupervisorId() &&
                getDepartmentHeadId() == user.getDepartmentHeadId() &&
                Objects.equals(getFirstName(), user.getFirstName()) &&
                Objects.equals(getLastName(), user.getLastName()) &&
                Objects.equals(getJobTitle(), user.getJobTitle()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getFirstName(), getLastName(), getJobTitle(), getEmail(), getRoleId(), getPassword(), getDirectSupervisorId(), getDepartmentHeadId());
    }
}
