package app.utilities;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class ConnectionUtilityTest {

    @Test
    public void getConnection() throws SQLException {
        assertTrue(ConnectionUtility.getInstance().getConnection(false) instanceof Connection);
        assertTrue(ConnectionUtility.getInstance().getConnection(true) instanceof Connection);
    }

    @Test
    public void canDropTable() {
        ConnectionUtility.getInstance().dropTables(true);
    }

    @Test
    public void canCreateTables() {
        ConnectionUtility.getInstance().dropTables(true);
        assertTrue(ConnectionUtility.getInstance().createTables(true));
    }
}