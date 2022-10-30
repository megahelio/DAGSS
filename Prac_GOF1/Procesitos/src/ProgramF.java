public class ProgramF extends Observable implements Runnable {
    public void run() {
        try {
            System.out.println("[INICIO] ProgramaF");
            notifyObservers(this, true);

            Thread.sleep(19);

            System.out.println("[FIN] ProgramaF");

            notifyObservers(this, false);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}