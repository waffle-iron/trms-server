package app.models;

import java.time.LocalDate;
import java.util.Objects;

public class User extends Model {

    private String firstName;
    private String lastName;
    private String jobTitle;
    private String email;
    private Role role;
    private String password;
    private User directSupervisor;
    private User departmentHead;
    private LocalDate createdOn;
    private LocalDate updatedOn;

    public User() {
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getDirectSupervisor() {
        return directSupervisor;
    }

    public void setDirectSupervisor(User directSupervisor) {
        this.directSupervisor = directSupervisor;
    }

    public User getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(User departmentHead) {
        this.departmentHead = departmentHead;
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

    @Override
    public String toString() {
        return "User{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", password='" + password + '\'' +
                ", directSupervisor=" + directSupervisor +
                ", departmentHead=" + departmentHead +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                Objects.equals(getFirstName(), user.getFirstName()) &&
                Objects.equals(getLastName(), user.getLastName()) &&
                Objects.equals(getJobTitle(), user.getJobTitle()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getRole(), user.getRole()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getDirectSupervisor(), user.getDirectSupervisor()) &&
                Objects.equals(getDepartmentHead(), user.getDepartmentHead());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getFirstName(), getLastName(), getJobTitle(), getEmail(), getRole(), getPassword(), getDirectSupervisor(), getDepartmentHead());
    }
}
