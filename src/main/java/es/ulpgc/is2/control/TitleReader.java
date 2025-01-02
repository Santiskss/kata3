package es.ulpgc.is2.control;

import es.ulpgc.is2.model.Title;

import java.io.IOException;
import java.util.List;

public interface TitleReader {
    List<Title> read() throws IOException;
}
