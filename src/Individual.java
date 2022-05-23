import java.util.ArrayList;
import java.util.Random;

public abstract class Individual extends Thread{
        protected int tag;
        protected Individual coniuge;
        protected double points;
        protected volatile boolean taken = false;

        /*  TAG
        PHILANDERERS 0
        FAITHFUL 1
        COY 2
        FAST 3
         */

        public Individual(int tag, double points, Population p){
            this.points=points;
            p.getIndividuals().add(this);
            p.n_individual[tag]=p.n_individual[tag]+1;
            this.tag = tag;
        }
    public synchronized ArrayList<Individual> give_birth(Individual partner, int cross_rate, Population pop) throws InterruptedException {;
        return null;
    }

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
