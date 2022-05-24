public abstract class Individual extends Thread{
        protected int tag;
        protected double points;
        protected volatile boolean taken = false;
        protected volatile Population p;

        /*  TAG
        PHILANDERERS 0
        FAITHFUL 1
        COY 2
        FAST 3
         */

        public Individual(int tag, double points, Population p){
            this.points=points;
            this.tag = tag;
            this.p = p;
            p.getIndividuals().add(this);

            synchronized (Population.n_individuals) {
                int a = Population.n_individuals[tag] + 1;

                try {  //this try catch seems useless but it's a must for the sync to work
                    sleep(1);
                } catch (InterruptedException ignored) {
                }

                Population.n_individuals[tag] = a;
            }
        }

    public synchronized void give_birth(Individual partner, int cross_rate, Population pop) throws InterruptedException {}
        public void run() {
            if(this.points<0){
            //p.n_individual[this.tag]--;
            //p.getIndividuals().remove(this);
            }
        }
}
