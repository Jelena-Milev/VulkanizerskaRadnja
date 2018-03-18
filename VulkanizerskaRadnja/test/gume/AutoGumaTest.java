package gume;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AutoGumaTest {

	private AutoGuma a;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		a=new AutoGuma();
	}

	@After
	public void tearDown() throws Exception {
		a=null;
	}

	/**
	 * Test proverava da li metoda zaista postavlja za 
	 * novu vrednost atributa markaModel String koji joj se prosledjuje
	 */
	@Test
	public void testSetMarkaModel() {
		a.setMarkaModel("Michelin");
		assertEquals("Michelin", a.getMarkaModel());
	}

	/**
	 * Test proverava da li metoda baca RuntimeExceprion izuzetak 
	 * kada joj je prosledjen null
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetMarkaModelNull() {
		a.setMarkaModel(null);
	}
	
	/**
	 * Test proverava da li metoda baca RuntimeExceprion izuzetak 
	 * kada joj je prosledjen String kraci od 3 karaktera
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetMarkaModelKratakString() {
		a.setMarkaModel("AR");
	}

	/**
	 * Test proverava da li metoda zaista postavlja za 
	 * novu vrednost atributa precnik vrednost koja joj se prosledjuje
	 * kada vrednost pripada dozvoljenom intervalu
	 */
	@Test
	public void testSetPrecnik() {
		a.setPrecnik(13);
		assertEquals(13, a.getPrecnik());
	}
	/**
	 * Test proverava da li metoda baca RuntimeExceprion izuzetak 
	 * kada joj je prosledjena vrednost manja od donje dozvoljene granice
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPrecnikIspodDonjeGranice() {
		a.setPrecnik(12);
	}
	/**
	 * Test proverava da li metoda baca RuntimeExceprion izuzetak 
	 * kada joj je prosledjena vrednost veca od gornje dozvoljene granice
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPrecnikIznadGornjeGranice() {
		a.setPrecnik(23);
	}
	/**
	 * Test proverava da li metoda zaista postavlja za 
	 * novu vrednost atributa sirina vrednost koja joj se prosledjuje
	 * kada vrednost pripada dozvoljenom intervalu
	 */
	@Test
	public void testSetSirina() {
		a.setSirina(200);
		assertEquals(200, a.getSirina());
	}
	/**
	 * Test proverava da li metoda baca RuntimeExceprion izuzetak 
	 * kada joj je prosledjena vrednost manja od donje dozvoljene granice
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSirinaIspodDonjeGranice() {
		a.setSirina(134);
	}
	/**
	 * Test proverava da li metoda baca RuntimeExceprion izuzetak 
	 * kada joj je prosledjena vrednost veca od gornje dozvoljene granice
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSirinaIznadGornjeGranice() {
		a.setSirina(406);
	}
	/**
	 * Test proverava da li metoda zaista postavlja za 
	 * novu vrednost atributa visina vrednost koja joj se prosledjuje
	 * kada vrednost pripada dozvoljenom intervalu
	 */
	@Test
	public void testSetVisina() {
		a.setVisina(25);
		assertEquals(25, a.getVisina());
	}
	/**
	 * Test proverava da li metoda baca RuntimeExceprion izuzetak 
	 * kada joj je prosledjena vrednost manja od donje dozvoljene granice
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetVisinaIspodDonjeGranice() {
		a.setVisina(24);
	}
	
	/**
	 * Test proverava da li metoda baca RuntimeExceprion izuzetak 
	 * kada joj je prosledjena vrednost veca od gornje dozvoljene granice
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetVisinaIznadGornjeGranice() {
		a.setVisina(96);
	}

	/**
	 * Test proverava da li redefinisana metoda toString vraca String koji sadrzi
	 * tacne vrednosti svih atributa objekta klase AutoGuma za koji se poziva
	 */
	@Test
	public void testToString() {
		a.setMarkaModel("Michelin");
		a.setPrecnik(14);
		a.setSirina(185);
		a.setVisina(60);
		assertEquals("AutoGuma [markaModel=Michelin, precnik=14, sirina=185, visina=60]", a.toString());
	}

	/**
	 * Test proverava da li metoda equals vraca true ako se njome porede dva objekta
	 * klase AutoGuma sa identicnim vrednostima odgovarajucih atributa
	 */
	@Test
	public void testEqualsObject() {
		a.setMarkaModel("Michelin");
		a.setPrecnik(14);
		a.setSirina(185);
		a.setVisina(60);
		
		AutoGuma a1=new AutoGuma();
		a1.setMarkaModel("Michelin");
		a1.setPrecnik(14);
		a1.setSirina(185);
		a1.setVisina(60);
		
		assertTrue(a.equals(a1));
	}
	/**
	 * Test proverava da li metoda equals vraca false ako se njome porede dva objekta
	 * klase AutoGuma koji imaju sve atribute iste osim atributa markaModel
	 */
	@Test
	public void testEqualsObjectRazliciteMarkaModel() {
		a.setMarkaModel("Michelin");
		a.setPrecnik(14);
		a.setSirina(185);
		a.setVisina(60);
		
		AutoGuma a1=new AutoGuma();
		a1.setMarkaModel("Tigar");
		a1.setPrecnik(14);
		a1.setSirina(185);
		a1.setVisina(60);
		
		assertFalse(a.equals(a1));
	}
	/**
	 * Test proverava da li metoda equals vraca false ako se njome porede dva objekta
	 * klase AutoGuma koji imaju sve atribute iste osim atributa precnik
	 */
	@Test
	public void testEqualsObjectRazlicitPrecnik() {
		a.setMarkaModel("Michelin");
		a.setPrecnik(14);
		a.setSirina(185);
		a.setVisina(60);
		
		AutoGuma a1=new AutoGuma();
		a1.setMarkaModel("Michelin");
		a1.setPrecnik(15);
		a1.setSirina(185);
		a1.setVisina(60);
		
		assertFalse(a.equals(a1));
	}
	/**
	 * Test proverava da li metoda equals vraca false ako se njome porede dva objekta
	 * klase AutoGuma koji imaju sve atribute iste osim atributa sirina
	 */
	@Test
	public void testEqualsObjectRazliciteSirine() {
		a.setMarkaModel("Michelin");
		a.setPrecnik(14);
		a.setSirina(200);
		a.setVisina(60);
		
		AutoGuma a1=new AutoGuma();
		a1.setMarkaModel("Michelin");
		a1.setPrecnik(14);
		a1.setSirina(185);
		a1.setVisina(60);
		
		assertFalse(a.equals(a1));
	}
	/**
	 * Test proverava da li metoda equals vraca false ako se njome porede dva objekta
	 * klase AutoGuma koji imaju sve atribute iste osim atributa visina
	 */
	@Test 
	public void testEqualsObjectRazliciteVisine() {
		a.setMarkaModel("Michelin");
		a.setPrecnik(15);
		a.setSirina(185);
		a.setVisina(60);
		
		AutoGuma a1=new AutoGuma();
		a1.setMarkaModel("Michelin");
		a1.setPrecnik(15);
		a1.setSirina(185);
		a1.setVisina(61);
		
		assertFalse(a.equals(a1));
	}
	/**
	 * Test proverava da li metoda equals vraca true ako su objekti koje poredi
	 * zapravo jedan te isti objekat
	 */
	@Test 
	public void testEqualsObjectJedanTeIsti() {
		a.setMarkaModel("Michelin");
		a.setPrecnik(14);
		a.setSirina(185);
		a.setVisina(60);
		
		assertTrue(a.equals(a));
	}

}
