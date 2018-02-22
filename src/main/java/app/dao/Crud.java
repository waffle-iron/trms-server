package app.dao;

import app.utilities.ConnectionUtility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Crud<T> {
    abstract T fetch(int id);
    abstract T fetchAll(int limit, int offset);
    abstract T create(T t);
    abstract T update(T t);
    abstract T delete(T t);
    abstract T buildObject(T t, ResultSet resultSet);

    Connection connection() {
        try {
            return ConnectionUtility.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
