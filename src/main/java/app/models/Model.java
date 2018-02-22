package app.models;

import java.util.Date;

abstract class Model implements ModelObject {

    private Long id;
    private Date dateCreated;
    private Date lastUpdated;

    public Model() {
    }

    public Model(Long id, Date dateCreated, Date lastUpdated) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }

    @Override
    public Long getId() {
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void updateTimeStamps() {
        lastUpdated = new Date();

        if (dateCreated == null) {
            dateCreated = new Date();
        }
    }
}
