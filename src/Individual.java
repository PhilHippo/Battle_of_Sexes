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

            if(tag == 0 || tag == 1){
                p.getMale().add(this);
            }else{
                p.getFemale().add(this);
            }

            synchronized (Population.n_individuals) {
                Population.n_individuals[tag]++;
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
