package pokerString;

import static org.junit.Assert.*;

import org.junit.Test;


/* Escenarios:
 * - Poker de 10 (Strings con 3 elementos)
 * - Poker de 1 - 9 (Strings dobles, numero + letra)
 * - Poker de j, q, k (Strings dobles, letra + letra)
 */

public class PokerStatusTest {
	
	PokerStatus poker = new PokerStatus();
	String carta1;
	String carta2;
	String carta3;
	String carta4;
	String carta5;

	@Test
	public void testCaseErrorRepetidas() {
		//Este caso evalua que no haya cartas repetidas.
		
		//Teardown and Setup 
		carta1 = "QP";
		carta2 = "QP";
		carta3 = "QD";
		carta4 = "QC";
		carta5 = "4P";
		
		//Exercise
		String res = poker.verificar(carta1, carta2, carta3, carta4, carta5);
		
		//Verify
		assertEquals("Mano no valida", res);
	}
	
	@Test
	public void testCasePoker1() {
		//Este caso evalua el poker de 10.
		
		//Setup	
		carta1 = "10P";
		carta2 = "10C";
		carta3 = "10D";
		carta4 = "10T";
		carta5 = "4P";
		
		//Exercise
		String res = poker.verificar(carta1, carta2, carta3 ,carta4 ,carta5);
		
		//Verify
		assertEquals("Poker", res);
	}
	
	@Test
	public void testCasePoker2() {
		//Este caso evalua el poker de 2-9.
		//Verificando solo un numero se que va a cumplir lo mismo para los otros 8.
		
		//Teardown and Setup 
		carta1 = "2P";
		carta2 = "2C";
		carta3 = "2D";
		carta4 = "2T";
		carta5 = "4P";
		
		//Exercise
		String res = poker.verificar(carta1, carta2, carta3 ,carta4 ,carta5);
		
		//Verify
		assertEquals("Poker", res);
	}
	
	@Test
	public void testCasePoker3() {
		//Este caso evalua el poker de A, J, Q, K.
		//Verificando solo una letra se que va a cumplir lo mismo para las otras 2.
		
		//Teardown and Setup 
		carta1 = "QP";
		carta2 = "QC";
		carta3 = "QD";
		carta4 = "QT";
		carta5 = "4P";
		
		//Exercise
		String res = poker.verificar(carta1, carta2, carta3 ,carta4 ,carta5);
		
		//Verify
		assertEquals("Poker", res);
	}
	
	@Test
	public void testCaseTrio1() {
		//Este caso evalua el trio de 10.
		
		//Teardown and Setup 
		carta1 = "10P";
		carta2 = "10C";
		carta3 = "10D";
		carta4 = "3D";
		carta5 = "4P";
		
		//Exercise
		String res = poker.verificar(carta1, carta2, carta3 ,carta4 ,carta5);
		
		//Verify
		assertEquals("Trio", res);
	}
	
	@Test
	public void testCaseTrio2() {
		//Este caso evalua el trio de 2-9.
		//Verificando solo un numero se que va a cumplir lo mismo para los otros 8.
		
		//Teardown and Setup 
		carta1 = "2P";
		carta2 = "2C";
		carta3 = "2D";
		carta4 = "5D";
		carta5 = "4P";
		
		//Exercise
		String res = poker.verificar(carta1, carta2, carta3 ,carta4 ,carta5);
		
		//Verify
		assertEquals("Trio", res);
	}
	
	@Test
	public void testCaseTrio3() {
		//Este caso evalua el trio de A, J, Q, K.
		//Verificando solo una letra se que va a cumplir lo mismo para las otras 2.
		
		//Teardown and Setup 
		carta1 = "QP";
		carta2 = "QC";
		carta3 = "QD";
		carta4 = "5D";
		carta5 = "4P";
		
		//Exercise
		String res = poker.verificar(carta1, carta2, carta3 ,carta4 ,carta5);
		
		//Verify
		assertEquals("Trio", res);
	}
	
	@Test
	public void testCaseColor() {
		//Este caso evalua el color.
		
		//Teardown and Setup 
		carta1 = "QP";
		carta2 = "AP";
		carta3 = "8P";
		carta4 = "5P";
		carta5 = "4P";
		
		//Exercise
		String res = poker.verificar(carta1, carta2, carta3 ,carta4 ,carta5);
		
		//Verify
		assertEquals("Color", res);
	}
	
	@Test
	public void testCaseNada() {
		//Este caso evalua una mano valida pero sin jugada.
		
		//Teardown and Setup 
		carta1 = "QP";
		carta2 = "AD";
		carta3 = "8P";
		carta4 = "5T";
		carta5 = "4P";
		
		//Exercise
		String res = poker.verificar(carta1, carta2, carta3 ,carta4 ,carta5);
		
		//Verify
		assertEquals("Nada", res);
	}	
}
