import java.util.ArrayList;
import java.util.Random;

public abstract class Individual extends Thread{

        protected boolean status;
        protected int age;
        protected double death_rate;
        protected Individual coniuge;
        protected ArrayList<Individual> children;
        protected final int tag;
        protected double points;

        /*  TAG
        PHILANDERERS 0
        FAITHFUL 1
        COY 2
        FAST 3
         */

        public Individual(int tag,int age,double points){
            this.status=true;
            if (age < 0 || age > 100) {
                throw new IllegalArgumentException();
            } else {
                this.age = age;
            }
            this.death_rate=0;
            this.coniuge=null;
            this.children=new ArrayList<Individual>();
            this.tag=tag;
            this.points=points;
        }

        public void die(){ this.status=false;  }

        // da decide quanto toglie
        public void aging(int x){
            this.age+=1;
            this.points-=x;
            if ( points <= 0){
                this.die();
            }
            //TO DO
            //change something about deathrate
        }

        public boolean getStatus(){ return this.status;}

        public int getTag(){return this.tag;}

        public void marriage(Individual i){this.coniuge=i;}

        public void get_points(double x){ this.points+=x;}  // da vede



}
