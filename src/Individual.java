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

        public int getTag(){return this.tag;}

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
