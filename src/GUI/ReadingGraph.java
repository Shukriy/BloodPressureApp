package GUI;

//import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import test.SampleObjects;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import ccol.*;

public class ReadingGraph {
	private static Patient patient;
	private static ArrayList<Readings> readings;
	private static int width;
	private static int height;


    public static JFXPanel initFX(Patient p, int x, int y) {
    	patient = p; 
    	readings = p.getReadings();
    	width = x;
    	height = y;
        // This method is invoked on the JavaFX thread
    	JFXPanel fxPanel = new JFXPanel();
    	Scene scene = createScene();
        fxPanel.setScene(scene);
        return fxPanel;
    }

    private static Scene createScene() {
    	System.out.println("got here");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();        
        
        xAxis.setTickLabelsVisible(false);
        //creating the chart
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
        //defining a series
        XYChart.Series systolic = new XYChart.Series();
        systolic.setName("Systolic");
        
        XYChart.Series diastolic = new XYChart.Series();
        diastolic.setName("Diastolic");
        
        lineChart.setLegendVisible(false);
        lineChart.setVerticalGridLinesVisible(false);
        //populating the series with data
        
        
        int x = 0;
        for (Readings r : readings) {
        	int sys = r.getAve().getSys();
        	int dias = r.getAve().getDias();
        	systolic.getData().add(new XYChart.Data(x, sys));
        	diastolic.getData().add(new XYChart.Data(x, dias));
        	x++;
        }      
        
        lineChart.getData().add(systolic);
        lineChart.getData().add(diastolic);
        
        
        // Set axis size

        int length = readings.size() + patient.getrRemaining();
        xAxis.setAutoRanging(false);
        xAxis.setUpperBound(length);
        xAxis.setLowerBound(0);
        
        // Add targets
        
        // **** SYSTOLIC ******
        int sys = patient.getTarget().getSys();
        
        
        XYChart.Data<Number, Number> sp1 = new XYChart.Data<Number, Number>(-1, sys);
        XYChart.Data<Number, Number> sp2 = new XYChart.Data<Number, Number>(length+1, sys);
        
        XYChart.Series sp = new XYChart.Series();
        sp.getData().add(sp1);
        sp.getData().add(sp2);
        lineChart.getData().add(sp);
               
        
        // **** DIASTOLIC ******
        int dias = patient.getTarget().getDias();
        
        XYChart.Data<Number, Number> dp1 = new XYChart.Data<Number, Number>(-1, dias);
        XYChart.Data<Number, Number> dp2 = new XYChart.Data<Number, Number>(length+1, dias);
        
        XYChart.Series dp = new XYChart.Series();
        dp.getData().add(dp1);
        dp.getData().add(dp2);
        lineChart.getData().add(dp);
        
        
        
        Scene scene  = new Scene(lineChart,width,height);
        return (scene);
    }
    
    public static void main(String[] args) {    	
      JFrame frame = new JFrame("Swing and JavaFX");
      JPanel panel = new JPanel();
      
      patient = (Patient) SampleObjects.getUser("dummy", "dummy");
      width = 980;
      height = 310;
      panel.add(initFX(patient, width, height));        
      frame.add(panel);      
      frame.setSize(width, height);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
