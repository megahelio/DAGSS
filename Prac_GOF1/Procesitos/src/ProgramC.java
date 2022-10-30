public class ProgramC extends Observable implements Runnable {
    public void run() {
        try {
            System.out.println("[INICIO] ProgramaC");
            notifyObservers(this, true);

            Thread.sleep(9);

            System.out.println("[FIN] ProgramaC");
            notifyObservers(this, false);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}