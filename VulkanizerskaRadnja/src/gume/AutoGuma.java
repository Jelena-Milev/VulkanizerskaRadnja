package gume;

/**
 * Klasa koja predstavlja auto gumu.
 * @author Jelena Milev 
 * @version 0.1
 */

public class AutoGuma {
	
	/**
	 * Marka i model auto gume
	 */
	private String markaModel = null;
	/**
	 * Precnik auto gume
	 */
	private int precnik = 0;
	/**
	 * Sirina auto gume
	 */
	private int sirina = 0;
	/**
	 * Visina auto gume
	 */
	private int visina = 0;

	/**
	 * Metoda vraca vrednost atributa markaModel auto gume
	 * @return vrednost atributa markaModel kao jedan String
	 */
	public String getMarkaModel() {
		return markaModel;
	}

	/**
	 * Postavlja novu vrednost atributa markaModel
	 * @param markaModel nova vrednost atributa markaModel
	 * @throws java.lang.RuntimeException ako je metodi prosledjen
	 * <ul>
	 * <li> null ili</li>
	 * <li> String kraci od 3 znaka </li>
	 * </ul>
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel == null || markaModel.length() < 3)
			throw new RuntimeException("Morate uneti marku i model");
		this.markaModel = markaModel;
	}

	/**
	 * Metoda vraca vrednost atributa precnik auto gume
	 * @return vrednost atributa precnik 
	 */
	public int getPrecnik() {
		return precnik;
	}

	/**
	 * Postavlja novu vrednost atributa precnik
	 * @param precnik nova vrednost atributa precnik
	 * @throws java.lang.RuntimeException ako je
	 * metodi prosledjena vrednost koja je van intervala [13,22]
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 || precnik > 22)
			throw new RuntimeException("Precnik van opsega");
		this.precnik = precnik;
	}

	/**
	 * Metoda vraca vrednost atributa sirina auto gume
	 * @return vrednost atributa sirina 
	 */
	public int getSirina() {
		return sirina;
	}

	/**
	 * Postavlja novu vrednost atributa sirina
	 * @param sirina nova vrednost atributa sirina
	 * @throws java.lang.RuntimeException ako je
	 * metodi prosledjena vrednost koja je van intervala [135,355]
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 || sirina > 355)
			throw new RuntimeException("Sirina van opsega");
		this.sirina = sirina;
	}

	/**
	 * Metoda vraca vrednost atributa visina auto gume
	 * @return vrednost atributa visina 
	 */
	public int getVisina() {
		return visina;
	}

	/**
	 * Postavlja novu vrednost atributa visina
	 * @param visina nova vrednost atributa visina
	 * @throws java.lang.RuntimeException ako je
	 * metodi prosledjena vrednost koja je van intervala [25,95]
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new RuntimeException("Visina van opsega");
		this.visina = visina;
	}

	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina="
				+ visina + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
		} else if (!markaModel.equals(other.markaModel))
			return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
	}
}
