import static org.junit.Assert.*;

import javax.swing.text.AbstractDocument.Content;

import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
        
    }

    @Test
    public void testSepUp() throws IOException {
        
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
    
        assertEquals(List.of("https://something.com", "some-thing.html"), links);
    }
}
