package app.dao;

import app.models.EventType;

import java.sql.ResultSet;
import java.util.List;

public class EventTypeDao extends Crud<EventType> {

    @Override
    EventType fetch(int id) {
        return null;
    }

    @Override
    List<EventType> fetchAll(int limit, int offset) {
        return null;
    }

    @Override
    boolean create(EventType eventType) {
        return false;
    }

    @Override
    boolean update(EventType eventType) {
        return false;
    }

    @Override
    boolean delete(EventType eventType) {
        return false;
    }

}
