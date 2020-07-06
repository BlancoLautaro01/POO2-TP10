package pokerCarta;

public class PokerStatus {
	
	
	public Jugada jugadaGanadora(Jugada jugada1, Jugada jugada2) {
		
		if (jugada2.verificar() == "Mano no valida" || jugada1.verificar() == "Mano no valida") {
			System.out.print("Alguna de las jugadas no es valida, intente con otras porque el retorno no es valido.");
		}
		return this.jugadaValidaGanadora(jugada1, jugada2);
	}
	
	public Jugada jugadaValidaGanadora(Jugada jugada1, Jugada jugada2) {
		Jugada jugadaGanadora = jugada1;
		if(this.hayEmpate(jugada1, jugada2)) {
			jugadaGanadora = this.desempatar(jugada1, jugada2);
		} else if (jugada2.verificar() == "Poker") {
			jugadaGanadora = jugada2;
		} else if (jugada2.verificar() == "Color" && jugada1.verificar() != "Poker") {
			jugadaGanadora = jugada2;
		} else if (jugada2.verificar() == "Trio" && jugada1.verificar() != "Poker" && jugada1.verificar() != "Color") {
			jugadaGanadora = jugada2;
		}
		return jugadaGanadora;
	}
	
	private boolean hayEmpate(Jugada jugada1, Jugada jugada2) {
		return jugada2.verificar() == jugada1.verificar();
	}
	
	private Jugada desempatar(Jugada jugada1, Jugada jugada2) {
		
		//Decidi que si aun siguen empatados en los valores, gana la jugada 1 por ser mano.
		Jugada jugadaGanadora = jugada1;
		if (jugada1.valorDeJugada() < jugada2.valorDeJugada()) {
			jugadaGanadora = jugada2;
		}
		return jugadaGanadora;
	}
}
