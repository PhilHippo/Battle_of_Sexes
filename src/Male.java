import java.util.ArrayList;

public class Male extends Individual{

    private boolean status;
    private int age;
    private double death_rate;
    private Individual coniuge;
    private ArrayList<Individual> children;
    private int tag;
    private int points;

    public Male(int tag,int age,double points){
        super(tag,age,points);
    }

    //TO DO
    public boolean courtship(){
        return true;
    }



}
