package com.ideal.gestion_note.panels.graph;

import com.ideal.gestion_note.model.MoyenneResume;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.renderer.category.BarRenderer;
import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class HistogramChartBuilder {

    public static JPanel createHistogramPanel(MoyenneResume resume) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(BigDecimal.valueOf(resume.getMoyenneClasse()).setScale(2, RoundingMode.HALF_UP), "Moyenne", "Classe");
        dataset.addValue(resume.getMoyenneMin(), "Moyenne", "Minimale");
        dataset.addValue(resume.getMoyenneMax(), "Moyenne", "Maximale");

        JFreeChart chart = ChartFactory.createBarChart(
                "Statistiques des moyennes",
                "Type",
                "Valeur",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false
        );
        BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
    renderer.setMaximumBarWidth(0.15);

        return new ChartPanel(chart);
    }
}
