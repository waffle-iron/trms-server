package app.dao;

import app.models.GradingFormat;
import app.utilities.DateConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradingFormatDao extends Crud<GradingFormat> {

    @Override
    GradingFormat fetch(int id) {
        GradingFormat gradingFormat = new GradingFormat();
        try (Connection c = connection()) {
            String query = "SELECT * FROM grading_formats WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                gradingFormat.setFormat(rs.getString("format"));
                gradingFormat.setDescription(rs.getString("description"));
                gradingFormat.setDateCreated(DateConverter.dateToLocalDateTime(rs.getTimestamp("created_on")));
                gradingFormat.setLastUpdated(DateConverter.dateToLocalDateTime(rs.getTimestamp("updated_on")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gradingFormat;
    }

    @Override
    List<GradingFormat> fetchAll(int limit, int offset) {
        List<GradingFormat> gradingFormats = new ArrayList<>();
        try(Connection c = connection()) {
            String query = "SELECT * FROM grading_formats LIMIT ? OFFSET ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, limit);
            ps.setInt(2, offset);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                GradingFormat gradingFormat = new GradingFormat();
                gradingFormat.setFormat(rs.getString("format"));
                gradingFormat.setDescription(rs.getString("description"));
                gradingFormat.setDateCreated(DateConverter.dateToLocalDateTime(rs.getTimestamp("created_on")));
                gradingFormat.setLastUpdated(DateConverter.dateToLocalDateTime(rs.getTimestamp("updated_on")));
                gradingFormats.add(gradingFormat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gradingFormats;
    }

    @Override
    boolean create(GradingFormat gradingFormat) {
        gradingFormat.updateTimeStamps();
        try (Connection c = connection()) {
            String query = "INSERT INTO grading_formats (" +
                    "format, " +
                    "description, " +
                    "created_on, " +
                    "updated_on" +
                    ") VALUES (?, ?, ?, ?)";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, gradingFormat.getFormat());
            ps.setString(2, gradingFormat.getDescription());
            ps.setTimestamp(3, DateConverter.dateToSQL(gradingFormat.getDateCreated()));
            ps.setTimestamp(4, DateConverter.dateToSQL(gradingFormat.getLastUpdated()));
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    boolean update(GradingFormat gradingFormat) {
        gradingFormat.updateTimeStamps();
        try(Connection c = connection()) {
            String query = "UPDATE grading_formats SET " +
                    "format = ?, " +
                    "description = ?, " +
                    "updated_on = ? WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, gradingFormat.getFormat());
            ps.setString(2, gradingFormat.getDescription());
            ps.setTimestamp(3, DateConverter.dateToSQL(gradingFormat.getLastUpdated()));
            ps.setInt(4, gradingFormat.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    boolean delete(GradingFormat gradingFormat) {
        try (Connection c = connection()) {
            String query = "DELETE FROM grading_formats WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, gradingFormat.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
