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
        event = new Event();
    }

    @Test
    public void constructor() {
        byte[] bytes = {};
        LocalDateTime date = LocalDateTime.now();
        Event event = new Event(
                1,
                date,
                date,
                new EventType(),
                date,
                "location",
                "description",
                "justification",
                new BigDecimal(1000),
                new GradingFormat(),
                "passing grade cutoff",
                date,
                "status",
                bytes
        );
        assertEquals(1, event.getId());
        assertEquals(date, event.getDateCreated());
        assertEquals(date, event.getLastUpdated());
        assertTrue(event.getEventType() instanceof EventType);
        assertEquals(date, event.getDatetime());
        assertEquals("location", event.getLocation());
        assertEquals("description", event.getDescription());
        assertEquals("justification", event.getJustification());
        assertEquals(new BigDecimal(1000), event.getCost());
        assertTrue(event.getGradingFormat() instanceof GradingFormat);
        assertEquals("passing grade cutoff", event.getPassingGradeCutoff());
        assertEquals(date, event.getCompletedOn());
        assertEquals("status", event.getStatus());
        assertEquals(bytes, event.getAttachment());
    }

    @Test
    public void constructor1() {
        byte[] bytes = {};
        LocalDateTime date = LocalDateTime.now();
        Event event = new Event(
                new EventType(),
                date,
                "location",
                "description",
                "justification",
                new BigDecimal(1000),
                new GradingFormat(),
                "passing grade cutoff",
                date,
                "status",
                bytes
        );
        assertEquals(0, event.getId());
        assertEquals(null, event.getDateCreated());
        assertEquals(null, event.getLastUpdated());
        assertTrue(event.getEventType() instanceof EventType);
        assertEquals(date, event.getDatetime());
        assertEquals("location", event.getLocation());
        assertEquals("description", event.getDescription());
        assertEquals("justification", event.getJustification());
        assertEquals(new BigDecimal(1000), event.getCost());
        assertTrue(event.getGradingFormat() instanceof GradingFormat);
        assertEquals("passing grade cutoff", event.getPassingGradeCutoff());
        assertEquals(date, event.getCompletedOn());
        assertEquals("status", event.getStatus());
        assertEquals(bytes, event.getAttachment());
    }

    @Test
    public void eventTypeId() {
        EventType eventType = new EventType();
        event.setEventType(eventType);
        assertEquals(eventType, event.getEventType());
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
        event.setCost(BigDecimal.valueOf(100.00));
        assertEquals(BigDecimal.valueOf(100.00), event.getCost());
    }

    @Test
    public void gradingFormat() {
        GradingFormat gradingFormat = new GradingFormat();
        event.setGradingFormat(gradingFormat);
        assertTrue(event.getGradingFormat() instanceof GradingFormat);
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
        event.setStatus("active");
        assertEquals("active", event.getStatus());
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