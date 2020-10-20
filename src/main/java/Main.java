import epam.receiver.ReaderAndFounder;

import java.io.File;
import java.io.Reader;

public class Main {
    public static void main(String[] args) {
        File f = new File("File.txt");
        ReaderAndFounder founder = new ReaderAndFounder();
        System.out.println(founder.wordsReader(f));

    }
}
