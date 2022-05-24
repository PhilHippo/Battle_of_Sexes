public abstract class Individual extends Thread{
        protected int tag;
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
            p.n_individual[tag]++;
            this.tag = tag;
        }
    public synchronized void give_birth(Individual partner, int cross_rate, Population pop) throws InterruptedException {;
        return;
    }

        public void run(Population pop) {
            try {
                sleep(500); // maturità
                // n_popolazione--;
                //altre cose
                pop.n_individual[this.tag]--;
                pop.getIndividuals().remove(this); // ded

            } catch (InterruptedException e) {
                System.out.println("was sleeping...");
            }
        }
}
