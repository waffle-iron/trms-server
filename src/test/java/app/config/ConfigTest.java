package app.config;

import app.utilities.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConfigTest extends TestCase {

    @Test
    public void config() {
        assertTrue(Config.env() instanceof Config);
    }

    @Test
    public void db() {
        assertTrue(Config.env().getDb() != null);
    }

    @Test
    public void username() {
        assertTrue(Config.env().getUsername() != null);
    }

    @Test
    public void password() {
        assertTrue(Config.env().getPassword() != null);
    }

    @Test
    public void testDb() {
        assertTrue(Config.env().getTestDb() != null);
    }

    @Test
    public void testDbUsername() {
        assertTrue(Config.env().getTestdbusername() != null);
    }

    @Test
    public void testDbPassword() {
        assertTrue(Config.env().getTestdbpassword() != null);
    }

}