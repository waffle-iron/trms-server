package app.dao;

public interface Crud<T> {
    T fetch();
    T fetchAll();
    T create();
    T update();
    T delete();
    T buildObject();
}
