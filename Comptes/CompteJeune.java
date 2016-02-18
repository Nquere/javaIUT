import java.text.*;
import java.util.*;
/**
 * Classe de compte Jeune
 * @author Nathalie QUERE
 */
public class CompteJeune extends CompteEpargne {
	/**
	 * La date de naissance du titulaire
	 */
	private GregorianCalendar date;

	/**
	 * Constructeur
	 * @param nom : nom du titulaire
	 * @param solde : le solde du titulaire
	 * @param numéro : le numéro du compte jeune
	 * @param taux : le taux du compte jeune
	 * @param date : la date de naissance du titulaire car moins de 25 ans
	 */
	public CompteJeune(String nom, float solde, String numero, float taux, GregorianCalendar date) {
		super(nom, solde, numero, taux);
		this.date = date;
	}

	public CompteJeune(String nom, float solde, String numero, float taux, int year, int month, int day) {
		super(nom, solde, numero, taux);
		GregorianCalendar date = new GregorianCalendar(year, month, day);
		this.date = date;
	}

	public GregorianCalendar getDate() {
		return (this.date);
	}
	/**
	 * Méthode toString 
	 */
	public String toString() {
		String s;
		SimpleDateFormat  simpleFormat = new SimpleDateFormat("dd/MM/yyyy");
		s = super.toString();
		s += " né le "+ simpleFormat.format(this.getDate().getTime());
		return s;
	}
}