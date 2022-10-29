package core;

import core.Units.Zapador;
import core.Units.Artillero;

public class JugadorMaquina extends Jugador {

	public JugadorMaquina(String tipo) {
		super(tipo);
	}

	@Override
	public void jugar() {
		int jugada = (int) (Math.random() * 10 % 4);
		switch (jugada) {
			case 0:
				// disparamos!
				for (Artillero artillero : artilleros) {
					artillero.disparar();
				}
				break;
			case 1:
				// ponemos bombas!
				for (Zapador zapador : zapadores) {
					zapador.ponerBomba();
				}
				break;
			case 2:
				artilleros.add((Artillero) barracksArtillero.recruit(this.tipo));
				break;
			case 3:
				zapadores.add((Zapador) barracksZapador.recruit(this.tipo));
				break;

		}

	}

}
