package pokerCarta;

public class Carta {

	//Atributos
	Integer valor;
	String palo;
	
	//Constructor
	public Carta(int valor, String palo) {
		super();
		this.setValor(valor);
		this.setPalo(palo);
	}
	
	//Getters y Setters
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	public void setPalo(String palo) {
		this.palo = palo;
	}
	
	public String getPalo() {
		return this.palo;
	}
	
	//Implementacion
	public boolean tieneMismoPaloQue(Carta carta) {
		return this.getPalo().equals(carta.getPalo());
	}
	
	public boolean esMayorA(Carta carta) {
		boolean res = false;
		if(this.getValor() == 1 && carta.getValor() != 1) {
			res = true;
		} else {
			res = this.getValor() > carta.getValor();
		}
		return res;
	}
	
	public boolean equals(Carta carta) {
		return (this.getValor() == carta.getValor()) && this.tieneMismoPaloQue(carta);
	}
	
}
