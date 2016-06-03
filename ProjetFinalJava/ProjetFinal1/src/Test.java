import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * 	Classe de Test
 *	@author Nathalie QUERE
 */

public class Test {
	public static void main(String[] args) {
		AlbumPhoto ap;
		AlbumEvent ae;
		AlbumEvent ae1;
		Application appli = new Application();
		ap = AlbumPhoto.charge("Planetes.albumphoto.txt");
		ae = AlbumEvent.charge("cremaillere.albumevent.txt");
		ae1 = AlbumEvent.charge("mariageToto.albumevent.txt");
		appli.ajouteAlbumPhoto(ap);
	   	appli.ajouteAlbumEvent(ae);
		appli.ajouteAlbumEvent(ae1);
		System.out.println(appli);
	}
}
