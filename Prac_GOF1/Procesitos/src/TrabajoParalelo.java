import java.util.ArrayList;

public class TrabajoParalelo extends Trabajo {

    private ArrayList<Thread> program;

    public TrabajoParalelo() {
        program = new ArrayList<>();
    }

    @Override
    public void run() {
        for (int i = 0; i < program.size(); i++) {
            program.get(i).start();
        }
        for (int i = 0; i < program.size(); i++) {
            try {
                program.get(i).join();
            } catch (InterruptedException e) {
                System.err.println("ERROR Trabajo Paralelo: No se han podido recuperar los hilos.");
                e.printStackTrace();
            }
        }

    }

    @Override
    public void add(Runnable r) {
        program.add(new Thread(r));
    }
}