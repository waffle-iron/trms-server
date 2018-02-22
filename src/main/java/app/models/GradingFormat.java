package app.models;

import java.util.Objects;

public class GradingFormat extends Model {

    private String format;
    private String description;

    public GradingFormat() {
    }

    public GradingFormat(int id, int dateCreated, int lastUpdated, String format, String description) {
        super(id, dateCreated, lastUpdated);
        this.format = format;
        this.description = description;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "GradingFormat{" +
                ", format='" + format + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GradingFormat)) return false;
        GradingFormat that = (GradingFormat) o;
        return getId() == that.getId() &&
                Objects.equals(getFormat(), that.getFormat()) &&
                Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getFormat(), getDescription());
    }
}
