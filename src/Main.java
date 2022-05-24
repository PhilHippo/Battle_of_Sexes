import org.knowm.xchart.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main  {
    //ci piace scopare ===> still no bitches tho
        public static void main(String[] args) throws InterruptedException, IOException {
            Settings sett = new Settings(0,0,1000000,3,50);
            Population p = new Population(10,sett);
            ArrayList<int[]> trend_population = new ArrayList<>();
            ArrayList<Integer> X_time = new ArrayList<>();
            int counter = 0;
            System.out.println(p.getIndividuals_n());
            /*Individual armando = new Philanderer(2,p);
            Faithful astolfo = new Faithful(2,p);
            Fast giulia = new Fast(2,p);*/

            while (counter < 10) {//while there isn't stability or resources aren't finished : resources are calculated and stored
                //astolfo.give_birth(giulia,5,p);
                //giulia.give_birth(armando,5,p);
                p.mating(); //method in population that tells every random individual to try to copulate
                p.iterazione++;
                System.out.println(Arrays.toString(p.updatetype()));
                trend_population.add(p.getType_n().clone());
                X_time.add(counter);
                counter++;

            }
            System.out.println(p.getIndividuals_n());

            int[] Y_Phil = Population.get_values(0,trend_population);
            int[] Y_Faith = Population.get_values(1,trend_population);
            int[] Y_Coy = Population.get_values(2,trend_population);
            int[] Y_Fast = Population.get_values(3,trend_population);
            int[] Time = X_time.stream().mapToInt(Integer::intValue).toArray();


        // Create Chart
            XYChart chart = new XYChartBuilder().width(1600).height(800).title(Main.class.getSimpleName()).xAxisTitle("Time").yAxisTitle("Number of people").build();
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


