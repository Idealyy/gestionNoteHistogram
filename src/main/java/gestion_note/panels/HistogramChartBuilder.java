package gestion_note.panels;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.renderer.category.BarRenderer;
import javax.swing.*;

public class HistogramChartBuilder {

    public static JPanel createHistogramPanel(double[] data) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // data[0] = min, data[1] = moyenne, data[2] = max
        dataset.addValue(data[0], "Moyennes", "Minimale");
        dataset.addValue(data[2], "Moyennes", "Maximale");

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
