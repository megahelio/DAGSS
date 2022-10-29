package core;

import java.util.ArrayList;
import java.util.List;

public class JuegoEstrategia {

	public static void main(String[] args) {
		
		//podriamos pedir el equipo al jugador
		List<Jugador> jugadores = new ArrayList<>();
		jugadores.add((Jugador) (new JugadorHumano("Atreides")));
		jugadores.add((Jugador) (new JugadorHumano("Frenen")));
		jugadores.add((Jugador) (new JugadorMaquina("Harkonen")));
				
		while(true){
			for (int i=0; i<jugadores.size(); i++) {
				System.out.println("Juega: "+jugadores.get(i).getClass().toString().split("core.")[1]+" nº "+i);
				jugadores.get(i).jugar();
			}
		}
	}

}
