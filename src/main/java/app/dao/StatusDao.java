package app.dao;

import app.models.Status;
import app.utilities.DateConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusDao extends Crud<Status> {
    @Override
    public Status fetch(int id) {
        Status status = new Status();
        try (Connection c = connection()) {
            String query = "SELECT * FROM statuses WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                status.setId(rs.getInt("id"));
                status.setStatus(rs.getString("status"));
                status.setDescription(rs.getString("description"));
                status.setDateCreated(DateConverter.dateToLocalDateTime(rs.getTimestamp("created_on")));
                status.setLastUpdated(DateConverter.dateToLocalDateTime(rs.getTimestamp("updated_on")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public List<Status> fetchAll(int limit, int offset) {
        List<Status> statuses = new ArrayList<>();
        try (Connection c = connection()) {
            String query = "SELECT * FROM statuses LIMIT ? OFFSET ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, limit);
            ps.setInt(2, offset);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Status status = new Status();
                status.setId(rs.getInt("id"));
                status.setStatus(rs.getString("status"));
                status.setDescription(rs.getString("description"));
                status.setDateCreated(DateConverter.dateToLocalDateTime(rs.getTimestamp("created_on")));
                status.setLastUpdated(DateConverter.dateToLocalDateTime(rs.getTimestamp("updated_on")));
                statuses.add(status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statuses;
    }

    @Override
    public boolean create(Status status) {
        status.updateTimeStamps();
        try (Connection c = connection()) {
            String query = "INSERT INTO statuses (status, description, created_on, updated_on) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, status.getStatus());
            ps.setString(2, status.getDescription());
            ps.setTimestamp(3, DateConverter.dateToSQL(status.getDateCreated()));
            ps.setTimestamp(4, DateConverter.dateToSQL(status.getLastUpdated()));
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Status status) {
        status.updateTimeStamps();
        try (Connection c = connection()) {
            String query = "UPDATE statuses SET status = ?, description = ?, updated_on = ? WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, status.getStatus());
            ps.setString(2, status.getDescription());
            ps.setTimestamp(3, DateConverter.dateToSQL(status.getLastUpdated()));
            ps.setInt(4, status.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Status status) {
        try (Connection c = connection()) {
            String query = "DELETE FROM statuses WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, status.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
