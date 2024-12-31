package es.ulpgc.is2;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        TsvTitleReader reader = new TsvTitleReader(new File("C:\\Users\\Santi\\Downloads\\title.basics.tsv"));
        List<Title> titles = reader.read();
        HashMap<Title.TitleType, Integer> histogram = new HashMap<>();
        for (Title title : titles) {
            histogram.put(title.titleType(), histogram.getOrDefault(title.titleType(), 0) + 1);
        }
        for (Title.TitleType titleType : histogram.keySet()) {
            System.out.println(titleType + " " + histogram.get(titleType));
        }
    }
}
