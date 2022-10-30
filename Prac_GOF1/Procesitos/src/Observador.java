public class Observador implements Observer {

    @Override
    public void update(Observable observable, String data) {
        System.out.println(data);
    }

}
