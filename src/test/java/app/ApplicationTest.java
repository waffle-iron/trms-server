package app;

import app.utilities.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ApplicationTest extends TestCase {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void main() {
        String[] args = {"arg"};
        Application.main(args);
        assertEquals("Hello and goodbye...\n", outContent.toString());
    }
}