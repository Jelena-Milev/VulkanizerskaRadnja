package gume.radnja;

import java.util.LinkedList;

import gume.AutoGuma;
/**
 * Klasa koja predstavlja vulkanizersku radnju
 * @author Jelena Milev
 * @version 1.0
 */
public class VulkanizerskaRadnja {

	/**
	 * Lista guma koje vulkanizerska radnja ima u ponudi
	 */
	private LinkedList<AutoGuma> gume = new LinkedList<AutoGuma>();

	/**
	 * Metoda koja dodaje novu auto gumu u listu guma vulkanizerske radnje
	 * @param a nova guma koju treba dodati u listu
	 */
	public void dodajGumu(AutoGuma a) {
		if (a == null)
			throw new NullPointerException("Guma ne sme biti null");
		if (gume.contains(a))
			throw new RuntimeException("Guma vec postoji");
		gume.addFirst(a);
	}

	/**
	 * Metoda koja pronalazi sve gume date marke i modela 
	 * @param markaModel marka i model (jedan String) onih guma koje metoda pronalazi 
	 * @return listu koja sadrzi sve nadjene gume date marke i modela
	 */
	public LinkedList<AutoGuma> pronadjiGumu(String markaModel) {
		if (markaModel == null)
			return null;
		LinkedList<AutoGuma> novaLista = new LinkedList<AutoGuma>();
		for (int i = 0; i < gume.size(); i++)
			if (gume.get(i).equals(markaModel))
				novaLista.add(gume.get(i));

		return novaLista;
	}
}
