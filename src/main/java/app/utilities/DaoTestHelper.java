package app.utilities;

public abstract class DaoTestHelper {
    protected boolean createTables() {
        if (!dropTables()) {
            dropTables();
        }
        return ConnectionUtility.getInstance().createTables(true);
    }

    protected boolean dropTables() {
        return ConnectionUtility.getInstance().dropTables(true);
    }
}
