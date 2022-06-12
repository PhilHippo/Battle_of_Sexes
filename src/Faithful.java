public class Faithful extends Male {

    public Faithful () {
        super(1);
    }

    @Override
    public void run() {
        try {
            sleep(16); // troppo irrequieti
            super.run();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
