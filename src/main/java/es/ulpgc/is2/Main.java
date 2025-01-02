package es.ulpgc.is2;

import es.ulpgc.is2.control.TitleTypeHistogram;
import es.ulpgc.is2.control.TsvTitleReader;
import es.ulpgc.is2.model.Histogram;
import es.ulpgc.is2.model.Title;
import es.ulpgc.is2.view.MainFrame;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        TsvTitleReader reader = new TsvTitleReader(new File("C:\\Users\\Santi\\Downloads\\title.basics.tsv"));
        Histogram histogram = new TitleTypeHistogram(reader.read());
        MainFrame mainFrame = new MainFrame();
        mainFrame.displayHistogram(histogram);
        mainFrame.setVisible(true);
    }
}
