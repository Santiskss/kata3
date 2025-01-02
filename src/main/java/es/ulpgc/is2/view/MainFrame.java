package es.ulpgc.is2.view;

import es.ulpgc.is2.model.Histogram;

import javax.swing.*;

public class MainFrame extends JFrame {
    JFreeChartHistogramDisplay display;

    public MainFrame() {
        this.setTitle("Histogram Display");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.display = new JFreeChartHistogramDisplay();
        add(display);
    }

    public void displayHistogram(Histogram histogram) {
        display.display(histogram);
    }
}
