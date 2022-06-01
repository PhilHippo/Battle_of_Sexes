public class Individual extends Thread {

    protected int type;
    protected int points = -1;

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

    @Override
    public void run () {

    }
}
