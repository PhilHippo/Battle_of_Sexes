import java.util.ArrayList;

public class Philanderer extends Male{

    private boolean status;
    private int age;
    private double death_rate;
    private Individual coniuge;
    private ArrayList<Individual> children;
    private int tag;

    public Philanderer(int tag, int age,int points) {
        super(tag, age,points);
    }

}
