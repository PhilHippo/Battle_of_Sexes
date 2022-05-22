
public class Settings {

    //Aggiungiamo i settings a popolazione later
    //così possiamo runnare piu popolazioni con stessa impostazione

    protected double cost_birth;
    protected double cost_child;
    protected double resources_available;
    protected int max_kids_possible;
    protected int max_year_individual;
    protected double initial_points;

    public Settings(double cb,double cc, double ra, int mk,int myi,double ip){
        this.cost_birth=cb;
        this.cost_child=cc;
        this.resources_available=ra;
        this.max_kids_possible=mk;
        this.max_year_individual=myi;
        this.initial_points=ip;
    }


}
