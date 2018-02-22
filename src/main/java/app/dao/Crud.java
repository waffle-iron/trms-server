package app.dao;

import app.utilities.ConnectionUtility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class Crud<T> {
    abstract T fetch(int id);
    abstract List<T> fetchAll(int limit, int offset);
    abstract boolean create(T t);
    abstract boolean update(T t);
    abstract boolean delete(T t);
    abstract T buildObject(T t, ResultSet resultSet) throws SQLException;

    Connection connection() {
        try {
            return ConnectionUtility.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
