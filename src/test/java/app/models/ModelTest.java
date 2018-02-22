package app.models;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ModelTest {

    private TestClass tc;
    Date date = new Date();

    @Before
    public void setUp() {
        tc = new TestClass();
    }

    @Test
    public void setId() {
        tc.setId(1L);
        assertEquals(Long.valueOf(1), tc.getId());
    }

    @Test
    public void setDateCreated() {
        tc.setDateCreated(date);
        assertEquals(date, tc.getDateCreated());
    }

    @Test
    public void setLastUpdated() {
        tc.setLastUpdated(date);
        assertEquals(date, tc.getLastUpdated());
    }

    @Test
    public void updateTimeStamps() throws InterruptedException {
        tc.setDateCreated(date);
        tc.setLastUpdated(date);
        Thread.sleep(1500);
        tc.updateTimeStamps();
        assertNotEquals(tc.getDateCreated(), tc.getLastUpdated());

    }

    private class TestClass extends Model {
    }
}