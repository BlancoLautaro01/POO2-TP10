package pokerCarta;

import static org.junit.Assert.*;

import org.junit.Test;

public class CartaTest {

	//Setup general
	Carta carta1 = new Carta(14, "P");
	Carta carta2 = new Carta(4, "P");
	Carta carta3 = new Carta(11, "C");
	
	@Test
	public void testConstructor() {
		
		//No necesita otro setup ni exercise o ni teardown.
		assertEquals(carta1.getPalo(), "P");
		assertEquals(carta1.getValor(), 14);
	}
	
	@Test
	public void testMismoPalo() {
		
		//No necesita otro setup ni exercise o ni teardown.
		assertTrue(carta1.tieneMismoPaloQue(carta2));
		assertFalse(carta1.tieneMismoPaloQue(carta3));
	}
	
	@Test
	public void testEsMayorA() {
		
		//No necesita otro setup ni exercise o ni teardown.
		assertTrue(carta1.esMayorA(carta2));
		assertTrue(carta3.esMayorA(carta2));
		assertFalse(carta2.esMayorA(carta3));
	}
}
