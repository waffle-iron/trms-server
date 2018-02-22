package app.dao;

import app.models.User;

import java.sql.ResultSet;
import java.util.List;

public class UserDao extends Crud<User> {

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
        return false;
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
