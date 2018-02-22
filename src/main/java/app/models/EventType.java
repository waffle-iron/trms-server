package app.models;

import java.util.Date;
import java.util.Objects;

public class EventType extends Model {

    private String name;
    private int percentage;

    public EventType() {
        super();
    }

    public EventType(Long id, Date dateCreated, Date lastUpdated, String name, int percentage) {
        super(id, dateCreated, lastUpdated);
        this.name = name;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "EventType{" +
                ", name='" + name + '\'' +
                ", percentage=" + percentage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventType)) return false;
        EventType eventType = (EventType) o;
        return getId() == eventType.getId() &&
                getPercentage() == eventType.getPercentage() &&
                Objects.equals(getName(), eventType.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName(), getPercentage());
    }
}
