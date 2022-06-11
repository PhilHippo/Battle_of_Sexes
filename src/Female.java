public class Female extends Individual{

    public Female (int type) {
        super(type);
    }

    @Override
    public synchronized void run() { //&& numberChildren < maxChildren
        while(Main.untilEquilibriumReached) {
            while(Time.day) {
                Population.club.push(this);
                try {
                    wait();
                    // start check points
                    /*
                    if (this.points < 1) {
                        synchronized (Population.numberIndividuals) {
                            Population.numberIndividuals[this.type]--;
                        }
                        System.out.println("morte");
                        return;
                    }
                     */
                    // start check children
                    /*
                    if (this.numberChildren >= maxChildren) {
                        return;
                    }
                     */
                    // end checks
                    //sleep(40); // troppo irrequieti
                } catch (InterruptedException dying) {}
            }

            // it is night here: does nothing
        }
        // todo per ora muoiono solo le fast
    }

    public synchronized void giveBirth(Male gentleman) throws InterruptedException{}
}
