package app.models;

import java.util.Date;
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

    public User() {
    }

    public User(String firstName, String lastName, String jobTitle, String email, Role role, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public User(Long id, Date dateCreated, Date lastUpdated, String firstName, String lastName, String jobTitle, String email, Role role, String password, User directSupervisor, User departmentHead) {
        super(id, dateCreated, lastUpdated);
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.email = email;
        this.role = role;
        this.password = password;
        this.directSupervisor = directSupervisor;
        this.departmentHead = departmentHead;
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

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
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
        return Objects.equals(getFirstName(), user.getFirstName()) &&
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

        return Objects.hash(getFirstName(), getLastName(), getJobTitle(), getEmail(), getRole(), getPassword(), getDirectSupervisor(), getDepartmentHead());
    }
}
