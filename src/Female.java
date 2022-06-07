public class Female extends Individual{

    public Female (int type) {
        super(type);
    }

    @Override
    public synchronized void run() {
        life();
        // todo per ora muoiono solo le fast
    }

    private void life(){
        while(Main.untilEquilibriumReached) {

            while(Time.day) {
                Population.club.push(this);
                try {
                    wait();
                    if (this.points < 1) {
                        synchronized (Population.numberIndividuals) {
                            Population.numberIndividuals[this.type]--;
                        }
                        return;
                    }
                    sleep(25); // troppo irrequieti
                } catch (InterruptedException dying) {}
            }

            // it is night here: does nothing
        }
    }

    public synchronized void giveBirth(Male gentleman){}
}
