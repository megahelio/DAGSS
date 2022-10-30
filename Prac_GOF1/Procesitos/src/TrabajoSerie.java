import java.util.ArrayList;

public class TrabajoSerie extends Trabajo {
    private ArrayList<Thread> programas;

    public TrabajoSerie() {
        programas = new ArrayList<>();
    }

    @Override
    public void run() {
        for (int i = 0; i < programas.size(); i++) {
            programas.get(i).start();
            try {
                programas.get(i).join();
            } catch (InterruptedException e) {
                System.err.println("ERROR Trabajo Serie: No se ha podido recuperar el hilo.");
                e.printStackTrace();
            }

        }
    }

    @Override
    public void add(Runnable r) {
        programas.add(new Thread(r));
    }
}
