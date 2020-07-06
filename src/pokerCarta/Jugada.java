package pokerCarta;

import java.util.ArrayList;
import java.util.List;

public class Jugada {
	
	private List<Carta> cartas = new ArrayList<Carta>();
	
	public Jugada (Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
		
		this.cartas.add(carta1);
		this.cartas.add(carta2);
		this.cartas.add(carta3);
		this.cartas.add(carta4);
		this.cartas.add(carta5);
	}

	public List<Carta> getCartas(){
		return this.cartas;
	}
	
	//Verificar
	public String verificar() {
		String res = "Nada";
		if (this.esManoValida()) {
			if (this.esPoker()) {
				res = "Poker";
			} else if (this.esColor()) {
				res = "Color";
			} else if (this.esTrio()) {
				res = "Trio";
			}
		} else {
			res = "Mano no valida";
		}
		return res;
	}
	
	private boolean esManoValida() {
		
		List<Carta> cartas = new ArrayList<Carta>(this.getCartas());
		Carta cartaActual = cartas.remove(0);
		while ( (cartas.size() > 1) && !this.contains(cartas, cartaActual)) {
			cartaActual = cartas.remove(0);
		}
		return cartas.size() == 1;
	}
	
	private boolean esPoker() {
		
		boolean esPoker = false;
		List<Integer> valores = this.mapValores(this.getCartas());
		Integer nActual = valores.remove(0);
		while( valores.size() >= 4 && !esPoker) {
			esPoker = this.apariciones(valores, nActual) == 3;
			nActual = valores.remove(0);
		}
		return esPoker;
	}
	
	private boolean esColor() {
		//Si la cantidad de apariciones de el palo de la primer carta es 5 en la lista map de los palos de la jugada devuelvo True.
		return this.aparicionesString( this.mapPalos(this.getCartas()), this.getCartas().get(0).getPalo() ) == 5;
	}
	
	private boolean esTrio() {
		
		boolean esTrio = false;
		List<Integer> valores = this.mapValores(this.getCartas());
		Integer nActual = valores.remove(0);
		while( valores.size() >=3 && !esTrio) {
			esTrio = this.apariciones(valores, nActual) == 2;
			nActual = valores.remove(0);
		}
		return esTrio;
	}
	
	private List<String> mapPalos(List<Carta> cartas) {
		List<String> valores = new ArrayList<String>();
		for(Carta carta: cartas) {
			valores.add(carta.getPalo());
		}
		return valores;
	}
	
	private List<Integer> mapValores(List<Carta> cartas) {
		List<Integer> valores = new ArrayList<Integer>();
		for(Carta carta: cartas) {
			valores.add(carta.getValor());
		}
		return valores;
	}
	
	private int apariciones(List<Integer> valores, Integer n) {
		int contador = 0;
		for(Integer x: valores) {
			if(n == x) {
				contador++;
			}
		}
		return contador;
	}
	
	private int aparicionesString(List<String> palos, String x) {
		int contador = 0;
		for(String palo: palos) {
			if(palo == x) {
				contador++;
			}
		}
		return contador;
	}
	
	private boolean contains(List<Carta> cartas, Carta carta) {
		
		List<Carta> cartasList = new ArrayList<Carta>(cartas);
		Carta cartaActual = cartasList.remove(0);
		while(!cartasList.isEmpty() && !carta.equals(cartaActual)) {
			cartaActual = cartasList.remove(0);
		}
		return !cartasList.isEmpty();
	}
	
	public Integer valorDeJugada() {
		Integer valorDeJugada;
		if(this.esPoker()) {
			valorDeJugada = this.valorDePoker();
		} else if (this.esTrio()) {
			valorDeJugada = this.valorDeTrio();
		} else {
			valorDeJugada = this.valorDeMano();
		}
		return valorDeJugada;
	}
	
	private Integer valorDeMano() {
		List<Integer> valores = this.mapValores(this.getCartas());
		Integer valorDeMano = valores.remove(0);
		for(Integer n: valores) {
			if(n > valorDeMano) {
				valorDeMano = n;
			}
		}
		return valorDeMano;
	}
	
	private Integer valorDePoker() {
		
		List<Integer> valores = this.mapValores(this.getCartas());
		Integer valorDePoker = valores.remove(0);
		while(valores.size() >= 4 && !(this.apariciones(valores, valorDePoker) == 3) ) {
			valorDePoker = valores.remove(0);
		}
		return valorDePoker;
	}
	
	private Integer valorDeTrio() {
		
		List<Integer> valores = this.mapValores(this.getCartas());
		Integer valorDePoker = valores.remove(0);
		while(valores.size() >= 3 && !(this.apariciones(valores, valorDePoker) == 2) ) {
			valorDePoker = valores.remove(0);
		}
		return valorDePoker;
	}
}
