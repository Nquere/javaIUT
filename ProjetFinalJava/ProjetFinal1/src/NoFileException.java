/**
 * Classe NoFileException héritant de la classe Exception
 * @author Nathalie QUERE
 *
 */
public class NoFileException extends Exception{
	/**
	 * Variable d'instance path : le chemin de la photo
	 */
	private String path;

	/**
	 * Constructeur de la classe 
	 * @param message : message à afficher 
	 * @param path : chemin non correct
	 */
	public NoFileException(String message, String path) {
		super(message);
		this.path = path;
	}

	/**
	 * Accesseur de la variable
	 * @return le chemin de la photo
	 */
	public String getPath() {
		return this.path;
	}

	/**
	 * Méthode toString de cette classe
	 * affiche le message d'erreur + le chemin non correct
	 */
	public String toString() {
		String s = super.toString();
		s+= " : "+this.getPath();
		return s;
	}
}