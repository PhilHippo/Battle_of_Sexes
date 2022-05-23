import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Population {
    private volatile int n;
    private boolean status;
    protected volatile int[] n_individual;
    private volatile List<Individual> individuals;
    private double resources;
    public int iterazione;
    protected Settings settings;
    protected double initial_point;
    //constructor with only n_of_people and r of resources, random n of each type of people
    public Population(int n,int r,Settings s){
        int[] arr = randomList(4, n);
        int phil = arr[0];
        int faith = arr[1];
        int coy = arr[2];
        int fast = arr[3];
        this.settings=s;
        init(n,r,phil,faith,coy,fast);
        this.individuals = new ArrayList<Individual>();
        this.initial_point = settings.initial_points;
        this.create_people(faith,phil,coy,fast, initial_point);

    }
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

    //constructor with specific number of type of people
    public Population(int n,int r,int phil,int faith,int coy,int fast){
        init(n,r,phil,faith,coy,fast);
        this.individuals= new ArrayList<Individual>();
        this.initial_point=settings.initial_points;
    }
    public void mating() {
        Random radmon = new Random();
        for (int i = 0; i < individuals.size()/2; i++) {
            individuals.get(i).give_birth(individuals.get(radmon.nextInt(individuals.size()/2, individuals.size())));
        }
        for (int i = individuals.size()/2+1; i < individuals.size(); i++) {
            individuals.get(i).give_birth(individuals.get(radmon.nextInt(0, individuals.size()/2)));
        }
    }

    private void init(int n,int r, int phil,int faith, int coy,int fast) {
        this.n = n;
        this.iterazione = 0;
        this.status = true;
        this.resources = r;
    }


    private void create_people(int phil,int faith,int coy,int fast,double initial_point){
        for (int i = 0; i < phil; i++) {
            Philanderer person = new Philanderer(initial_point,this);
            person.run();
        }
        for (int i = 0; i < faith; i++) {
            Faithful person = new Faithful(initial_point,this);
            person.run();
        }
        for (int i = 0; i < coy; i++) {
            Coy person = new Coy(initial_point,this);
            person.run();

        }
        for (int i = 0; i < fast; i++) {
            Fast person = new Fast(initial_point,this);
            person.run();
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
    /*  TAG
        PHILANDERERS 0
        FAITHFUL 1
        COY 2
        FAST 3
         */

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

    public List<Individual> getIndividuals() {
        return individuals;
    }
}


