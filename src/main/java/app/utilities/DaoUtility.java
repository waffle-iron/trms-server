package app.utilities;

import app.dao.UserDao;

public class DaoUtility {

    public static UserDao getUserDao() {
        return new UserDao();
    }
}
