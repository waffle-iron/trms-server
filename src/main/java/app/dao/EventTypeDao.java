package app.dao;

import app.models.EventType;
import app.utilities.DateConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventTypeDao extends Crud<EventType> {

    @Override
    EventType fetch(int id) {
        EventType eventType = new EventType();
        try (Connection c = connection()) {
            String query = "SELECT * FROM event_types WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                eventType.setId(rs.getInt("id"));
                eventType.setName(rs.getString("name"));
                eventType.setPercentage(rs.getInt("percentage"));
                eventType.setDateCreated(DateConverter.dateToLocalDateTime(rs.getTimestamp("created_on")));
                eventType.setLastUpdated(DateConverter.dateToLocalDateTime(rs.getTimestamp("updated_on")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventType;
    }

    @Override
    List<EventType> fetchAll(int limit, int offset) {
        List<EventType> eventTypes = new ArrayList<>();
        try (Connection c = connection()) {
            String query = "SELECT * FROM event_types LIMIT ? OFFSET ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, limit);
            ps.setInt(2, offset);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EventType eventType = new EventType();
                eventType.setId(rs.getInt("id"));
                eventType.setName(rs.getString("name"));
                eventType.setPercentage(rs.getInt("percentage"));
                eventType.setDateCreated(DateConverter.dateToLocalDateTime(rs.getTimestamp("created_on")));
                eventType.setLastUpdated(DateConverter.dateToLocalDateTime(rs.getTimestamp("updated_on")));
                eventTypes.add(eventType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventTypes;
    }

    @Override
    boolean create(EventType eventType) {
        eventType.updateTimeStamps();
        try (Connection c = connection()) {
            String query = "INSERT INTO event_types (" +
                    "name, " +
                    "percentage, " +
                    "created_on, " +
                    "updated_on" +
                    ") VALUES (?, ?, ?, ?)";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, eventType.getName());
            ps.setInt(2, eventType.getPercentage());
            ps.setTimestamp(3, DateConverter.dateToSQL(eventType.getDateCreated()));
            ps.setTimestamp(4, DateConverter.dateToSQL(eventType.getLastUpdated()));
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    boolean update(EventType eventType) {
        eventType.updateTimeStamps();
        try (Connection c = connection()) {
            String query = "UPDATE event_types SET " +
                    "name = ?, " +
                    "percentage = ?, " +
                    "updated_on = ? WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, eventType.getName());
            ps.setInt(2, eventType.getPercentage());
            ps.setTimestamp(3, DateConverter.dateToSQL(eventType.getLastUpdated()));
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    boolean delete(EventType eventType) {
        try (Connection c = connection()) {
            String query = "DELETE FROM event_types WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, eventType.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
