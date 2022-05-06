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


    //constructor with only n_of_people and resourses, random n of each type of people
    public Population(int n,int r,Settings s){
        //will divide in equal parts, TODO in random se volete senno stica
        int x = n/4;
        this.settings=s;
        init(n,r,x,x,x,x);
        this.individuals=new ArrayList<Individual>();
        double initial_point=settings.initial_points;
        this.create_people(x,x,x,x,initial_point);

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

        while(f>0){
            individuals.add(new Faithful(1,18,initial_point));
            f--;
        }

        while(p>0){
            individuals.add(new Philanderer(0,18,initial_point));
            p--;
        }

        while(c>0){
            individuals.add(new Coy(2,18,initial_point));
            c--;
        }

        while(s>0){
            individuals.add(new Fast(3,18,initial_point));
            s--;
        }

    }


    public HashMap get_n_individual(){ return n_individual;}

}


