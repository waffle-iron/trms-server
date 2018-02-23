package app.dao;

import app.models.Role;
import app.utilities.DateConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDao extends Crud<Role> {

    @Override
    public Role fetch(int id) {
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
    public List<Role> fetchAll(int limit, int offset) {
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
    public boolean create(Role role) {
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
    public boolean update(Role role) {
        role.updateTimeStamps();
        try (Connection c = connection()) {
            String query = "UPDATE roles SET name = ?, updated_on = ? WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, role.getName());
            ps.setTimestamp(2, DateConverter.dateToSQL(role.getLastUpdated()));
            ps.setInt(3, role.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Role role) {
        try (Connection c = connection()) {
            String query = "DELETE FROM roles WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, role.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
