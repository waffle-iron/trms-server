package app.models;

import java.util.Date;
import java.util.Objects;

public class Role extends Model {

    private String name;

    public Role() {
    }

    public Role(Long id, Date dateCreated, Date lastUpdated, String name) {
        super(id, dateCreated, lastUpdated);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return Objects.equals(getName(), role.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName());
    }
}
