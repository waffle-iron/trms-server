package app.dao;

import app.models.User;
import app.utilities.DaoUtility;
import app.utilities.DateConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends Crud<User> {

    @Override
    User fetch(int id) {
        User user = new User();
        int roleId = 0;
        int directSupervisorId;
        int departmentHeadId;
        try (Connection c = connection()) {
            String query = "SELECT * FROM users WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                roleId = rs.getInt("role_id");
                directSupervisorId = rs.getInt("direct_supervisor_id");
                departmentHeadId = rs.getInt("department_head_id");
                user.setId(rs.getInt("id"));
                user.setDateCreated(DateConverter.dateToLocalDateTime(rs.getTimestamp("created_on")));
                user.setLastUpdated(DateConverter.dateToLocalDateTime(rs.getTimestamp("updated_on")));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setJobTitle(rs.getString("job_title"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        user.setRole(DaoUtility.getRoleDao().fetch(roleId));

        return user;
    }

    @Override
    List<User> fetchAll(int limit, int offset) {
        List<User> users = new ArrayList<>();
        List<Integer> roleIds = new ArrayList<>();
        List<Integer> directSupervisorIds = new ArrayList<>();
        List<Integer> departmentHeadIds = new ArrayList<>();
        try (Connection c = connection()) {
            String query = "SELECT * FROM users LIMIT ? OFFSET ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, limit);
            ps.setInt(2, offset);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setDateCreated(DateConverter.dateToLocalDateTime(rs.getTimestamp("created_on")));
                user.setLastUpdated(DateConverter.dateToLocalDateTime(rs.getTimestamp("updated_on")));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setJobTitle(rs.getString("job_title"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                roleIds.add(rs.getInt("role_id"));
                directSupervisorIds.add(rs.getInt("direct_supervisor_id"));
                departmentHeadIds.add(rs.getInt("department_head_id"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // loops through users, fetch role by id, assign role to user
        // loops through users, fetch supervisor and head by id, assign users to user

        return users;
    }


    @Override
    boolean create(User user) {
        String query = "INSERT INTO users (" +
                "first_name, " +
                "last_name, " +
                "job_title, " +
                "email, " +
                "role_id, " +
                "password, " +
                "created_on, " +
                "updated_on" +
                ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        user.updateTimeStamps();
        try (Connection c = connection()) {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getJobTitle());
            ps.setString(4, user.getEmail());
            ps.setLong(5, user.getRole().getId());
            ps.setString(6, user.getPassword());
            ps.setTimestamp(7, DateConverter.dateToSQL(user.getDateCreated()));
            ps.setTimestamp(8, DateConverter.dateToSQL(user.getLastUpdated()));
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    boolean update(User user) {
        user.updateTimeStamps();
        return false;
    }

    @Override
    boolean delete(User user) {
        return false;
    }

}
