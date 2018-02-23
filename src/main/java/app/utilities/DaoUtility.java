package app.utilities;

import app.dao.ReimbursementDao;
import app.dao.RoleDao;
import app.dao.UserDao;

public class DaoUtility {

    public static UserDao getUserDao() {
        return new UserDao();
    }

    public static RoleDao getRoleDao() {
        return new RoleDao();
    }

    public static ReimbursementDao getReimbursementDao() {
        return new ReimbursementDao();
    }
}
