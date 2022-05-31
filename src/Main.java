import org.knowm.xchart.*;
import java.util.ArrayList;

public class Main  {
        public static void main(String[] args) throws InterruptedException {

            Settings sett = new Settings(15,20,3,120000,3,60);
            Population p = new Population(sett,0,1,1,0);
            ArrayList<int[]> trend_population = new ArrayList<>();
            ArrayList<Integer> X_time = new ArrayList<>();

            // while there isn't stability, continue
            int counter = 0;
            while (counter < 10) {
                Time.nightTime(p, trend_population, X_time, counter);
                Time.dayTime(1000);
                counter++;
            }

            System.out.println("\n" + "Male population: " + p.getMale().size());
            System.out.println("Female population: " + p.getFemale().size());
            System.out.println("Total population: " + p.getIndividuals_n());


            int[] Y_Phil = Population.get_values(0,trend_population);
            int[] Y_Faith = Population.get_values(1,trend_population);
            int[] Y_Coy = Population.get_values(2,trend_population);
            int[] Y_Fast = Population.get_values(3,trend_population);
            int[] Time = X_time.stream().mapToInt(Integer::intValue).toArray();


        // Create Chart
            XYChart chart = new XYChartBuilder().width(1600).height(800).title(Main.class.getSimpleName()).xAxisTitle("Generations").yAxisTitle("Number of people").build();
            chart.addSeries("Philanderer", Time, Y_Phil);
            chart.addSeries("Faithful", Time, Y_Faith);
            chart.addSeries("Fast", Time, Y_Fast);
            chart.addSeries("Coy", Time, Y_Coy);

        // Show it
            new SwingWrapper(chart).displayChart();
        // Save it
            //BitmapEncoder.saveBitmap(chart, "./Sample_Chart", BitmapEncoder.BitmapFormat.PNG);
        // or save it in high-res
            //BitmapEncoder.saveBitmapWithDPI(chart, "./Sample_Chart_300_DPI", BitmapEncoder.BitmapFormat.PNG, 300);

    }





}


