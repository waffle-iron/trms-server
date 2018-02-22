package app.dao;

import java.sql.ResultSet;

public interface Crud<T> {
    T fetch();
    T fetchAll();
    T create();
    T update();
    T delete();
    T buildObject(T t, ResultSet resultSet);
}
