package projekt;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * Klasa zawierająca wykres funkcji
 * @author Heniek
 */
public class Wykres extends JFrame {
    static double x0=-20.0;
    static double x1=20.0;
    
    /**
     * Metoda typu jPanel tworząca dane do wykresu funkcji
     */
    private static JPanel createChartPanel() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series1 = new XYSeries("Object 1");
        XYSeries series2 = new XYSeries("Object 2");
        
        if(Metoda.funkcja==0){
        for(double i=x0;i<=x1;i=i+0.1)
            series1.add(i, Wielomian.wartosc(Wielomian.wspol, Wielomian.stopien, i));
        }
        else{
            for(double i=x0;i<=x1;i=i+0.1)
            series1.add(i, Exp.wartosc(Exp.a, Exp.b, Exp.c, i));
        }
        
        series2.add(x0, 0.0);
        series2.add(x1, 0.0);

        dataset.addSeries(series1);
        dataset.addSeries(series2);

        JFreeChart chart = ChartFactory.createXYLineChart("","x", "y", dataset, PlotOrientation.VERTICAL,false,false,false);
        return new ChartPanel(chart);
}

    /**
     * Metoda rysująca wykres funkcji
     */
    public static void run() {
       Wykres wykres=new Wykres();
       JPanel chartPanel = createChartPanel();
       wykres.add(chartPanel, BorderLayout.CENTER);
       wykres.setSize(640, 480);
       wykres.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
       wykres.setLocationRelativeTo(null);
       wykres.setVisible(true);
    }

    /**
     * Metoda pobierająca wpisany zakres wykresu
     */
    public static void pobierzZakres(){
        String[] z=new String[2];
        if(Metoda.funkcja==0)
            z=(Menu.ZakresW.getText()).split(";");
        else
            z=(Menu.ZakresE.getText()).split(";");
        x0=Double.parseDouble(z[0]);
        x1=Double.parseDouble(z[1]);
    }
}
