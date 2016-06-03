/**
 * Classe de PhotoEvent héritant de la classe Photo
 * @author Nathalie QUERE
 *
 */
public class PhotoEvent extends Photo {
	
	/**
	 * Variable d'instance event : événement associé à la photo
	 */
	private Evenement event;

	/**
	 * Constructeur de la classe PhotoEvent
	 * @param path : chemin de la photo
	 * @param event : événement associé à la photo
	 * @throws NotExistException
	 * @throws NoFileException
	 * @throws BadFormatException
	 * @throws BadEventException
	 */
	public PhotoEvent(String path, Evenement event) 
		throws NotExistException, NoFileException, BadFormatException, BadEventException {
		super(path);
		if (!(super.getParent().equals(event.getNom()))) 
			throw new BadEventException("L'événement ne correspond pas", event, path);
		this.event = event;
	}

	/**
	 * Accesseur de l'événement
	 * @return l'événement de la photo
	 */
	public Evenement getEvent() {
		return this.event;
	}

	/**
	 * Méthode equals de la classe PhotoEvent
	 */
	public boolean equals(Object o) {
		if (!(o instanceof PhotoEvent)) return false;
		if (!super.equals(o)) return false;
		PhotoEvent pe = (PhotoEvent) o;
		return (this.getEvent().equals(pe));
	}

	/**
	 * Méthode toString de la classe PhotoEvent
	 */
	public String toString() {
		String s = super.toString();
		s+= "Evenement de la photo : "+this.getEvent().getNom()+"\n";
		return s;
	}
}