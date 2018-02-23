package app.dao;

import app.models.User;
import app.utilities.DateConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends Crud<User> {

    @Override
    public User fetch(int id) {
        User user = new User();
        try (Connection c = connection()) {
            String query = "SELECT * FROM users WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setJobTitle(rs.getString("job_title"));
                user.setEmail(rs.getString("email"));
                user.setRoleId(rs.getInt("role_id"));
                user.setPassword(rs.getString("password"));
                user.setDirectSupervisorId(rs.getInt("direct_supervisor_password"));
                user.setDepartmentHeadId(rs.getInt("department_head_id"));
                user.setDateCreated(DateConverter.dateToLocalDateTime(rs.getTimestamp("created_on")));
                user.setLastUpdated(DateConverter.dateToLocalDateTime(rs.getTimestamp("updated_on")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public List<User> fetchAll(int limit, int offset) {
        List<User> users = new ArrayList<>();
        try (Connection c = connection()) {
            String query = "SELECT * FROM users LIMIT ? OFFSET ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, limit);
            ps.setInt(2, offset);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setJobTitle(rs.getString("job_title"));
                user.setEmail(rs.getString("email"));
                user.setRoleId(rs.getInt("role_id"));
                user.setPassword(rs.getString("password"));
                user.setDirectSupervisorId(rs.getInt("direct_supervisor_id"));
                user.setDepartmentHeadId(rs.getInt("department_head_id"));
                user.setDateCreated(DateConverter.dateToLocalDateTime(rs.getTimestamp("created_on")));
                user.setLastUpdated(DateConverter.dateToLocalDateTime(rs.getTimestamp("updated_on")));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }


    @Override
    public boolean create(User user) {
        String query = "INSERT INTO users (" +
                "first_name, " +
                "last_name, " +
                "job_title, " +
                "email, " +
                "role_id, " +
                "password, " +
                "direct_supervisor_id, " +
                "department_head_id, " +
                "created_on, " +
                "updated_on" +
                ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        user.updateTimeStamps();
        try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getJobTitle());
            ps.setString(4, user.getEmail());
            ps.setInt(5, user.getRoleId());
            ps.setString(6, user.getPassword());
            ps.setInt(7, user.getDirectSupervisorId());
            ps.setInt(8, user.getDepartmentHeadId());
            ps.setTimestamp(9, DateConverter.dateToSQL(user.getDateCreated()));
            ps.setTimestamp(10, DateConverter.dateToSQL(user.getLastUpdated()));
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean update(User user) {
        user.updateTimeStamps();
        try (Connection c = connection()) {
            String query = "UPDATE users SET " +
                    "first_name = ?, " +
                    "last_name = ?, " +
                    "job_title = ?, " +
                    "email = ?, " +
                    "role_id = ?, " +
                    "password = ?, " +
                    "direct_supervisor_id = ?, " +
                    "department_head_id = ?, " +
                    "updated_on = ? WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getJobTitle());
            ps.setString(4, user.getEmail());
            ps.setInt(5, user.getRoleId());
            ps.setString(6, user.getPassword());
            ps.setInt(7, user.getDirectSupervisorId());
            ps.setInt(8, user.getDepartmentHeadId());
            ps.setTimestamp(9, DateConverter.dateToSQL(user.getLastUpdated()));
            ps.setInt(10, user.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(User user) {
        try (Connection c = connection()) {
            String query = "DELETE FROM users WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, user.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
