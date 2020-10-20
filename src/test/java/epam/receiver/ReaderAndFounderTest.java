package epam.receiver;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ReaderAndFounderTest {
    File file = new File("File.txt");
    @Test
    public void wordsReader(){
        Map<String, Long> providedMap = Map.of("java",5l, "Java", 4l,"python",3l );
        Map<String, Long> receivedMap = ReaderAndFounder.wordsReader(file);

        Assert.assertNotNull("Provided Map is null;", providedMap);
        Assert.assertNotNull("Received Map is null;", receivedMap);
        Assert.assertEquals("Size mismatch for maps;", providedMap.size(), receivedMap.size());
        Assert.assertTrue("Missing keys in received map;", receivedMap.keySet().containsAll(providedMap.keySet()));

        providedMap.keySet().stream().forEach((key) -> {
            Assert.assertEquals("Value mismatch for key '" + key + "';", providedMap.get(key), receivedMap.get(key));
        });
    }

}