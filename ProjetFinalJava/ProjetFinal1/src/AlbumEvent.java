import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * Classe de AlbumEvent 
 * @author Nathalie QUERE
 */
public class AlbumEvent {
	/**
	 * Variables d'instance : event et liste des photos
	 */
	private Evenement event;
	private ArrayList<PhotoEvent> photos;

	/**
	 * Méthode de classe : Chargement d'un album photo événement à partie d'un fichier
	 * @param name : le nom du fichier à lire / file name to read
	 * @return l'album événement chargé
	 */
	public static AlbumEvent charge(String name) {
		BufferedReader bIn = null;
		AlbumEvent ae = null;
		Evenement ev = null;
		Personne p = null;
		File f = null;
		PhotoEvent pe = null;
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
			if (liste.get(0).equals("Evenement:")) {
				try {
				ev = new Evenement(liste.get(1));
				System.out.println("\nCréation d'un événement : "+ev.getNom());
				}
				catch (NotExistException e) {
					System.out.println(e+"\n");
				}
			}
				else if (liste.get(0).equals("AlbumEvent:")) {
				ae = new AlbumEvent(ev);
				System.out.println("\nCréation d'un album photo événement : "+ae.getEvent().getNom());
				}
				else {
					p = new Personne(liste.get(0),liste.get(1));
					ev.ajoutePersonne(p);
					System.out.println("Ajout d'une personne "+p.getNom()+" ,Adresse mail de la personne : "+p.getMail());
				}
			}
			else if (st.countTokens() == 1){
				String s = st.nextToken();
				try {
					f = new File(s);
					try {
						pe = new PhotoEvent(s, ev);
						ae.ajoute(pe);
						System.out.println("Ajout de la photo événement : "+pe.getNom()+" à l'album photo événement: "+ae.getEvent().getNom());
						}
						catch (BadEventException e) {
							System.out.println(e+"\n");
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
		return ae;
	}

	/**
	 * Constructeur de la classe
	 * @param event : l'événement de l'album
	 */
	public AlbumEvent(Evenement event) {
		this.event = event;
		this.photos = new ArrayList<PhotoEvent>();
	}

	/**
	 * Accesseur de la variable event
	 * @return l'événement de l'album
	 */
	public Evenement getEvent() {
		return this.event;
	}

	/**
	 * Accesseur de la variable photos
	 * @return la liste des photos
	 */
	public ArrayList<PhotoEvent> getPhotos() {
		return this.photos;
	}

	/**
	 * Méthode d'ajout des photos dans l'album
	 * @param p : la photo à ajouter
	 */
	public boolean ajoute(PhotoEvent p){
		for(PhotoEvent f:this.getPhotos()){
			if(f.equals(p)) return false;
		}
		return this.getPhotos().add(p);
	}
	/**
	 * Méthode toString de la classe AlbumEvent
	 */
	public String toString() {
		String s = "Nom de l'album photo événement : " + this.getEvent().getNom()+"\n";
		for (PhotoEvent pe : this.getPhotos()) {
			s += pe;
		}
		return s;
	}
}