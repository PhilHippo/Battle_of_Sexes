import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class Population {

    private int n;
    private boolean status;
    private HashMap<String,Integer> n_individual;
    private List<Individual> individuals;
    private double resources;
    private int iterazione;
    protected Settings settings;


    //constructor with only n_of_people and resources, random n of each type of people
    public Population(int n,int r,Settings s){
        //will divide in equal parts
        Random radmon = new Random() ;
        int phil = radmon.nextInt(0,n);
        int faith = radmon.nextInt(0,n - phil);
        int fast = radmon.nextInt(0,n - faith - phil);
        int coy = n - fast - faith - phil;
        this.settings=s;
        init(n,r,phil,faith,fast,coy);
        this.individuals=new ArrayList<Individual>();
        double initial_point=settings.initial_points;
        this.create_people(faith,phil,coy,fast,initial_point);

    }

    //constructor with specific number of type of people
    public Population(int n,int r,int f,int p,int c,int s){
        init(n,r,f,p,c,s);
        this.individuals=new ArrayList<Individual>();
        double initial_point=settings.initial_points;



    }

    private void init(int n,int r,int f,int p, int c,int s) {
        this.n = n;
        this.iterazione = 0;
        this.status = true;
        this.resources = r;
        this.n_individual = new HashMap<>() {
            {
                put("P", p);
                put("C", c);
                put("F", f);
                put("S", s);
            }
        };

    }
    private void create_people(int f,int p,int c,int s,double initial_point){
        // for loop più efficiente
        for (int i = 0; i <= f; i++) {
            Faithful person = new Faithful(1,18,initial_point);
            individuals.add(person);
            person.run();
        }
        for (int i = 0; i <= p; i++) {
            Philanderer person = new Philanderer(0,18,initial_point);
            individuals.add(person);
            person.run();
        }
        for (int i = 0; i <= c; i++) {
            Coy person = new Coy(2,18,initial_point);
            individuals.add(person);
            person.run();

        }
        for (int i = 0; i <= s; i++) {
            Fast person = new Fast(3,18,initial_point);
            individuals.add(person);
            person.run();
        }
    }


    public HashMap get_n_individual(){ return n_individual;}

}


