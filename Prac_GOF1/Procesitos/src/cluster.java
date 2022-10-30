public class cluster {
    public static void main(String[] args) throws Exception {
        ProgramA a = new ProgramA();
        ProgramB b = new ProgramB();
        ProgramC c = new ProgramC();
        ProgramD d = new ProgramD();
        ProgramE e = new ProgramE();
        ProgramF f = new ProgramF();

        Observador observador = new Observador();

        a.addObserver(observador);
        b.addObserver(observador);
        c.addObserver(observador);
        d.addObserver(observador);
        e.addObserver(observador);
        f.addObserver(observador);

        Trabajo raiz = new TrabajoSerie();
        raiz.add(a);
        Trabajo intermedio = new TrabajoParalelo();
        intermedio.add(b);
        intermedio.add(c);
        Trabajo serieFinal = new TrabajoSerie();
        serieFinal.add(d);
        serieFinal.add(f);
        intermedio.add(serieFinal);
        raiz.add(intermedio);
        raiz.add(e);
        raiz.run();

    }
}
