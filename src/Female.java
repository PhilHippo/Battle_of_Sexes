public class Female extends Individual{

    public Female (int type) {
        super(type);
    }

    @Override
    public synchronized void run() {
        while(Main.untilEquilibriumReached && numberChildren < maxChildren) {

            while(Time.day) {
                Population.club.push(this);
                try {
                    wait();
                    // start check points
                    if (this.points < 1) {
                        synchronized (Population.numberIndividuals) {
                            Population.numberIndividuals[this.type]--;
                        }
                        return;
                    }
                    // start check children
                    if (this.numberChildren >= maxChildren) {
                        return;
                    }
                    // end checks
                    sleep(25); // troppo irrequieti
                } catch (InterruptedException dying) {}
            }

            // it is night here: does nothing
        }
        // todo per ora muoiono solo le fast
    }

    public synchronized void giveBirth(Male gentleman) throws InterruptedException {}
}
