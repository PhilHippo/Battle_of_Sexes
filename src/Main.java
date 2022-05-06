public class Main {

    //ci piace scopare

    public static void main(String[] args) {
       /* Philanderer Filippo = new Philanderer(0,19,9999);
        Philanderer Andre = new Philanderer(0,19,100);
        Philanderer Simone = new Philanderer(0,19,1);
        Philanderer Lorenzo = new Philanderer(0,19, 100);
        Filippo.die();
        Andre.die();
        Simone.die();
        Lorenzo.die();
        */

        //test
        Settings sett = new Settings(0,0,0,0,100,10);
        Population p = new Population(1001,1000,sett);
        System.out.println(p.get_n_individual());

    }
}
