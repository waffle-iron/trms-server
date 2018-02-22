package app.utilities;

import app.config.Config;
import org.junit.Before;
import org.junit.After;

public class TestCase {

    @Before
    public void setUp() {
        Config.ENVIRONMENT = "Testing";
        createTables();
    }

    @After
    public void tearDown() {
        dropTables();
        Config.ENVIRONMENT = "Development";
    }

    protected boolean createTables() {
        return ConnectionUtility.getInstance().createTables();
    }

    protected boolean dropTables() {
        return ConnectionUtility.getInstance().dropTables();
    }
}
