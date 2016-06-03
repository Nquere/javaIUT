/**
 * Classe NotExistException héritant de la classe Exception
 * @author Nathalie QUERE
 *
 */
public class NotExistException extends Exception {
	/**
	 * Variable d'instance path : le chemin de la photo
	 */
	private String path;

	/**
	 * Constructeur de la classe
	 * @param message : message à afficher 
	 * @param path : chemin non correct
	 */
	public NotExistException(String message, String path) {
		super(message);
		this.path = path;
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
		s+= " : "+this.getPath();
		return s;
	}
}