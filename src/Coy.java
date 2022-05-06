import java.util.ArrayList;

public class Coy  extends Female{

    private boolean status;
    private int age;
    private double death_rate;
    private Individual coniuge;
    private ArrayList<Individual> children;
    private int tag;

    public Coy(int tag,int age){
        super(tag,age);
    }
}
