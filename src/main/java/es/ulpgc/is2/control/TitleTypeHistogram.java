package es.ulpgc.is2.control;

import es.ulpgc.is2.model.Histogram;
import es.ulpgc.is2.model.Title;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TitleTypeHistogram implements Histogram {

    private final Map<Title.TitleType, Integer> histogram;

    public TitleTypeHistogram(List<Title> titles) {
        histogram = createHistogram(titles);
    }

    private Map<Title.TitleType, Integer> createHistogram(List<Title> titles) {
        Map<Title.TitleType, Integer> histogram = new HashMap<>();
        titles.forEach(t -> {
            histogram.putIfAbsent(t.titleType(), 0);
            histogram.computeIfPresent(t.titleType(), (tt, i) -> i + 1);
        });
        return histogram;
    }


    @Override
    public String title() {
        return "Title types distribution";
    }

    @Override
    public List<String> keys() {
        List<String> keys = new ArrayList<>();
        for (Title.TitleType titleType : histogram.keySet()) {
            keys.add(titleType.name());
        }
        return keys;
    }

    @Override
    public int valueOf(String key) {
        Title.TitleType titleType = Title.TitleType.valueOf(key);
        return histogram.get(titleType);
    }
}
