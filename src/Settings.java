
public class Settings {

    //Aggiungiamo i settings a popolazione later
    //così possiamo runnare piu popolazioni con stessa impostazione

    protected int benefit_birth;
    protected int cost_child;
    protected int cost_courtship;
    protected int resources_available;
    protected int max_kids_possible;
    protected int initial_points;

    public Settings(int benefit_birth,int cost_child,int cost_courtship, int resources_available, int max_kids_possible,int initial_points){
        this.benefit_birth=benefit_birth;
        this.cost_child=cost_child;
        this.cost_courtship = cost_courtship;
        this.resources_available=resources_available;
        this.max_kids_possible=max_kids_possible;
        this.initial_points=initial_points;
    }


}
