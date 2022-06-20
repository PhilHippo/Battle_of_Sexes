import org.knowm.xchart.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Population { // a b c d should be final but there are problems

    protected static int a;     //benefit of having a baby
    protected static int b;     //cost of having a baby !!always even!!
    protected static int c;     //cost of courtship
    protected static int d;     //cost of life
    public static volatile int[] numberIndividuals = new int[4]; // population counter
    public static volatile MyList club = new MyList();
    public static ArrayList<ArrayList<Integer>> trendPopulation = new ArrayList<>();
    protected static int maxChildren = 8; // todo until Equilibrium is reached
    static ArrayList<Integer> X_time = new ArrayList<>();
    public static int payoff_FC;
    public static int payoff_FS;

    public Population (int phil, int faith, int coy, int fast, int av, int bv, int cv, int dv) {
        this.createIndividuals(phil, faith, coy, fast);
        a = av;
        b = bv;
        c = cv;
        d = dv;
        payoff_FC = a-b/2-c;
        payoff_FS = a-b/2;


        // initialize trendPopulation
        for (int i=0; i<4; i++) {
            Population.trendPopulation.add(new ArrayList<Integer>());
        }
    }

    private void createIndividuals (int phil, int faith, int coy, int fast) {
        for (; phil>0; phil--) {
            Philanderer ind = new Philanderer();
            ind.start();
        }
        for (; faith>0; faith--) {
            Faithful ind = new Faithful();
            ind.start();
        }
        for (; coy>0; coy--) {
            Coy ind = new Coy();
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
        System.out.print("Male population: " + males + ", ");
        System.out.print("Female population: " + females + ", ");
        System.out.println("Total: " + (males + females));
    }

    public static void updateGraph(int gen) {
        Population.updateTrendPopulation();
        Population.X_time.add(gen);
    }

    public static void updateTrendPopulation() {
        for (int i = 0; i < 4; i++) {
            Population.trendPopulation.get(i).add(Population.numberIndividuals[i]);
        }
    }

    public static int[] convertIntegers(ArrayList<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i);
        }
        return ret;
    }

    public static int[][] get_ratio(){
        int[][] ratio_array = new  int[4][];
        int len = trendPopulation.get(1).size();
        int[] ratio_p = new int[len];
        int[] ratio_f = new int[len];
        int[] ratio_c = new int[len];
        int[] ratio_s = new int[len];
        for(int i = 0; i < len; i++){
            float sumMales = trendPopulation.get(0).get(i) + trendPopulation.get(1).get(i);
            float sumFemales = trendPopulation.get(2).get(i)  + trendPopulation.get(3).get(i);
            int p = (int) ((trendPopulation.get(0).get(i) /sumMales) * 100);
            int f = (int) ((trendPopulation.get(1).get(i) /sumMales) * 100);
            int c = (int) ((trendPopulation.get(2).get(i) /sumFemales) * 100);
            int s = (int) ((trendPopulation.get(3).get(i) /sumFemales) * 100);
            ratio_p[i] = p;
            ratio_f[i] = f;
            ratio_c[i] = c;
            ratio_s[i] = s;
        }

        ratio_array[0] = ratio_p;
        ratio_array[1] = ratio_f;
        ratio_array[2] = ratio_c;
        ratio_array[3] = ratio_s;
        return ratio_array;
    }

    //return the payoff matrix - phi_coy = 0 and fast_phi = a
    public static int[][][] matrixCalculator(){
        int faith_coy = a - b/2 - c;
        int faith_fast = a - b/2;
        int phi_fast = a-b;

        return new int[][][]{{{faith_coy, faith_coy},{0, 0}},{{faith_fast, faith_fast},{phi_fast, a}}};
    }

    // TODO
    public static int[] equilibriumCalculator(){
        int[] equilibrium = new int[]{};
        return equilibrium;
    }

    //prints the payoff matrix
    public synchronized static void printMatrix(int[][][] matrix){
        System.out.println();
        System.out.println("     F      P");
        for (int i = 0; i < matrix.length; i++) {
            if (i == 0){System.out.print("C ");}else{System.out.print("S ");}
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(Arrays.toString(matrix[i][j]) + " ");
            }
            System.out.println();
        }
    }

    public static void printChart() {
        int[] Y_Phil = convertIntegers(trendPopulation.get(0));
        int[] Y_Faith = convertIntegers(trendPopulation.get(1));
        int[] Y_Coy = convertIntegers(trendPopulation.get(2));
        int[] Y_Fast = convertIntegers(trendPopulation.get(3));
        int[] Time = X_time.stream().mapToInt(Integer::intValue).toArray();
        int[][] Ratios = get_ratio();

        XYChart chart = new XYChartBuilder().width(1600).height(800).title("Population Trend").xAxisTitle("Time").yAxisTitle("Number of people").build();
        chart.addSeries("Philanderer", Time, Y_Phil);
        chart.addSeries("Faithful", Time, Y_Faith);
        chart.addSeries("Coy", Time, Y_Coy);
        chart.addSeries("Fast", Time, Y_Fast);

        XYChart chart_ratio = new XYChartBuilder().width(1600).height(800).title("Population Ratio").xAxisTitle("Time").yAxisTitle("Ratio of people").build();
        chart_ratio.addSeries("Philanderer_ratio", Time, Ratios[0]);
        chart_ratio.addSeries("Faithful_ratio", Time, Ratios[1]);
        chart_ratio.addSeries("Coy_ratio", Time, Ratios[2]);
        chart_ratio.addSeries("Fast_ratio", Time, Ratios[3]);

        new SwingWrapper(chart_ratio).displayChart();
        new SwingWrapper(chart).displayChart();


        //BitmapEncoder.saveBitmap(chart, "./Chart_population", BitmapEncoder.BitmapFormat.PNG);
        //BitmapEncoder.saveBitmap(chart_ratio, "./Chart_ratio", BitmapEncoder.BitmapFormat.PNG);
    }
}
