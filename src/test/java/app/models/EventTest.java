package app.models;

import app.seeds.SeedFactory;
import app.utilities.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class EventTest extends TestCase {

    private Event event;

    @Before
    public void setUp() {
        event = SeedFactory.createEvent();
    }

    @Test
    public void constructor() {
        byte[] bytes = {};
        LocalDateTime date = LocalDateTime.now();
        Event e = SeedFactory.createEvent();
        assertEquals(1, event.getId());
        assertEquals(date, event.getDateCreated());
        assertEquals(date, event.getLastUpdated());
        assertEquals(1, event.getEventTypeId());
        assertEquals(date, event.getDatetime());
        assertEquals("location", event.getLocation());
        assertEquals("description", event.getDescription());
        assertEquals("justification", event.getJustification());
        assertEquals(new BigDecimal(1000), event.getCost());
        assertTrue(event.getGradingFormatId() > 0);
        assertEquals("passing grade cutoff", event.getPassingGradeCutoff());
        assertEquals(date, event.getCompletedOn());
        assertTrue(event.getStatusId() > 0);
        assertEquals(bytes, event.getAttachment());
    }

    @Test
    public void constructor1() {
        byte[] bytes = {};
        LocalDateTime date = LocalDateTime.now();
        Event event = SeedFactory.createEvent();
        assertEquals(0, event.getId());
        assertEquals(null, event.getDateCreated());
        assertEquals(null, event.getLastUpdated());
        assertEquals(1, event.getEventTypeId());
        assertEquals(date, event.getDatetime());
        assertEquals("location", event.getLocation());
        assertEquals("description", event.getDescription());
        assertEquals("justification", event.getJustification());
        assertEquals(1000, event.getCost());
        assertTrue(event.getGradingFormatId() > 0);
        assertEquals("passing grade cutoff", event.getPassingGradeCutoff());
        assertEquals(date, event.getCompletedOn());
        assertTrue(event.getStatusId() > 0);
        assertEquals(bytes, event.getAttachment());
    }

    @Test
    public void eventTypeId() {
        event.setEventTypeId(100);
        assertEquals(100, event.getEventTypeId() > 0);
    }

    @Test
    public void dateTime() {
        LocalDateTime date = LocalDateTime.now();
        event.setDatetime(date);
        assertEquals(date, event.getDatetime());
    }

    @Test
    public void location() {
        event.setLocation("downtown");
        assertEquals("downtown", event.getLocation());
    }

    @Test
    public void description() {
        event.setDescription("description");
        assertEquals("description", event.getDescription());
    }

    @Test
    public void justification() {
        event.setJustification("justification");
        assertEquals("justification", event.getJustification());
    }

    @Test
    public void cost() {
        event.setCost(100);
        assertEquals(100, event.getCost());
    }

    @Test
    public void gradingFormat() {
        event.setGradingFormatId(100);
        assertEquals(100, event.getGradingFormatId());
    }

    @Test
    public void passingGradeCutoff() {
        event.setPassingGradeCutoff("60 or better");
        assertEquals("60 or better", event.getPassingGradeCutoff());
    }

    @Test
    public void completedOn() {
        LocalDateTime date = LocalDateTime.now();
        event.setCompletedOn(date);
        assertEquals(date, event.getCompletedOn());
    }

    @Test
    public void status() {
        event.setStatusId(100);
        assertEquals(100, event.getStatusId());
    }

    @Test
    public void attachment() {
        byte[] bytes = {};
        event.setAttachment(bytes);
        assertEquals(bytes, event.getAttachment());
    }

    @Test
    public void toStringOverride() {
        Event event1 = new Event();
        assertTrue(event1.toString().equals(event.toString()));
    }

    @Test
    public void hashCodeOverride() {
        assertNotNull(event.hashCode());
    }
}