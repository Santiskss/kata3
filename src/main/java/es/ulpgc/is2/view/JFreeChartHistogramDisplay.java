package es.ulpgc.is2.view;

import es.ulpgc.is2.model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class JFreeChartHistogramDisplay extends JPanel implements HistogramDisplay {

    public JFreeChartHistogramDisplay() {
        setLayout(new BorderLayout());
    }

    @Override
    public void display(Histogram histogram) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (String key : histogram.keys()) {
            dataset.addValue(histogram.valueOf(key), "Frecuency", key );
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                histogram.title(), "Categories", "Frecuency", dataset
        );

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        chartPanel.setMouseWheelEnabled(true);

        removeAll();
        add(chartPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
}
