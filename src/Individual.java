import java.util.ArrayList;
import java.util.Random;

public abstract class Individual extends Thread{

        protected boolean status;
        protected int age;
        protected Individual coniuge;
        protected ArrayList<Individual> children;
        protected final int tag;
        protected double points;
        protected volatile boolean taken = false;

        /*  TAG
        PHILANDERERS 0
        FAITHFUL 1
        COY 2
        FAST 3
         */

        public Individual(int tag,int age,double points, Population p){
            this.status=true;
            if (age < 0 || age > 100) {
                throw new IllegalArgumentException();
            } else {
                this.age = age;
            }
            this.coniuge=null;
            this.children=new ArrayList<>();
            this.tag=tag;
            this.points=points;
            p.getIndividuals().add(this);
        }

        public void die(){ this.status=false;  }

        // da decide quanto toglie
        public void aging(int x){ // l'età non ci serve
            this.age+=1;
            this.points-=x;
            if ( points <= 0){
                this.die();
            }
            //TO DO
            //change something about deathrate
        }

        public boolean getStatus(){ return this.status;}

        public int getTag(){return this.tag;}

        public void marriage(Individual i){this.coniuge=i;}

    public synchronized ArrayList<Individual> give_birth(Individual partner, int cross_rate, Population pop) throws InterruptedException {;
        return null;
    }

    public void get_points(double x){ this.points+=x;}  // da vede
        public void run(Population pop) {
            try {
                sleep(500); // maturità
                // n_popolazione--;
                //altre cose
                //fuck
                pop.getIndividuals().remove(this); // ded

            } catch (InterruptedException e) {
                System.out.println("was sleeping...");
            }
        }


    public void give_birth(Individual individual) {
    }
}
