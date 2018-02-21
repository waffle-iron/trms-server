package app.utilities;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ConnectionUtilityTest {

    @Mock
    DriverManager dm;

    public ConnectionUtilityTest() throws SQLException {
    }

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