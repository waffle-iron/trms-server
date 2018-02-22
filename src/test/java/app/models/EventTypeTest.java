package app.models;

import app.utilities.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EventTypeTest extends TestCase {

    private EventType eventType;

    @Before
    public void setUp() {
        eventType = new EventType();
    }

    @Test
    public void name() {
        eventType.setName("Seminar");
        assertEquals("Seminar", eventType.getName());
    }

    @Test
    public void percentage() {
        eventType.setPercentage(100);
        assertEquals(100, eventType.getPercentage());
    }

    @Test
    public void toStringOverride() {
        EventType eventType1 = new EventType();
        assertTrue(eventType.toString().equals(eventType1.toString()));
    }

    @Test
    public void hashCodeOverride() {
        assertNotNull(eventType.hashCode());
    }
}