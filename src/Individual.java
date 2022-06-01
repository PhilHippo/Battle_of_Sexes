public class Individual extends Thread {

    protected int type;
    protected int points = 60;

    protected final int a = 15;
    protected final int b = 20;
    protected final int c = 3;

    public Individual (int type) {
        this.type = type;
        synchronized (Population.numberIndividuals) {
            Population.numberIndividuals[type]++;
        }
    }

    public Individual (int type, int points) {
        this(type);
        this.points = points;
    }

    public boolean isPhilanderer(int tag){
        return tag == 0;
    }

    public boolean isFaithful(int tag){
        return tag == 1;
    }



    @Override
    public void run () {

    }
}
