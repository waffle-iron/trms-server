package app.dao;

import app.models.User;
import app.seeds.SeedFactory;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class UserDao extends Crud<User> {

    private final String createQuery = "INSERT INTO users (" +
            "first_name, " +
            "last_name, " +
            "job_title, " +
            "email, " +
            "role_id, " +
            "password, " +
            "created_on " +
            ") VALUES (?, ?, ?, ?, ?, ?, to_timestamp(?))";

    @Override
    User fetch(int id) {
        return null;
    }

    @Override
    List<User> fetchAll(int limit, int offset) {
        return null;
    }

    @Override
    boolean create(User user) {
        try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement(createQuery);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getJobTitle());
            ps.setString(4, user.getEmail());
            ps.setLong(5, user.getRole().getId());
            ps.setString(6, user.getPassword());
            ps.setInt(7, SeedFactory.unix());
            return ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("failing");
            return false;
        }
    }

    @Override
    boolean update(User user) {
        return false;
    }

    @Override
    boolean delete(User user) {
        return false;
    }

    @Override
    User buildObject(User user, ResultSet resultSet) {
        return null;
    }
}
