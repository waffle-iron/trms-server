package app.dao;

import app.models.Role;
import app.utilities.DateConverter;
import sun.util.calendar.LocalGregorianCalendar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDao extends Crud<Role> {

    @Override
    Role fetch(int id) {
        Role role = new Role();
        try (Connection c = connection()) {
            String query = "SELECT * FROM roles WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                role.setId(rs.getInt("id"));
                role.setName(rs.getString("name"));
                role.setDateCreated(DateConverter.dateToLocalDateTime(rs.getTimestamp("created_on")));
                if (rs.getTimestamp("updated_on") == null) {
                    role.setLastUpdated(null);
                } else {
                    role.setLastUpdated(DateConverter.dateToLocalDateTime(rs.getTimestamp("updated_on")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    List<Role> fetchAll(int limit, int offset) {
        List<Role> roles = new ArrayList<>();
        try (Connection c = connection()) {
            String query = "SELECT * FROM roles LIMIT ? OFFSET ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, limit);
            ps.setInt(2, offset);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getInt("id"));
                role.setName(rs.getString("name"));
                role.setDateCreated(DateConverter.dateToLocalDateTime(rs.getTimestamp("created_on")));
                role.setLastUpdated(DateConverter.dateToLocalDateTime(rs.getTimestamp("updated_on")));
                roles.add(role);
            }
        } catch (SQLException e)

        {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    boolean create(Role role) {
        role.updateTimeStamps();
        try (Connection c = connection()) {
            String query = "INSERT INTO roles (name, created_on) VALUES(?, ?)";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, role.getName());
            ps.setTimestamp(2, DateConverter.dateToSQL(role.getDateCreated()));
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    boolean update(Role role) {
        return false;
    }

    @Override
    boolean delete(Role role) {
        return false;
    }
}
