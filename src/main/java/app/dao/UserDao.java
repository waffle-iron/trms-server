package app.dao;

import app.models.User;

import java.sql.ResultSet;

public class UserDao extends Crud<User> {

    @Override
    User fetch(int id) {
        return null;
    }

    @Override
    User fetchAll(int limit, int offset) {
        return null;
    }

    @Override
    User create(User user) {
        return null;
    }

    @Override
    User update(User user) {
        return null;
    }

    @Override
    User delete(User user) {
        return null;
    }

    @Override
    User buildObject(User user, ResultSet resultSet) {
        return null;
    }
}
