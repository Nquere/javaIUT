/**
 * Classe de Personne
 * @author Nathalie QUERE 
 *
 */
public class Personne {
	/**
	 * Variables d'instance nom et mail
	 */
	private String nom;
	private String mail;

	/**
	 * Constructeur de la classe personne avec 2 paramétres
	 * @param name : le nom de la personne
	 * @param mail : l'adresse mail de la personne
	 */
	public Personne(String name, String mail) {
		this.nom = name;
		this.mail = mail;
	}

	/**
	 * Constructeur de la classe personne avec seulement un constructeur
	 * @param name : le nom de la personne
	 */
	public Personne(String name) {
		this.nom = name;
		this.mail = null;
	}

	/**
	 * Accesseur de la variable nom
	 * @return le nom de la personne
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Accesseur de la variable mail
	 * @return l'adresse mail de la personne
	 */
	public String getMail() {
		return this.mail;
	}

	/**
	 * Accesseur de la variable mail (privé) : modifie la variable mail
	 * @param mail : l'adresse mail de la personne
	 */
	private void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * Méthode de la variable mail
	 * @param mail : l'adresse mail de la personne
	 */
	public void changeMail(String mail) {
		this.setMail(mail);
	}
	
	/**
	 * Méthode equals : permet de savoir si deux personnes sont identiques
	 * @return true si c'est le cas
	 */
	public boolean equals(Object o) {
		if (!(o instanceof Personne)) return false;
		Personne p = (Personne) o;
		return (this.getMail().equals(p.getMail()) && this.getNom().equals(p.getNom()));
	}

	/**
	 * Méthode toString : donne les différentes caractéristiques d'une personne
	 * @return une chaine de caractères s
	 */
	public String toString() {
		String s = "\nNom de la personne : "+this.getNom();
		s+= "\nAdresse mail de la personne : "+this.getMail();
		return s;
	}
}