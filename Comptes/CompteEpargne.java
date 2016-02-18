/**
 * Classe de Compte Epargne
 * @author Nathalie QUERE
 */
public class CompteEpargne extends CompteBancaire {
	/**
	 * Variable d'instance
	 */
	private float taux;

	/**
	 * Constructeur du compte épargne
	 * @param nom
	 * 			le nom du titulaire du compte
	 * @param solde
	 *			le solde du compte
	 * @param numero
	 *			le numero de compte
	 * @param taux
	 *			le taux du compte
	 */
	public CompteEpargne(String nom,float solde, String numero, float taux) {
		super(nom, solde, numero);
		this.taux = taux;
	}

	/**
	 * Accesseur direct du taux
	 * @return taux
	 *			le taux du compte
	 */
	public float getTaux() {
		return this.taux;
	}

	/**
	 * Méthode toString
	 * @return s
	 *			la chaine de caractère propre à un compte épargne.
	 */
	public String toString() {
		String s;
		s = super.toString();
		s += " de taux :" + this.getTaux();
		return s;
	}

	/**
	 * Méthode qui calcule les intérets annuels du compte
	 * @return interet
	 *				les interets du compte > 0 et < 5
	 */
	public float calculeInteret() {
		float interet = 0;
		if (this.getTaux() > 0)
			interet = super.getSolde() * this.getTaux();
		return interet;
	}
	/**
	 * Méthode qui augmente le solde du compte avec le montant des interets annuels.
	 * @return le nouveau solde du compte
	 */

	public float ajouteInteret() {
		return (this.calculeInteret() + super.getSolde());
	}
}