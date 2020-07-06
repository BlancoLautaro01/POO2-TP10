package pokerCarta;

import static org.junit.Assert.*;

import org.junit.Test;


public class JugadaTest {
	
	PokerStatus poker = new PokerStatus();
	Jugada jugada1;
	Jugada jugada2;
	Carta carta1;
	Carta carta2;
	Carta carta3;
	Carta carta4;
	Carta carta5;

	@Test
	public void testCaseErrorRepetidas() {
		//Este caso evalua que no haya cartas repetidas.
		
		//Setup 
		carta1 = new Carta(14, "P");
		carta2 = new Carta(14, "P");
		carta3 = new Carta(2, "T");
		carta4 = new Carta(13, "P");
		carta5 = new Carta(2, "D");
		jugada1 = new Jugada(carta1, carta2, carta3, carta4, carta5);
		
		//Exercise
		String res = jugada1.verificar();
		
		//Verify
		assertEquals("Mano no valida", res);
	}
	
	@Test
	public void testCasePoker() {
		//Este caso evalua el poker.
		
		//Teardown and Setup	
		carta1 = new Carta(10, "P");
		carta2 = new Carta(10, "C");
		carta3 = new Carta(10, "D");
		carta4 = new Carta(10, "T");
		carta5 = new Carta(14, "P");
		jugada1 = new Jugada(carta1, carta2, carta3, carta4, carta5);
		
		//Exercise
		String res = jugada1.verificar();
		
		//Verify
		assertEquals("Poker", res);
	}
	@Test
	public void testCaseTrio() {
		//Este caso evalua el trio.
		
		//Teardown and Setup 
		carta1 = new Carta(10, "P");
		carta2 = new Carta(10, "C");
		carta3 = new Carta(10, "D");
		carta4 = new Carta(5, "D");
		carta5 = new Carta(14, "P");
		jugada1 = new Jugada(carta1, carta2, carta3, carta4, carta5);
		
		//Exercise
		String res = jugada1.verificar();
		
		//Verify
		assertEquals("Trio", res);
	}
	
	@Test
	public void testCaseColor() {
		//Este caso evalua el color.
		
		//Teardown and Setup 
		carta1 = new Carta(11, "P");
		carta2 = new Carta(10, "P");
		carta3 = new Carta(4, "P");
		carta4 = new Carta(7, "P");
		carta5 = new Carta(14, "P");
		jugada1 = new Jugada(carta1, carta2, carta3, carta4, carta5);
		
		//Exercise
		String res = jugada1.verificar();
		
		//Verify
		assertEquals("Color", res);
	}
	
	@Test
	public void testCaseNada() {
		//Este caso evalua una mano valida pero sin jugada.
		
		//Teardown and Setup 
		carta1 = new Carta(10, "P");
		carta2 = new Carta(11, "C");
		carta3 = new Carta(5, "P");
		carta4 = new Carta(4, "T");
		carta5 = new Carta(2, "D");
		jugada1 = new Jugada(carta1, carta2, carta3, carta4, carta5);
		
		//Exercise
		String res = jugada1.verificar();
		
		//Verify
		assertEquals("Nada", res);
	}	
}

