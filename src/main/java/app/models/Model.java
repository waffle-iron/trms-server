package app.models;

import java.time.Instant;

abstract class Model implements ModelObject {

    private int id;
    private int dateCreated;
    private int lastUpdated;

    public Model() {
    }

    public Model(int id, int dateCreated, int lastUpdated) {
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

    public int getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(int dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(int lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void updateTimeStamps() {
        lastUpdated = unix();

        if (dateCreated == 0) {
            dateCreated = unix();
        }
    }

    private int unix() {
        return (int) Instant.now().getEpochSecond();
    }
}
