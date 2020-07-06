package pokerString;

import java.util.ArrayList;
import java.util.List;

public class PokerStatus {

	public String verificar(String carta1, String carta2, String carta3, String carta4, String carta5) {
		String res = "Nada";
		if (this.esManoValida(carta1, carta2, carta3, carta4, carta5)) {
			if (this.esPoker(carta1, carta2, carta3, carta4, carta5)) {
				res = "Poker";
			} else if (this.esColor(carta1, carta2, carta3, carta4, carta5)) {
				res = "Color";
			} else if (this.esTrio(carta1, carta2, carta3, carta4, carta5)) {
				res = "Trio";
			}
		} else {
			res = "Mano no valida";
		}
		return res;
	}
	
	private boolean esManoValida(String carta1, String carta2, String carta3, String carta4, String carta5) {
		
		
		List<String> cartas = new ArrayList<String>();
		cartas.add(carta2);
		cartas.add(carta3);
		cartas.add(carta4);
		cartas.add(carta5);
		String cartaActual = carta1;
		while ( (cartas.size() > 1) && !cartas.contains(cartaActual)) {
			cartaActual = cartas.remove(0);
		}
		return cartas.size() == 1;
	}
	
	private boolean esPoker(String carta1, String carta2, String carta3, String carta4, String carta5) {
		
		boolean esPoker = false;
		List<String> valores = this.mapValores(carta1, carta2, carta3, carta4, carta5);
		String nActual = valores.remove(0);
		while( valores.size() >= 4 && !esPoker) {
			esPoker = this.aparicionesString(valores, nActual) == 3;
			nActual = valores.remove(0);
		}
		return esPoker;
	}
	
	private boolean esColor(String carta1, String carta2, String carta3, String carta4, String carta5) {
		//Si la cantidad de apariciones de el palo de la primer carta es 5 en la lista map de los palos de la jugada devuelvo True.
		return this.aparicionesString( this.mapPalos(carta1, carta2, carta3, carta4, carta5), this.getPalo(carta1)) == 5;
	}
	
	private boolean esTrio(String carta1, String carta2, String carta3, String carta4, String carta5) {
		
		boolean esTrio = false;
		List<String> valores = this.mapValores(carta1, carta2, carta3, carta4, carta5);
		String nActual = valores.remove(0);
		while( valores.size() >=3 && !esTrio) {
			esTrio = this.aparicionesString(valores, nActual) == 2;
			nActual = valores.remove(0);
		}
		return esTrio;
	}
	
	private List<String> mapPalos(String carta1, String carta2, String carta3, String carta4, String carta5) {
		List<String> valores = new ArrayList<String>();
		
		List<String> cartas = new ArrayList<String>();
		cartas.add(carta1);
		cartas.add(carta2);
		cartas.add(carta3);
		cartas.add(carta4);
		cartas.add(carta5);
		
		for(String carta: cartas) {
			valores.add(getPalo(carta));
		}
		return valores;
	}
	
	private String getPalo(String carta) {
		
		String palo;
		if(carta.length() == 2) {
			palo = String.valueOf(carta.charAt(1));
		} else {
			palo = String.valueOf(carta.charAt(2));
		}
		return palo;
	}
	
	private List<String> mapValores(String carta1, String carta2, String carta3, String carta4, String carta5) {
		List<String> valores = new ArrayList<String>();
		List<String> cartas = new ArrayList<String>();
		cartas.add(carta1);
		cartas.add(carta2);
		cartas.add(carta3);
		cartas.add(carta4);
		cartas.add(carta5);
		
		for(String carta: cartas) {
			valores.add(getValor(carta));
		}
		return valores;
	}
	
	private String getValor(String carta) {
		return carta.substring(0, carta.length() - 1);
	}
	
	private int aparicionesString(List<String> palos, String x) {
		int contador = 0;
		for(String palo: palos) {
			if(palo.equals(x)) {
				contador++;
			}
		}
		return contador;
	}
}