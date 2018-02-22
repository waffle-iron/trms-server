package app.models;

import app.utilities.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class GradingFormatTest extends TestCase {

    private GradingFormat gradingFormat;

    @Before
    public void setUp() {
        gradingFormat = new GradingFormat();
    }

    @Test
    public void constructor() {
        Date date = new Date();
        GradingFormat gf = new GradingFormat(
                1L,
                date,
                date,
                "format",
                "description"
        );
        assertEquals(Long.valueOf(1), gf.getId());
        assertEquals(date, gf.getDateCreated());
        assertEquals(date, gf.getLastUpdated());
        assertEquals("format", gf.getFormat());
        assertEquals("description", gf.getDescription());
    }

    @Test
    public void format() {
        gradingFormat.setFormat("gpa");
        assertEquals("gpa", gradingFormat.getFormat());
    }

    @Test
    public void description() {
        gradingFormat.setDescription("get a good grade");
        assertEquals("get a good grade", gradingFormat.getDescription());
    }

    @Test
    public void toStringOverride() {
        GradingFormat gradingFormat1 = new GradingFormat();
        assertTrue(gradingFormat1.toString().equals(gradingFormat.toString()));
    }

    @Test
    public void equalsOverride() {
        GradingFormat gradingFormat1 = new GradingFormat();
        assertTrue(gradingFormat1.equals(gradingFormat));
        assertTrue(gradingFormat.equals(gradingFormat1));
    }

    @Test
    public void hashCodeOverride() {
        assertNotNull(gradingFormat.hashCode());
    }
}