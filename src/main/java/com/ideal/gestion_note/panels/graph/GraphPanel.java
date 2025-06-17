package com.ideal.gestion_note.panels.graph;

import com.ideal.gestion_note.interfaces.Updatable;
import com.ideal.gestion_note.services.ResumeService;
import javax.swing.JPanel;

/**
 * @author ideal
 */
public class GraphPanel extends javax.swing.JPanel implements Updatable {

    private JPanel histogram;

    public GraphPanel() {
        initComponents();
        initHistogram();
    }

    private void initComponents() {
        setBackground(new java.awt.Color(204, 255, 204));
        setLayout(new java.awt.BorderLayout());
    }

    private void initHistogram() {
        refreshHistogram();
    }

    private void refreshHistogram() {
        if (histogram != null) {
            this.remove(histogram);
        }
        histogram = HistogramChartBuilder.createHistogramPanel(ResumeService.getResume());
        this.add(histogram, java.awt.BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    @Override
    public void update() {
        refreshHistogram();
    }
}