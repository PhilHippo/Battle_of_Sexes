public class Individual extends Thread {

    /*  TYPES
    PHILANDERER 0
    FAITHFUL 1
    COY 2
    FAST 3
     */

    protected int type;
    protected int points = 4;      //initial points

    protected static final int a = 15;     //benefit of having a baby
    protected static final int b = 20;     //cost of having a baby !!always even!!
    protected static final int c = 3;      //cost of courtship


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
