package app.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Status extends Model {

    private String status;
    private String description;

    public Status() {
    }

    public Status(String status, String description) {
        this.status = status;
        this.description = description;
    }

    public Status(int id, LocalDateTime dateCreated, LocalDateTime lastUpdated, String status, String description) {
        super(id, dateCreated, lastUpdated);
        this.status = status;
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Status{" +
                "status='" + status + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Status)) return false;
        Status status1 = (Status) o;
        return Objects.equals(getStatus(), status1.getStatus()) &&
                Objects.equals(getDescription(), status1.getDescription());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getStatus(), getDescription());
    }
}
