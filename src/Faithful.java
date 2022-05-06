import java.util.ArrayList;

public class Faithful extends Male{

    private boolean status;
    private int age;
    private double death_rate;
    private Individual coniuge;
    private ArrayList<Individual> children;
    private int tag;

    public Faithful(int tag, int age) {
        super(tag, age);
    }

}
