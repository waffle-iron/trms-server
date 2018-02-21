package app.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GradingFormatTest {

    private GradingFormat gradingFormat;

    @Before
    public void setUp() {
        gradingFormat = new GradingFormat();
    }

    @Test
    public void id() {
        gradingFormat.setId(1);
        assertEquals(1, gradingFormat.getId());
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