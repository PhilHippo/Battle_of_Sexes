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
            p.getIndividuals().add(this);
            p.n_individual[tag]++;
            this.tag = tag;
            this.p = p;
        }

    public synchronized void give_birth(Individual partner, int cross_rate, Population pop) throws InterruptedException {}

        public void run() {
            if(this.points<0){
            //p.n_individual[this.tag]--;
            //p.getIndividuals().remove(this);
            }
        }
}
