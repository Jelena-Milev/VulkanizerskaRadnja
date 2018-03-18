package gume.radnja;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import gume.AutoGuma;

public class VulkanizerskaRadnjaTest {

	private VulkanizerskaRadnja radnja;
	private AutoGuma a;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		radnja = new VulkanizerskaRadnja();
		a = new AutoGuma();
		a.setMarkaModel("Michelin");
		a.setPrecnik(15);
		a.setSirina(185);
		a.setVisina(60);
	}

	@After
	public void tearDown() throws Exception {
		radnja = null;
		a = null;
	}

	/**
	 * Test proverava da li metoda dodajGumu baca NullPointerException izuzetak kada
	 * joj je prosledjen null
	 */
	@Test(expected = java.lang.NullPointerException.class)
	public void testDodajGumuNull() {
		radnja.dodajGumu(null);
	}

	/**
	 * Test proverava da li metoda dodajGumu baca RuntimeException izuzetak kada joj
	 * je prosledjen objekat guma koji se vec nalazi u listi guma vulkanizerske
	 * radnje
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testDodajGumuKojaPostoji() {
		radnja.dodajGumu(a);
		radnja.dodajGumu(a);
	}

	/**
	 * Test proverava da li metoda dodajGumu zaista dodaje gumu (koje nema u listi)
	 * u listu guma vulkanizerske radnje
	 */
	@Test
	public void testDodajGumu() {
		radnja.dodajGumu(a);
		LinkedList<AutoGuma> nova = radnja.pronadjiGumu("Michelin");
		assertTrue(nova.contains(a));
	}

	/**
	 * Test proverava da li metoda dodajGumu zaista dodaje gumu (koje nema u listi)
	 * u listu guma vulkanizerske radnje na pocetak liste
	 */
	@Test
	public void testDodajGumuDaLiSeDodajeNaPocetak() {
		AutoGuma a2 = new AutoGuma();
		a2.setMarkaModel("Michelin");
		a2.setPrecnik(14);
		a2.setSirina(185);
		a2.setVisina(60);

		AutoGuma a3 = new AutoGuma();
		a3.setMarkaModel("Michelin");
		a3.setPrecnik(14);
		a3.setSirina(185);
		a3.setVisina(70);

		AutoGuma a4 = new AutoGuma();
		a4.setMarkaModel("Tigar");
		a4.setPrecnik(14);
		a4.setSirina(160);
		a4.setVisina(70);

		radnja.dodajGumu(a);
		radnja.dodajGumu(a4);
		radnja.dodajGumu(a3);
		radnja.dodajGumu(a2);
		LinkedList<AutoGuma> nova = radnja.pronadjiGumu("Michelin");
		assertTrue(nova.getFirst().equals(a2));
	}

	/**
	 * Test proverava da li metoda pronadjiGumu vraca null za slucaj kada joj je
	 * prosledjen null umesto konkretnog Stringa prema kome se vrsi pretrazivanje
	 */
	@Test
	public void testPronadjiGumuNull() {
		assertEquals(null, radnja.pronadjiGumu(null));
	}

	/**
	 * Test proverava da li metoda pronadjiGumu vraca praznu listu kada joj je
	 * prosledjen String koji ne odgovara atributu markaModel nijedne gume u listi
	 */
	@Test
	public void testPronadjiGumuKakveNemaURadnji() {
		AutoGuma a2 = new AutoGuma();
		a2.setMarkaModel("Michelin");
		a2.setPrecnik(14);
		a2.setSirina(185);
		a2.setVisina(60);
		radnja.dodajGumu(a);
		radnja.dodajGumu(a2);

		LinkedList<AutoGuma> nadjene = radnja.pronadjiGumu("Tigar");

		assertTrue(nadjene.isEmpty());
	}

	/**
	 * Test proverava da li metoda pronadjiGumu vraca nepraznu listu kada joj je
	 * prosledjen String koji odgovara atributu markaModel najmanje jedne gume u
	 * listi
	 */
	@Test
	public void testPronadjiGumu() {
		AutoGuma a2 = new AutoGuma();
		a2.setMarkaModel("Michelin");
		a2.setPrecnik(14);
		a2.setSirina(185);
		a2.setVisina(60);
		radnja.dodajGumu(a);
		radnja.dodajGumu(a2);

		LinkedList<AutoGuma> nadjene = radnja.pronadjiGumu("Michelin");
		// Test je pao znaci da je lista prazna
		// sto je slucaj ako guma nije dodata ili nije ni pronadjena
		// Kako se guma dodaje naredbom novaLista.add(gume.get(i));
		// koja je u redu jedino je moguce da guma nije ni pronadjena
		assertFalse(nadjene.isEmpty());
		// Nadjen bug i ispravljen, test prolazi
	}

	/**
	 * Test proverava da li metoda pronadjiGumu vraca nepraznu listu kada joj je
	 * prosledjen String koji odgovara atributu markaModel najmanje jedne gume u
	 * listi bez obzira na da li je prosledjen String napisan malim ili velikim
	 * slovima
	 */
	@Test
	public void testPronadjiGumuKadJeNazivMalimSlovom() {
		AutoGuma a2 = new AutoGuma();
		a2.setMarkaModel("Michelin");
		a2.setPrecnik(14);
		a2.setSirina(185);
		a2.setVisina(60);
		radnja.dodajGumu(a);
		radnja.dodajGumu(a2);

		LinkedList<AutoGuma> nadjene = radnja.pronadjiGumu("michelin");
		// Test je pao znaci da je lista prazna
		// sto je slucaj ako guma nije dodata ili nije ni pronadjena
		// Kako se guma dodaje naredbom novaLista.add(gume.get(i));
		// koja je u redu jedino je moguce da guma nije ni pronadjena
		assertFalse(nadjene.isEmpty());
		// Nadjen bug i ispravljen, test prolazi
	}

	/**
	 * Test proverava da li metoda pronadjiGumu vraca listu koja sadrzi sve gume
	 * marke i modela koji se metodi prosledjuju u vidu jednog Stringa
	 */
	@Test
	public void testPronadjiGumuSve() {
		AutoGuma a2 = new AutoGuma();
		a2.setMarkaModel("Michelin");
		a2.setPrecnik(14);
		a2.setSirina(185);
		a2.setVisina(60);

		AutoGuma a3 = new AutoGuma();
		a3.setMarkaModel("Michelin");
		a3.setPrecnik(14);
		a3.setSirina(185);
		a3.setVisina(70);

		AutoGuma a4 = new AutoGuma();
		a4.setMarkaModel("Tigar");
		a4.setPrecnik(14);
		a4.setSirina(160);
		a4.setVisina(70);

		radnja.dodajGumu(a);
		radnja.dodajGumu(a4);
		radnja.dodajGumu(a3);
		radnja.dodajGumu(a2);

		LinkedList<AutoGuma> nadjene = radnja.pronadjiGumu("michelin");
		assertEquals(3, nadjene.size());
	}

}
