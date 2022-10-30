public class ProgramE extends Observable implements Runnable {
    public void run() {
        try {
            System.out.println("[INICIO] ProgramaE");
            notifyObservers(this, true);

            Thread.sleep(21);

            System.out.println("[FIN] ProgramaE");

            notifyObservers(this, false);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}