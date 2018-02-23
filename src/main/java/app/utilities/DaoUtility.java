package app.utilities;

import app.dao.*;

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

    public static EventDao getEventDao() {
        return new EventDao();
    }

    public static EventTypeDao getEventTypeDao() {
        return new EventTypeDao();
    }

    public static GradingFormatDao getGradingFormatDao() {
        return new GradingFormatDao();
    }

    public static StatusDao getStatusDao() {
        return new StatusDao();
    }
}
