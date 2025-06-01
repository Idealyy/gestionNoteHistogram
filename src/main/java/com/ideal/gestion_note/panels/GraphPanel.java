package com.ideal.gestion_note.panels;

import javax.swing.JPanel;

/**
 * @author ideal
 */
public class GraphPanel extends javax.swing.JPanel {

    private TablePanel tablePanel;

    public GraphPanel(TablePanel tablePanel) {
        this.tablePanel = tablePanel;
        initComponents();

        double[] stats = tablePanel.getMoyenneStats(); // min, moyenne, max
        JPanel histogram = HistogramChartBuilder.createHistogramPanel(stats);

        this.setLayout(new java.awt.BorderLayout());
        this.add(histogram, java.awt.BorderLayout.CENTER);
    }

    private void initComponents() {

        setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 670, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 377, Short.MAX_VALUE)
        );
    }
}
