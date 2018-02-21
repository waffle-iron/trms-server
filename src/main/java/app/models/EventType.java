package app.models;

import java.util.Objects;

public class EventType {

    private int id;
    private String name;
    private int percentage;

    public EventType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
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
