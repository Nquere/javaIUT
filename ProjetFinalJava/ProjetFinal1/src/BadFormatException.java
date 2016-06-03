/**
 * Classe BadFormatException héritant de la classe Exception
 * @author Nathalie QUERE 
 *
 */
public class BadFormatException extends Exception {
	/**
	 * Variable d'instance suffix 
	 * Suffixe decrivant le format de la photo
	 */
	private String suffix;

	/**
	 * Constructeur de l'exception BadFormatException
	 * @param message : message à afficher
	 * @param suffix : format de la photo
	 */
	public BadFormatException(String message, String suffix) {
		super(message);
		this.suffix = suffix;
	}

	/**
	 * Accesseur de la variable suffixe
	 * @return
	 */
	public String getSuffix() {
		return this.suffix;
	}

	/**
	 * Méthode toString : affichant le message d'erreur + le format qui ne convient pas
	 */
	public String toString() {
		String s = super.toString();
		s+= " : "+this.getSuffix();
		return s;
	}
}