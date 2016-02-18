import java.util.*;
public class AgenceBancaire {

	// Variables d'instance
	private String nom;
	private String adresse;
	private HashMap<String,CompteBancaire> comptes;

	// Constructeurs
	public AgenceBancaire(String nom, String adresse) {
		this.nom = nom;
		this.adresse = adresse;
		this.comptes = new HashMap<String,CompteBancaire>();
	}

	// Accesseurs directs
	public String getNom() {
		return this.nom;
	}
	public String getAdresse() {
		return this.adresse;
	}
	public HashMap<String,CompteBancaire> getComptes() {
		return this.comptes;
	}

	// Méthode toString()
	public String toString() {
		String s = "Agence bancaire :";
		for (CompteBancaire cb : this.comptes.values()) {
			s+= cb.toString()+"--";
		}
		return s;
	}

	public boolean ajoute(CompteBancaire cb) {
		if (!(this.getComptes().containsKey(cb.getNom())))
		{
			this.getComptes().put(cb.getNom(), cb);
			return (true);
		}
		return (false);
	}

	public boolean compteExiste(CompteBancaire cb) {
		return (this.getComptes().containsKey(cb.getNom()));
	}

	public boolean comptePersonneExiste(String nomPersonne) {
		for (CompteBancaire cb : this.getComptes().values()) {
			if (cb.getNom().equals(nomPersonne))
				return true;
		}
		return false;
	}

	public boolean compteNumeroExiste(String numPersonne) {
		for (CompteBancaire cb : this.getComptes().values()) {
			if (cb.getNumero().equals(numPersonne))
				return true;
		}
		return false;
	}

	public HashMap<String,CompteBancaire> lesComptesDe(String nomPersonne) {
		HashMap<String,CompteBancaire> comptesPersonne = new HashMap<String,CompteBancaire>();
		for (CompteBancaire cb : this.getComptes().values()) {
			if (cb.getNom().equals(nomPersonne))
				comptesPersonne.put(cb.getNom(),cb);
		}
		return comptesPersonne;
	}

	// public ArrayList<String> mesClients() {
	// 	ArrayList<String> listClients = new ArrayList<String>();
	// 	for (CompteBancaire cb : this.getComptes()) {
	// 		listClients.add(cb.getNom());
	// 	}
	// 	return listClients;
	// }

	// 2eme version de la méthode mesClients

	public ArrayList<String> mesClients() {
		ArrayList<String> listClients = new ArrayList<String>();
		for (CompteBancaire cb : this.getComptes().values()) {
			if (!(listClients.contains(cb.getNom())))
				listClients.add(cb.getNom());
		}
		return listClients;
	}

	public boolean retireComptesDe(String nomPersonne) {
		for (CompteBancaire cb : this.getComptes().values()) {
			if (cb.getNom().equals(nomPersonne)) {
				this.getComptes().remove(nomPersonne);
				return (true);
			}
		}
		return false;
	}
}