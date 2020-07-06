package pokerCarta;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PokerStatusTest {

	PokerStatus poker = new PokerStatus();
	Jugada jugada1;
	Jugada jugada2;
	Carta carta1;
	Carta carta2;
	Carta carta3;
	Carta carta4;
	Carta carta5;
	Carta carta6;
	Carta carta7;
	Carta carta8;
	Carta carta9;
	Carta carta10;
	
	@Test
	public void testJugadaGanadoraPokerYPoker() {
		
		//Teardown and Setup 
		carta1 = new Carta(3, "P");
		carta2 = new Carta(3, "C");
		carta3 = new Carta(3, "D");
		carta4 = new Carta(3, "T");
		carta5 = new Carta(2, "D");
		jugada1 = new Jugada(carta1, carta2, carta3, carta4, carta5);
		
		carta6 = new Carta(10, "P");
		carta7 = new Carta(10, "C");
		carta8 = new Carta(10, "D");
		carta9 = new Carta(10, "T");
		carta10 = new Carta(2, "D");
		jugada2 = new Jugada(carta6, carta7, carta8, carta9, carta10);
		
		//Exercise
		Jugada res = poker.jugadaGanadora(jugada1, jugada2);
		
		//Verify
		assertEquals(res, jugada2);
	}	
	
	@Test
	public void testJugadaGanadoraTrioYTrio() {
		
		//Teardown and Setup 
		carta1 = new Carta(10, "P");
		carta2 = new Carta(10, "C");
		carta3 = new Carta(10, "D");
		carta4 = new Carta(4, "T");
		carta5 = new Carta(2, "D");
		jugada1 = new Jugada(carta1, carta2, carta3, carta4, carta5);
		
		carta6 = new Carta(3, "P");
		carta7 = new Carta(3, "C");
		carta8 = new Carta(3, "D");
		carta9 = new Carta(6, "T");
		carta10 = new Carta(2, "D");
		jugada2 = new Jugada(carta6, carta7, carta8, carta9, carta10);
		
		//Exercise
		Jugada res = poker.jugadaGanadora(jugada1, jugada2);
		
		//Verify
		assertEquals(res, jugada1);
	}	
	
	@Test
	public void testJugadaGanadoraPokerYColor() {
		
		//Teardown and Setup 
		carta1 = new Carta(10, "P");
		carta2 = new Carta(10, "C");
		carta3 = new Carta(10, "D");
		carta4 = new Carta(10, "T");
		carta5 = new Carta(2, "D");
		jugada1 = new Jugada(carta1, carta2, carta3, carta4, carta5);
		
		carta6 = new Carta(14, "D");
		carta7 = new Carta(5, "D");
		carta8 = new Carta(7, "D");
		carta9 = new Carta(2, "D");
		carta10 = new Carta(4, "D");
		jugada2 = new Jugada(carta6, carta7, carta8, carta9, carta10);
		
		//Exercise
		Jugada res = poker.jugadaGanadora(jugada1, jugada2);
		
		//Verify
		assertEquals(res, jugada1);
	}	
	
	@Test
	public void testJugadaGanadoraPokerYTrio() {
		
		//Teardown and Setup 
		carta1 = new Carta(10, "P");
		carta2 = new Carta(10, "C");
		carta3 = new Carta(10, "D");
		carta4 = new Carta(10, "T");
		carta5 = new Carta(2, "D");
		jugada1 = new Jugada(carta1, carta2, carta3, carta4, carta5);
		
		carta6 = new Carta(3, "P");
		carta7 = new Carta(3, "C");
		carta8 = new Carta(3, "D");
		carta9 = new Carta(6, "T");
		carta10 = new Carta(2, "D");
		jugada2 = new Jugada(carta6, carta7, carta8, carta9, carta10);
		
		//Exercise
		Jugada res = poker.jugadaGanadora(jugada1, jugada2);
		
		//Verify
		assertEquals(res, jugada1);
	}	
	
	@Test
	public void testJugadaGanadoraColorYTrio() {
		
		//Teardown and Setup 
		carta1 = new Carta(14, "D");
		carta2 = new Carta(4, "D");
		carta3 = new Carta(6, "D");
		carta4 = new Carta(7, "D");
		carta5 = new Carta(2, "D");
		jugada1 = new Jugada(carta1, carta2, carta3, carta4, carta5);
		
		carta6 = new Carta(3, "P");
		carta7 = new Carta(3, "C");
		carta8 = new Carta(3, "D");
		carta9 = new Carta(6, "T");
		carta10 = new Carta(2, "D");
		jugada2 = new Jugada(carta6, carta7, carta8, carta9, carta10);
		
		//Exercise
		Jugada res = poker.jugadaGanadora(jugada1, jugada2);
		
		//Verify
		assertEquals(res, jugada1);
	}	
	
}
