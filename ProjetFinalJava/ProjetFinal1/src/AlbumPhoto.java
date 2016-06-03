import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * Classe de AlbumPhoto
 * @author Nathalie QUERE 
 *
 */
public class AlbumPhoto {
	/**
	 * Variables d'instances
	 */
	private String nom;
	private ArrayList<Photo>photos;
	

	/**
	 * Méthode de classe : Chargement d'un album photo à partir d'un fichier.
	 * @param name : le nom du fichier / name of file to read
	 * @return l'album photo chargé
	 */
public static AlbumPhoto charge(String name) {
	BufferedReader bIn = null;
	AlbumPhoto ap = null;
	File f = null;
	Photo ph = null;
	try {
	File inputFile = new File(name);
	bIn = new BufferedReader(new FileReader(inputFile));
	String ligne = bIn.readLine();
	
	while (ligne != null)	{
		StringTokenizer st = new StringTokenizer(ligne, " ");
		ArrayList<String> liste = new ArrayList<String>();
		
		if (st.countTokens() == 2) {
			while (st.hasMoreTokens())	{
				liste.add(st.nextToken());
			}
			if (liste.get(0).equals("Album:")) {
				try {
				ap = new AlbumPhoto(liste.get(1));
				System.out.println("Création d'un album photo : "+ap.getNom());
				}
				catch (NotExistException e) {
					System.out.println(e+"\n");
				}
				catch (NoFileException e) {
					System.out.println(e+"\n");
				}
				catch (BadFormatException e) {
					System.out.println(e+"\n");
				}
			}
		}
		else if (st.countTokens() == 1){
			String s = st.nextToken();
			try {
				f = new File(s);
					try {
						ph = new Photo(s);
						ap.ajoute(ph);
						System.out.println("Ajout de la photo : "+ph.getNom()+" à l'album photo : "+ap.getNom());
					}
					catch (NotExistException e) {
						System.out.println(e+"\n");
					}
					catch (NoFileException e) {
						System.out.println(e+"\n");
					}
					catch (BadFormatException e) {
						System.out.println(e+"\n");
					}
			}
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Il manque le fichier en paramètre.\n");
			}
			catch (Exception e) {
				System.out.println(e+"\n");
			}
		}
		ligne = bIn.readLine();
	}
	if (bIn != null) {
		try {
			bIn.close();
		}
		catch(IOException ec) { 
			System.out.println(ec);
        }
	}
	
	}
	catch (FileNotFoundException e) {
		System.out.println(e);
	}
	catch (IOException e) {
		System.out.println(e);
	}
	return ap;
}

/**
 *Constructeur d'un AlbumPhoto
 *qui prend le nom
 *et une liste de photo 
 *throws Exception
 */
	
public AlbumPhoto(String nom) throws  NotExistException, NoFileException, BadFormatException {
		File f = new File("images");
		if(!(f.exists())) throw new NotExistException("le fichier suivant est incorrect", nom);
		this.nom = nom;
		this.photos = new ArrayList<Photo>();
}

/**
 * la methode toString()
 * qui retourne une chaine 
  */

public String toString(){
	String s;
	s= "\nNom de l'album : "+this.getNom();
	s+= "\nPhotos de l'album photo :\n";
	for (Photo p : this.getPhotos()) {
		s += p;
	}
	return s;			
}

/**
 *Accesseurs au nom 
 *@return nom:nom AlbumPhoto
 */
 
public String getNom(){
	return this.nom;
}


/**
 * Accesseur de la liste de photos
 * @return photos : liste des photos de l'album
 */
public ArrayList<Photo> getPhotos() {
	return this.photos;
}

/**
 * la methode ajoute()
 * qui permet d'ajouter
 * une photo a un album
 */
public boolean ajoute(Photo p){
	for(Photo f:this.photos) {
			if(f.equals(p)) return false;
	}
	return this.photos.add(p);
 }

/**
 * Méthode equals vérifie si un Albumphoto est égal à un autre
 */
public boolean equals(Object o){
	if (!(o instanceof AlbumPhoto))
		return false;
	AlbumPhoto ap = (AlbumPhoto) o;

	if(this.nom.equals(ap.getNom()))
		return true;
	else
		return false;
	
}


}//fin class
	

 