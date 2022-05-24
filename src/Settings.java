
public class Settings {

    //Aggiungiamo i settings a popolazione later
    //così possiamo runnare piu popolazioni con stessa impostazione

    protected double cost_birth;
    protected double cost_child;
    protected double resources_available;
    protected int max_kids_possible;
    protected double initial_points;

    public Settings(double cost_birth,double cost_child, double resources_available, int max_kids_possible,double initial_points){
        this.cost_birth=cost_birth;
        this.cost_child=cost_child;
        this.resources_available=resources_available;
        this.max_kids_possible=max_kids_possible;
        this.initial_points=initial_points;
    }


}
