import org.knowm.xchart.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Population {
    public static volatile int[] numberIndividuals = new int[4]; // population counter
    public static MyList club = new MyList();
    public static ArrayList<ArrayList<Integer>> trendPopulation = new ArrayList<>();
    static ArrayList<Integer> X_time = new ArrayList<>();

    public Population (int phil, int faith, int coy, int fast) {
        this.createIndividuals(phil, faith, coy, fast);
        // initialize trendPopulation
        for (int i=0; i<4; i++) {
            Population.trendPopulation.add(new ArrayList<Integer>());
        }
    }

    private void createIndividuals (int phil, int faith, int coy, int fast) {
        for (; phil>0; phil--) {
            Philanderer ind = new Philanderer();
            ind.setName("Mirco" + phil);
            ind.start();
        }
        for (; faith>0; faith--) {
            Faithful ind = new Faithful();
            ind.start();
        }
        for (; coy>0; coy--) {
            Coy ind = new Coy();
            ind.setName("Cloe");
            ind.start();
        }
        for (; fast>0; fast--) {
            Fast ind = new Fast();
            ind.start();
        }
    }

    public static void printMalesFemalesTot() {
        int males = numberIndividuals[0] + numberIndividuals[1];
        int females = numberIndividuals[2] + numberIndividuals[3];
        System.out.println("Male population: " + males);
        System.out.println("Female population: " + females);
        System.out.println("Total population: " + (males + females));
    }

    public static void wakeUpEverybody() {
        synchronized (club) {
            club.notifyAll();
        }
        for (Female f : club) {
            //f.wakeUp();
        }
        System.out.println("THe club has been closed!");
    }

    public static void updateTrendPopulation() {
        //System.out.println(Arrays.toString(Population.trendPopulation));
        for (int i=0; i<4; i++) {
            Population.trendPopulation.get(i).add(Population.numberIndividuals[i]);
        }
    }

    public static int[] convertIntegers(ArrayList<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i);
        }
        return ret;
    }

    public static void printChart() throws IOException {
        int[] Y_Phil = convertIntegers(trendPopulation.get(0));
        int[] Y_Faith = convertIntegers(trendPopulation.get(1));
        int[] Y_Coy = convertIntegers(trendPopulation.get(2));
        int[] Y_Fast = convertIntegers(trendPopulation.get(3));
        int[] Time = X_time.stream().mapToInt(Integer::intValue).toArray();

        XYChart chart = new XYChartBuilder().width(1600).height(800).title("Population Trend").xAxisTitle("Time").yAxisTitle("Number of people").build();

        chart.addSeries("Philanderer", Time, Y_Phil);
        chart.addSeries("Faithful", Time, Y_Faith);
        chart.addSeries("Fast", Time, Y_Fast);
        chart.addSeries("Coy", Time, Y_Coy);

        new SwingWrapper(chart).displayChart();

        BitmapEncoder.saveBitmap(chart, "./Sample_Chart", BitmapEncoder.BitmapFormat.PNG);
    }

}
