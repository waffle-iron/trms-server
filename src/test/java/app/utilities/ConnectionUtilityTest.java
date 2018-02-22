package app.utilities;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class ConnectionUtilityTest extends TestCase {

    @Test
    public void getConnection() throws SQLException {
        assertTrue(ConnectionUtility.getInstance().getConnection() instanceof Connection);
        assertTrue(ConnectionUtility.getInstance().getConnection() instanceof Connection);
    }

    @Test
    public void canDropTable() {
        ConnectionUtility.getInstance().dropTables();
    }

    @Test
    public void canCreateTables() {
        ConnectionUtility.getInstance().dropTables();
        assertTrue(ConnectionUtility.getInstance().createTables());
    }
}