import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Population {
    private volatile int n; // # completo
    private boolean status; // attivo/disattivo
    protected volatile int[] n_individual; // # per tipo
    private volatile List<Individual> individuals; // lista di tutte le persone
    private double resources; // pizza pasta maccaroni
    public int iterazione = 0; // # generazione
    protected Settings settings; // impostazioni
    protected double initial_point; //

    public void mating() {
    Random radmon = new Random();
        for (int i = 0; i < individuals.size()/2; i++) {
        individuals.get(i).give_birth(individuals.get(radmon.nextInt(individuals.size()/2, individuals.size())));
        }
        for (int i = individuals.size()/2+1; i < individuals.size(); i++) {
        individuals.get(i).give_birth(individuals.get(radmon.nextInt(0, individuals.size()/2)));
        }
    }
    //constructor with only n_of_people and r of resources, random n of each type of people
    public Population(int n,int r,Settings s){
        int[] arr = randomList(4, n);
        int phil = arr[0];
        int faith = arr[1];
        int coy = arr[2];
        int fast = arr[3];
        this.n_individual = new int[4];
        n_individual[0]= phil;
        n_individual[1]= faith;
        n_individual[2]= coy;
        n_individual[3]= fast;
        this.settings=s;
        this.n = n;
        this.status = true;
        this.resources = r;
        this.individuals = new ArrayList<Individual>();
        this.initial_point = settings.initial_points;
        this.create_people(faith,phil,coy,fast, initial_point);
    }


    private void create_people(int phil,int faith,int coy,int fast,double initial_point){
        for (int i = 0; i < phil; i++) {
            Philanderer person = new Philanderer(initial_point,this);
            person.start();
        }
        for (int i = 0; i < faith; i++) {
            Faithful person = new Faithful(initial_point,this);
            person.start();
        }
        for (int i = 0; i < coy; i++) {
            Coy person = new Coy(initial_point,this);
            person.start();

        }
        for (int i = 0; i < fast; i++) {
            Fast person = new Fast(initial_point,this);
            person.start();
        }
    }
    
    public int[] getType_n(){ return n_individual;}

    public int[] updatetype() {
        int [] arr = new int[4];
        for (Individual i: individuals) {
            if (i.tag == 3) {arr[3]++;}
            if (i.tag == 2) {arr[2]++;}
            if (i.tag == 1) {arr[1]++;}
            if (i.tag == 0) {arr[0]++;}
        }
        return arr;
    }
    public static int[] get_values(int index,ArrayList<int[]> trends){
        int size = trends.size();
        int[] arr = new int[size];
        for (int i = 0; i < size ; i++){
            arr[i] = trends.get(i)[index];
        }

        return arr;
    }

    public int getIndividuals_n() {
        return individuals.size();
    }
    public boolean getStatus(){ return this.status;}
    public static int[] randomList(int m, int target) {

        // Create an array of size m where
        // every element is initialized to 0
        int arr[] = new int[m];
        Random radmon = new Random();
        // To make the sum of the final list as n
        for (int i = 0; i < target; i++)
        {
            // Increment any random element
            // from the array by 1
            arr[(int)(radmon.nextDouble(0.0,1.0) * m)]++;
        }
        return arr;
    }
    public List<Individual> getIndividuals() {
        return individuals;
    }
}


