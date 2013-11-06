package filmstudio.utilities;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FileReaderTest {

    FileReader fileReader;

    @Before
    public void setUp() {
        fileReader = new FileReader();
    }

    @Test (expected = Exception.class)
    public void fileNotFoundThrowsException() throws Exception {
        List<String> lines = fileReader.readFile("test/filmstudio/utilities/notfound.txt");
    }

    @Test
    public void linesReadMatchTheContent() throws Exception {
        List<String> lines = fileReader.readFile("test/filmstudio/utilities/test.txt");

        assertEquals("first", lines.get(0));
        assertEquals("second", lines.get(1));
        assertEquals("third", lines.get(2));
    }
}
