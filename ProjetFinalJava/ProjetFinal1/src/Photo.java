import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * Classe de Photo
 * @author Nathalie QUERE
 *
 */
public class Photo extends File{
	
	/**
	 * Constante de classe FORMAT contenant les différents formats possibles pour les photos
	 */
	public static final String[] FORMAT = {"gif","jpeg","png","jpg"};
	
	/**
	 * Variables d'instances : name et date
	 */
	private String nom;
	private GregorianCalendar date;
	
	/**
	 * Constructeur de Photo
	 * @param path
	 * @throws NotExistException, NoFileException, BadFormatException
	 */
	public Photo(String path) throws NotExistException, NoFileException, BadFormatException {
		super(path);
		String name = super.getName();
		int pos = name.lastIndexOf(".");
		int len = name.length();
		if (pos > 0) this.nom = name.substring(0, pos);
		int i = 0;
		String suffix = name.substring(pos+1, len);
		boolean okay = false;
		while (okay == false && i<FORMAT.length) {
			if (!suffix.equals(FORMAT[i]) )
				i++;
			else
				okay = true;
		}
		if (i == FORMAT.length) throw new BadFormatException("Le format suivant n'est pas accepté",suffix);
		if (!(super.exists())) throw new NotExistException("Le fichier suivant est incorrect", path);
		if (!(super.isFile())) throw new NoFileException("Il ne s'agit pas d'un fichier", path);
		
		this.date = new GregorianCalendar();
		this.date.setTimeInMillis(super.lastModified());
	}
	
	/**
	 * Accesseurs de nom
	 * @return nom : le nom de la photo
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * Accesseur de date
	 * @return date : la date de la photo
	 */
	public GregorianCalendar getDate() {
		return this.date;
	}
	
	/**
	 * Méthode toString 
	 * @return s : une chaine de caractère contenant les caractéristiques de la photo
	 */
	public String toString() {
		SimpleDateFormat  simpleFormat = new SimpleDateFormat("dd/MM/yyyy");
		String s = "Nom de la photo : ";
		s += this.getNom()+"\nDate de la photo : "+ simpleFormat.format(this.getDate().getTime())+"\n";
		return s;
	}
	
	/**
	 * Méthode equals pour la classe Photo 
	 * @return true si les deux photos sont identiques sinon false
	 */
	public boolean equals(Object o) {
		if (!(o instanceof Photo)) return false;
		if (!(super.equals(o))) return false;
		Photo ph = (Photo) o;
		return (this.getNom().equals(ph.getNom()) && this.getDate().equals(ph.getDate()));
	}
}