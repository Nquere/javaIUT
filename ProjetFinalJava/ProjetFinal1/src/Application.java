import java.util.ArrayList;
/**
 * Classe Application
 * @author Nathalie QUERE
 *
 */
public class Application {

	/**
	 * Variables d'instances :
	 *		listeAp : type : liste d'albums photo
	 *		listeAe : type : liste d'albums photo événement
	 *		listeEv : type : liste d'événements
	 */

	private ArrayList<AlbumPhoto> listeAp;
	private ArrayList<AlbumEvent> listeAe;
	private ArrayList<Evenement> listeEv;

	/**
	 *	Constructeur de la classe Application
	 *	Aucun paramètre
	 */

	public Application() {
		this.listeAp = new ArrayList<AlbumPhoto>();
		this.listeAe = new ArrayList<AlbumEvent>();
		this.listeEv = new ArrayList<Evenement>();
	}

	/**
	 *	Accesseurs aux variables d'instances.
	 */

	public ArrayList<AlbumPhoto> getListeAp() {
		return this.listeAp;
	}

	public ArrayList<AlbumEvent> getListeAe() {
		return this.listeAe;
	}

	public ArrayList<Evenement> getListeEv() {
		return this.listeEv;
	}

	/**
	 *	Méthode d'ajout d'AlbumPhoto
	 * @param ap : AlbumPhoto normal
	 */

	public void ajouteAlbumPhoto(AlbumPhoto ap) {
		if (ap != null && !listeAp.contains(ap))
			listeAp.add(ap);
	}

	/**
	 *	Méthode d'ajout d'AlbumEvent
	 * @param ae : AlbumEvent, album photo événement
	 */

	public void ajouteAlbumEvent(AlbumEvent ae) {
		if (ae != null && !listeAe.contains(ae))
			listeAe.add(ae);
	}

	/**
	 *	Méthode d'ajout d'Evénement
	 * @param ev : Evenement, événement
	 */

	public void ajouteEvenement(Evenement ev) {
		if (!listeEv.contains(ev))
			listeEv.add(ev);
	}

	/**
	 *	Méthodes permettant d'obtenir le nombre d'éléments de la liste concernée
	 *	@return un entier.
	 */

	public int getNbAlbumPhoto() {
		int cmp = 0;
		for (AlbumPhoto ap : this.listeAp) {
			cmp++;
		}
		return cmp;
	}

	public int getNbAlbumEvent() {
		int cmp = 0;
		for (AlbumEvent ae : this.listeAe) {
			cmp++;
		}
		return cmp;
	}

	public int getNbEvenement() {
		int cmp = 0;
		for (Evenement e : this.listeEv) {
			cmp++;
		}
		return cmp;
	}
	
	/**
	 *	Méthode toString
	 *	@return s : chaine contenant ce qui doit être affiché concernant l'application
	 */

	public String toString() {
		String s = "\n";
		if (this.getListeAp() != null) {
			int i = 0;
			s+= "Liste des albums photo normaux : Nombre : "+this.getNbAlbumPhoto();
			for (AlbumPhoto ap1 : this.getListeAp()) {
				s+= "\nNom : "+ap1.getNom();
				s+= "\n\tPhotos contenues dans l'album : ";
				for (Photo f1 : ap1.getPhotos()) {
					++i;
					s+="\n\t\tNom : "+f1.getNom();
				}
				s+="\n\tNombre de photos : "+i;
			}				
		}
		if (this.getListeAe() != null) {
	   		s+="\nListe des "+this.getNbAlbumEvent()+" albums photo événement : ";
	   		for (AlbumEvent ae1 : this.getListeAe()) {
	   			int i = 0;
	   			s+="\nNom : "+ae1.getEvent().getNom();
	   			s+="\n\tPhotos contenues dans l'album : ";
				for (PhotoEvent f2 : ae1.getPhotos()) {
					++i;
					s+="\n\t\tNom : "+f2.getNom();
				}
				s+="\n\tNombre de photos : "+i;
				Evenement e1 = ae1.getEvent();
				int j = 0;
				s+="\n\tPersonnes invitées : ";
				for (Personne p1 : e1.getInvites()) {
					++j;
					s+="\n\t\tNom : "+p1.getNom();
				}
				s+="\n\tNombre d'invités : "+j;
	   		}
		}
		return s;
	}
}