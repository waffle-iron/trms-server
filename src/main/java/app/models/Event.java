package app.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Arrays;
import java.util.Objects;

public class Event extends Model {

    private EventType eventType;
    private int datetime;
    private String location;
    private String description;
    private String justification;
    private BigDecimal cost;
    private GradingFormat gradingFormat;
    private String passingGradeCutoff;
    private int completedOn;
    private String status;
    private byte[] attachment;

    public Event() {
    }

    public Event(EventType eventType, int datetime, String location, String description, String justification, BigDecimal cost, GradingFormat gradingFormat, String passingGradeCutoff, int completedOn, String status, byte[] attachment) {
        this.eventType = eventType;
        this.datetime = datetime;
        this.location = location;
        this.description = description;
        this.justification = justification;
        this.cost = cost;
        this.gradingFormat = gradingFormat;
        this.passingGradeCutoff = passingGradeCutoff;
        this.completedOn = completedOn;
        this.status = status;
        this.attachment = attachment;
    }

    public Event(int id, int dateCreated, int lastUpdated, EventType eventType, int datetime, String location, String description, String justification, BigDecimal cost, GradingFormat gradingFormat, String passingGradeCutoff, int completedOn, String status, byte[] attachment) {
        super(id, dateCreated, lastUpdated);
        this.eventType = eventType;
        this.datetime = datetime;
        this.location = location;
        this.description = description;
        this.justification = justification;
        this.cost = cost;
        this.gradingFormat = gradingFormat;
        this.passingGradeCutoff = passingGradeCutoff;
        this.completedOn = completedOn;
        this.status = status;
        this.attachment = attachment;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public int getDatetime() {
        return datetime;
    }

    public void setDatetime(int datetime) {
        this.datetime = datetime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public GradingFormat getGradingFormat() {
        return gradingFormat;
    }

    public void setGradingFormat(GradingFormat gradingFormat) {
        this.gradingFormat = gradingFormat;
    }

    public String getPassingGradeCutoff() {
        return passingGradeCutoff;
    }

    public void setPassingGradeCutoff(String passingGradeCutoff) {
        this.passingGradeCutoff = passingGradeCutoff;
    }

    public int getCompletedOn() {
        return completedOn;
    }

    public void setCompletedOn(int completedOn) {
        this.completedOn = completedOn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public byte[] getAttachment() {
        return attachment;
    }

    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventType=" + eventType +
                ", datetime=" + datetime +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", justification='" + justification + '\'' +
                ", cost=" + cost +
                ", gradingFormat=" + gradingFormat +
                ", passingGradeCutoff='" + passingGradeCutoff + '\'' +
                ", completedOn=" + completedOn +
                ", status='" + status + '\'' +
                ", attachment=" + Arrays.toString(attachment) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return getDatetime() == event.getDatetime() &&
                getCompletedOn() == event.getCompletedOn() &&
                Objects.equals(getEventType(), event.getEventType()) &&
                Objects.equals(getLocation(), event.getLocation()) &&
                Objects.equals(getDescription(), event.getDescription()) &&
                Objects.equals(getJustification(), event.getJustification()) &&
                Objects.equals(getCost(), event.getCost()) &&
                Objects.equals(getGradingFormat(), event.getGradingFormat()) &&
                Objects.equals(getPassingGradeCutoff(), event.getPassingGradeCutoff()) &&
                Objects.equals(getStatus(), event.getStatus()) &&
                Arrays.equals(getAttachment(), event.getAttachment());
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(getEventType(), getDatetime(), getLocation(), getDescription(), getJustification(), getCost(), getGradingFormat(), getPassingGradeCutoff(), getCompletedOn(), getStatus());
        result = 31 * result + Arrays.hashCode(getAttachment());
        return result;
    }
}
