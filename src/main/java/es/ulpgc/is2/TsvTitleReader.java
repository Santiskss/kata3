package es.ulpgc.is2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TsvTitleReader implements TitleReader{

    private final File source;
    private final TsvTitleDeserializer deserializer;

    public TsvTitleReader(File source) {
        this.source = source;
        deserializer = new TsvTitleDeserializer();
    }

    @Override
    public List<Title> read() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(source));
        readHeaderWith(reader);
        return readTitlesWith(reader);
    }

    private List<Title> readTitlesWith(BufferedReader reader) throws IOException {
        List<Title> titles = new ArrayList<>();
        while (true){
            String str = reader.readLine();
            if (str == null) break;
            titles.add(titleOf(str));
        }
        return titles;
    }

    private Title titleOf(String str) {
        return deserializer.deserialize(str);
    }

    private static void readHeaderWith(BufferedReader reader) throws IOException {
        reader.readLine();
    }
}
