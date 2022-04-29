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

    @Test
    public void testFailing() throws IOException {
        
        Path fileName1 = Path.of("fail-test1.md");
        String content1 = Files.readString(fileName1);
        ArrayList<String> links1 = MarkdownParse.getLinks(content1);
    
        assertEquals(List.of("https://code.visualstudio.com/", "VScode%20download.png"), links1);
    }

    @Test
    public void testFailing2() throws IOException {
        
        Path fileName2 = Path.of("test-file-4.md");
        String content2 = Files.readString(fileName2);
        ArrayList<String> links2 = MarkdownParse.getLinks(content2);
    
        assertEquals(List.of("google.com"), links2);
    }
}
