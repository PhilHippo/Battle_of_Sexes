public class Female extends Individual{

    public Female (int type) {
        super(type);
    }

    @Override
    public synchronized void run() {
        while(Main.untilEquilibriumReached) {
            while(Time.day) {
                Population.club.push(this);
                try {
                    wait();
                    // start check points|| this.numberChildren >= Population.maxChildren
                    if (this.points < 0) {
                        synchronized (Population.numberIndividuals) {
                            Population.numberIndividuals[this.type]--;
                        }
                        interrupt();
                        return;
                    }
                } catch (InterruptedException dying) {
                    System.out.println("I died in yo arms tonight. controllare cosa significa questo messaggio in female 23");
                }
            }
            this.points-= Population.d;
        }
    }

    public synchronized void giveBirth(Male gentleman) throws InterruptedException{}
}
