package app.services;

import app.models.Event;

import java.util.List;

public interface EventService {
    List<Event> getEvents();
    List<Event> getEventsByUser(int userId);

}
