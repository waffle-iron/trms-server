package app.models;

import java.time.Instant;
import java.time.LocalDateTime;

abstract class Model implements ModelObject {

    private int id;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;

    public Model() {
    }

    public Model(int id, LocalDateTime dateCreated, LocalDateTime lastUpdated) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void updateTimeStamps() {
        lastUpdated = LocalDateTime.now();

        if (dateCreated == null) {
            dateCreated = LocalDateTime.now();
        }
    }
}
