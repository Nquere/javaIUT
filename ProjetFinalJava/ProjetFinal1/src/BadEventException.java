/**
 * Classe BadEventException héritant de la classe Exception
 * @author Nathalie QUERE 
 *
 */
public class BadEventException extends Exception {
	/**
	 * Variable d'instance event & path : le chemin de la photo
	 */
	private Evenement event;
	private String path;

	/**
	 * Constructeur de la classe
	 * @param message : message à afficher 
	 * @param event : événement non correct
	 */
	public BadEventException(String message, Evenement event, String path) {
		super(message);
		this.path = path;
		this.event = event;
	}

	/**
	 * Accesseur de la variable d'intance
	 * @return l'événement non correct de la photo
	 */
	public Evenement getEvent() {
		return this.event;
	}

	/**
	 * Accesseur de la variable d'intance
	 * @return le chemin non correct de la photo
	 */
	public String getPath() {
		return this.path;
	}
	
	/**
	 * Méthode toString de cette classe
	 */
	public String toString() {
		String s = super.toString();
		s+= " : "+this.getEvent().getNom() + "\nL'image étant : "+this.getPath();
		return s;
	}
}