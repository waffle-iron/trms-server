package app.dao;

import app.models.Role;

import java.sql.ResultSet;
import java.util.List;

public class RoleDao extends Crud<Role> {

    @Override
    Role fetch(int id) {
        return null;
    }

    @Override
    List<Role> fetchAll(int limit, int offset) {
        return null;
    }

    @Override
    boolean create(Role role) {
        return false;
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
    Role buildObject(Role role, ResultSet resultSet) {
        return null;
    }
}
