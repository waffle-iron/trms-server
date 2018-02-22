package app.dao;

import app.models.Role;

import java.sql.*;
import java.util.List;

public class RoleDao extends Crud<Role> {

    private final String fetchQuery = "SELECT * FROM roles WHERE id = ?";
    private final String createQuery = "INSERT INTO roles (name, created_on) VALUES(?, to_timestamp(?))";

    @Override
    Role fetch(int id) {
        Role role = new Role();

        try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement(fetchQuery);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return buildObject(role, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    List<Role> fetchAll(int limit, int offset) {
        return null;
    }

    @Override
    boolean create(Role role) {
        role.updateTimeStamps();
        try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement(createQuery);
            ps.setString(1, role.getName());
            ps.setInt(2, role.getDateCreated());
            return ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    boolean update(Role role) {
        return false;
    }

    @Override
    boolean delete(Role role) {
        return false;
    }

    @Override
    Role buildObject(Role role, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            try {
                role.setId(resultSet.getInt("id"));
                role.setName(resultSet.getString("name"));
                role.setDateCreated(resultSet.getInt("created_on"));
                role.setLastUpdated(resultSet.getInt("updated_on"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return role;
    }
}
