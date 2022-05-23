import org.knowm.xchart.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main  {
    //ci piace scopare ===> still no bitches tho
        public static void main(String[] args) throws InterruptedException, IOException {
            //dasdasdas commento a caso
            Settings sett = new Settings(0,0,0,0,100,10);
            Population p = new Population(1001,1000,sett);
            ArrayList<int[]> trend_population = new ArrayList<>();
            ArrayList<Integer> X_time = new ArrayList<>();
            int counter = 0;
            System.out.println(p.getIndividuals_n());
            Philanderer armando = new Philanderer(2,p);
            Faithful astolfo = new Faithful(2,p);
            Fast giulia = new Fast(2,p);

            while (counter < 500) {
        /*        while there isn't stability or resources aren't finished
                  resources are calculated and stored
                  ogni iterazione è una generazione (scelta migliore) o un anno (scelta pessima)
                        */
                armando.give_birth(giulia,5,p);
                //p.mating(); //method in population that tells every random individual to try to copulate
                p.iterazione++;
                trend_population.add(p.getType_n().clone());
                X_time.add(counter);
                counter++;

            }

            System.out.println();
            System.out.println(p.getIndividuals_n());



            int[] Y_Phil = Population.get_values(0,trend_population);
            int[] Y_Faith = Population.get_values(1,trend_population);
            int[] Y_Fast = Population.get_values(2,trend_population);
            int[] Y_Coy = Population.get_values(3,trend_population);
            int[] Time = X_time.stream().mapToInt(Integer::intValue).toArray();


        // Create Chart
            XYChart chart = new XYChartBuilder().width(1600).height(800).title(Main.class.getSimpleName()).xAxisTitle("Time").yAxisTitle("Number of people").build();
            chart.addSeries("Philanderer", Time, Y_Phil);
            chart.addSeries("Faith", Time, Y_Faith);
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


