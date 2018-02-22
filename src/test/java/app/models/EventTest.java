package app.models;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.*;

public class EventTest {

    private Event event;

    @Before
    public void setUp() {
        event = new Event();
    }

    @Test
    public void id() {
        event.setId(1L);
        assertEquals(Optional.of(1L), event.getId());
    }

    @Test
    public void eventTypeId() {
        EventType eventType = new EventType();
        event.setEventType(eventType);
        assertEquals(eventType, event.getEventType());
    }

    @Test
    public void dateTime() {
        LocalDate date = LocalDate.now();
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
        LocalDate date = LocalDate.now();
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