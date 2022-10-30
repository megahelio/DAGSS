public class ProgramB extends Observable implements Runnable {
    public void run() {
        try {
            System.out.println("[INICIO] ProgramaB");
            notifyObservers(this, true);

            Thread.sleep(13);

            System.out.println("[FIN] ProgramaB");

            notifyObservers(this, false);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}