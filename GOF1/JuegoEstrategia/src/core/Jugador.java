package core;

import java.util.LinkedList;
import java.util.List;

import core.Units.Artillero;
import core.Units.ArtilleroAbstractFactory;
import core.Units.ArtilleroFactoryProvider;
import core.Units.ZapadorAbstractFactory;
import core.Units.ZapadorFactoryProvider;
import core.Units.Zapador;

public abstract class Jugador {

	protected List<Artillero> artilleros = new LinkedList<Artillero>();
	protected List<Zapador> zapadores = new LinkedList<Zapador>();
	protected ZapadorAbstractFactory barracksZapador;
	protected ArtilleroAbstractFactory barracksArtillero;
	protected String tipo;

	public Jugador(String tipo) {
		this.tipo = tipo;
		barracksZapador = ZapadorFactoryProvider.getFactory(tipo);
		barracksArtillero = ArtilleroFactoryProvider.getFactory(tipo);

		// creamos el ejercito inicial (todos de la misma raza, no se pueden mezclar!)
		for (int i = 0; i < 2; i++) {
			artilleros.add((Artillero) barracksArtillero.recruit(this.tipo));
			zapadores.add((Zapador) barracksZapador.recruit(this.tipo));
		}
	}

	public abstract void jugar();
}
