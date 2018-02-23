package app.dao;

import app.models.Event;
import app.utilities.DateConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventDao extends Crud<Event> {

    @Override
    Event fetch(int id) {
        Event event = new Event();
        try (Connection c = connection()) {
            String query = "SELECT * FROM events WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                event.setId(rs.getInt("id"));
                event.setEventTypeId(rs.getInt("event_type_id"));
                event.setDatetime(DateConverter.dateToLocalDateTime(rs.getTimestamp("datetime")));
                event.setLocation(rs.getString("location"));
                event.setDescription(rs.getString("description"));
                event.setJustification(rs.getString("justification"));
                event.setCost(rs.getInt("cost"));
                event.setGradingFormatId(rs.getInt("grading_format"));
                event.setPassingGradeCutoff(rs.getString("passing_grade_cutoff"));
                event.setCompletedOn(DateConverter.dateToLocalDateTime(rs.getTimestamp("completed_on")));
                event.setStatusId(rs.getInt("status_id"));
                event.setAttachment(rs.getBytes("attachment"));
                event.setDateCreated(DateConverter.dateToLocalDateTime(rs.getTimestamp("created_on")));
                event.setLastUpdated(DateConverter.dateToLocalDateTime(rs.getTimestamp("updated_on")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return event;
    }

    @Override
    List<Event> fetchAll(int limit, int offset) {
        List<Event> events = new ArrayList<>();
        try (Connection c = connection()) {
            String query = "SELECT * FROM events LIMIT ? OFFSET ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, limit);
            ps.setInt(2, offset);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Event event = new Event();
                event.setId(rs.getInt("id"));
                event.setEventTypeId(rs.getInt("event_type_id"));
                event.setDatetime(DateConverter.dateToLocalDateTime(rs.getTimestamp("datetime")));
                event.setLocation(rs.getString("location"));
                event.setDescription(rs.getString("description"));
                event.setJustification(rs.getString("justification"));
                event.setCost(rs.getInt("cost"));
                event.setGradingFormatId(rs.getInt("grading_format"));
                event.setPassingGradeCutoff(rs.getString("passing_grade_cutoff"));
                event.setCompletedOn(DateConverter.dateToLocalDateTime(rs.getTimestamp("completed_on")));
                event.setStatusId(rs.getInt("status_id"));
                event.setAttachment(rs.getBytes("attachment"));
                event.setDateCreated(DateConverter.dateToLocalDateTime(rs.getTimestamp("created_on")));
                event.setLastUpdated(DateConverter.dateToLocalDateTime(rs.getTimestamp("updated_on")));
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    @Override
    boolean create(Event event) {
        event.updateTimeStamps();
        try (Connection c = connection()) {
            String query = "INSERT INTO events (" +
                    "event_type_id, " +
                    "datetime, " +
                    "location, " +
                    "description, " +
                    "justification, " +
                    "cost, " +
                    "grading_format, " +
                    "passing_grade_cutoff, " +
                    "completed_on, " +
                    "status_id, " +
                    "attachment, " +
                    "created_on, " +
                    "updated_on" +
                    ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, event.getEventTypeId());
            ps.setTimestamp(2, DateConverter.dateToSQL(event.getDatetime()));
            ps.setString(3, event.getLocation());
            ps.setString(4, event.getDescription());
            ps.setString(5, event.getJustification());
            ps.setInt(6, event.getCost());
            ps.setInt(7, event.getGradingFormatId());
            ps.setString(8, event.getPassingGradeCutoff());
            ps.setTimestamp(9, DateConverter.dateToSQL(event.getCompletedOn()));
            ps.setInt(10, event.getStatusId());
            ps.setBytes(11, event.getAttachment());
            ps.setTimestamp(12, DateConverter.dateToSQL(event.getDateCreated()));
            ps.setTimestamp(13, DateConverter.dateToSQL(event.getLastUpdated()));
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    boolean update(Event event) {
        event.updateTimeStamps();
        try (Connection c = connection()) {
            String query = "UPDATE events SET " +
                    "event_type_id = ?, " +
                    "datetime = ?, " +
                    "location = ?, " +
                    "description = ?, " +
                    "justification = ?, " +
                    "cost = ?, " +
                    "grading_format = ?, " +
                    "passing_grade_cutoff = ?, " +
                    "completed_on = ?, " +
                    "status_id = ?, " +
                    "attachment = ?, " +
                    "created_on = ?, " +
                    "updated_on = ? WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, event.getEventTypeId());
            ps.setTimestamp(2, DateConverter.dateToSQL(event.getDatetime()));
            ps.setString(3, event.getLocation());
            ps.setString(4, event.getDescription());
            ps.setString(5, event.getJustification());
            ps.setInt(6, event.getCost());
            ps.setInt(7, event.getGradingFormatId());
            ps.setString(8, event.getPassingGradeCutoff());
            ps.setTimestamp(9, DateConverter.dateToSQL(event.getCompletedOn()));
            ps.setInt(10, event.getStatusId());
            ps.setBytes(11, event.getAttachment());
            ps.setTimestamp(12, DateConverter.dateToSQL(event.getDateCreated()));
            ps.setTimestamp(13, DateConverter.dateToSQL(event.getLastUpdated()));
            ps.setInt(14, event.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    boolean delete(Event event) {
        try (Connection c = connection()) {
            String query = "DELETE FROM events WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, event.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
