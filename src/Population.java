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

    //constructor with only n_of_people and resourses, random n of each type of people
    public Population(int n,int r){
        init(n,r,0,0,0,0);
        this.individuals=new ArrayList<Individual>();
        this.create_people_random(individuals,n);
    }

    //constructor with specific number of type of people
    public Population(int n,int r,int f,int p,int c,int s){
        init(n,r,f,p,c,s);
        this.individuals=new ArrayList<Individual>();

        while(f>0){
            individuals.add(new Faithful(1,18));
            f--;
        }

        while(p>0){
            individuals.add(new Philanderer(0,18));
            p--;
        }

        while(c>0){
            individuals.add(new Coy(2,18));
            c--;
        }

        while(s>0){
            individuals.add(new Fast(3,18));
            s--;
        }

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


    private void create_people_random(List a,int n){

        Random rand = new Random();

        for (int i=0;i<n;i++){
            int x=rand.nextInt(0,3);
            switch (x){
                case 0: //0 is Philanderer
                    a.add(new Philanderer(0,18));
                    break;
                case 1: //1 is Faithful
                    a.add(new Faithful(0,18));
                    break;
                case 2: //2 is Coy
                    a.add(new Coy(3,18));
                    break;
                case 3: //3 is Fast
                    a.add(new Fast(3,18));
                    break;
            }
        }
    }





}
