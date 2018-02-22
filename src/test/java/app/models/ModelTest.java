package app.models;

import app.seeds.SeedFactory;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ModelTest {

    private TestClass tc;
    int date = SeedFactory.unix();

    @Before
    public void setUp() {
        tc = new TestClass();
    }

    @Test
    public void setId() {
        tc.setId(1);
        assertEquals(1, tc.getId());
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