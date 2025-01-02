package es.ulpgc.is2.control;

import es.ulpgc.is2.model.Title;

public interface TitleDeserializer {
    Title deserialize(String content);
}
