import java.util.ArrayList;
import java.io.File;
/**
 * Classe de Evenement 
 * @author Nathalie QUERE
 *
 */
public class Evenement {
	/**
	 * Variables d'instance : nom et liste des invites
	 */
	private String nomEvent;
	private ArrayList<Personne> invites;

	/**
	 * Constructeur de Evenement
	 * @param name : le nom de l'evenement
	 */
	public Evenement(String name) throws NotExistException {
		File f = new File(name);
		if (!f.exists()) throw new NotExistException("Cet événement n'existe pas", name);
		this.nomEvent = name;
		this.invites = new ArrayList<Personne>();
	}

	/**
	 * Accesseur de la variable nom 
	 * @return nom : le nom de l'evenement
	 */
	public String getNom() {
		return this.nomEvent;
	}

	/**
	 * Accesseur de la variable liste des invites
	 * @return invites : la liste des invites
	 */
	public ArrayList<Personne> getInvites() {
		return this.invites;
	}

	/**
	 * Methode qui permet d'ajouter des personnes a la liste des invites 
	 * @param p : la personne a ajouter dans la liste
	 * @return true si elle a ete ajoute sinon false
	 */
	public boolean ajoutePersonne(Personne p) {
		if (!(this.getInvites().contains(p)))
			return this.getInvites().add(p);
		return false;
	}

	/**
	 * Methode toString de la classe Evenement
	 * @return s qui donne les caracteristiques de l'evenement
	 */
	public String toString() {
		String s = "\nNom de l'événement : "+this.getNom();
		s+= "\n Personnes invitées : ";
		for (Personne p : this.getInvites()) {
			s += p;
		}
		return s;
	}
	
	/**
	 * Methode equals qui compare les deux evenements et verifie si ils sont identiques	
	 * @return true si ils sont identiques sinon false
	 */
	public boolean equals(Object o) {
		if (!(o instanceof Evenement)) return false;
		Evenement e = (Evenement) o;
		return (this.getNom().equals(e.getNom()) && this.getInvites().contains(e));
	}
}