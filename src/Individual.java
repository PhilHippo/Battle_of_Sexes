import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public abstract class Individual extends Thread{

        private boolean status;
        private int age;
        private double death_rate;
        private Individual coniuge;
        private ArrayList<Individual> children;
        private final int tag;
        protected int points;

        /*  TAG
        PHILANDERERS 0
        FAITHFUL 1
        COY 2
        FAST 3
         */

        public Individual(int tag,int age,int points){
            this.status=true;
            this.age=age;
            this.death_rate=0;
            this.coniuge=null;
            this.children=new ArrayList<Individual>();
            this.tag=tag;
            this.points=points;
        }

        public void die(){ this.status=false;  }

        public void aging(){
            this.age+=1;
            //TO DO
            //change something about deathrate
        }

        public boolean getStatus(){ return this.status;}

        public int getTag(){return this.tag;}

        public void marriage(Individual i){this.coniuge=i;}

}
