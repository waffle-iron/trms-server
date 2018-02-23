package app.models;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class Event extends Model {

    private int eventTypeId;
    private LocalDateTime datetime;
    private String location;
    private String description;
    private String justification;
    private int cost;
    private int gradingFormatId;
    private String passingGradeCutoff;
    private LocalDateTime completedOn;
    private int statusId;
    private byte[] attachment;

    public Event() {
    }

    public Event(int eventTypeId, LocalDateTime datetime, String location, String description, String justification, int cost, int gradingFormatId, String passingGradeCutoff, LocalDateTime completedOn, int statusId, byte[] attachment) {
        this.eventTypeId = eventTypeId;
        this.datetime = datetime;
        this.location = location;
        this.description = description;
        this.justification = justification;
        this.cost = cost;
        this.gradingFormatId = gradingFormatId;
        this.passingGradeCutoff = passingGradeCutoff;
        this.completedOn = completedOn;
        this.statusId = statusId;
        this.attachment = attachment;
    }

    public Event(int id, LocalDateTime dateCreated, LocalDateTime lastUpdated, int eventTypeId, LocalDateTime datetime, String location, String description, String justification, int cost, int gradingFormatId, String passingGradeCutoff, LocalDateTime completedOn, int statusId, byte[] attachment) {
        super(id, dateCreated, lastUpdated);
        this.eventTypeId = eventTypeId;
        this.datetime = datetime;
        this.location = location;
        this.description = description;
        this.justification = justification;
        this.cost = cost;
        this.gradingFormatId = gradingFormatId;
        this.passingGradeCutoff = passingGradeCutoff;
        this.completedOn = completedOn;
        this.statusId = statusId;
        this.attachment = attachment;
    }

    public int getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(int eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getGradingFormatId() {
        return gradingFormatId;
    }

    public void setGradingFormatId(int gradingFormatId) {
        this.gradingFormatId = gradingFormatId;
    }

    public String getPassingGradeCutoff() {
        return passingGradeCutoff;
    }

    public void setPassingGradeCutoff(String passingGradeCutoff) {
        this.passingGradeCutoff = passingGradeCutoff;
    }

    public LocalDateTime getCompletedOn() {
        return completedOn;
    }

    public void setCompletedOn(LocalDateTime completedOn) {
        this.completedOn = completedOn;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
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
                "eventTypeId=" + eventTypeId +
                ", datetime=" + datetime +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", justification='" + justification + '\'' +
                ", cost=" + cost +
                ", gradingFormatId=" + gradingFormatId +
                ", passingGradeCutoff='" + passingGradeCutoff + '\'' +
                ", completedOn=" + completedOn +
                ", statusId=" + statusId +
                ", attachment=" + Arrays.toString(attachment) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return getEventTypeId() == event.getEventTypeId() &&
                getCost() == event.getCost() &&
                getGradingFormatId() == event.getGradingFormatId() &&
                getStatusId() == event.getStatusId() &&
                Objects.equals(getDatetime(), event.getDatetime()) &&
                Objects.equals(getLocation(), event.getLocation()) &&
                Objects.equals(getDescription(), event.getDescription()) &&
                Objects.equals(getJustification(), event.getJustification()) &&
                Objects.equals(getPassingGradeCutoff(), event.getPassingGradeCutoff()) &&
                Objects.equals(getCompletedOn(), event.getCompletedOn()) &&
                Arrays.equals(getAttachment(), event.getAttachment());
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(getEventTypeId(), getDatetime(), getLocation(), getDescription(), getJustification(), getCost(), getGradingFormatId(), getPassingGradeCutoff(), getCompletedOn(), getStatusId());
        result = 31 * result + Arrays.hashCode(getAttachment());
        return result;
    }
}
