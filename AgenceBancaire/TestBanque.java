import java.util.ArrayList;
import java.util.HashMap;
//import java.util.ListIterator;

/**
 *  utilisation de classes existantes : pour le Tp5 sur les listes
 *  @author Françoise GAYRAL
 */

public class TestBanque
{
  public static void main(String[] args)	{
	CompteBancaire cb1,cb2,cb3,cb4;
	AgenceBancaire ab;
	cb1=new CompteBancaire("gayral",3000f,"765TR");
	cb3=new CompteBancaire("toto", 100f,"123456F");
	cb2=new CompteBancaire("toto", 80f,"182G");
	cb4=new CompteBancaire("tyty", 1200f,"182G");
	HashMap<String,CompteBancaire> comptes = new HashMap<String,CompteBancaire>();

	//TP 8
	ab = new AgenceBancaire("BNP", "Villetaneuse");
	if (ab.ajoute(cb1))
		System.out.println("On a pu ajouté cb1");
	if (ab.ajoute(cb2))
		System.out.println("On a pu ajouté cb2");
	if (ab.ajoute(cb3))
		System.out.println("On a pu ajouté cb3");
	System.out.println(ab);
	ab.ajoute(cb1);
	System.out.println(ab);

	//test de la méthode compteExiste

	if (ab.compteExiste(cb1))
		System.out.println("Le compte cb1 existe");
	else
		System.out.println("Le compte cb1 n'existe pas");

	//test de la méthode comptePersonneExiste

	if (ab.comptePersonneExiste("toto"))
		System.out.println("Le client toto possède au moins un compte dans cette agence");
	else
		System.out.println("Cette personne ne possède pas de compte dans cette agence.");

	//test de la méthode compteNumeroExiste

	if (ab.compteNumeroExiste("765TR"))
		System.out.println("Le numero 765TR existe dans cette agence");
	else
		System.out.println("Cette personne ne possède pas de compte dans cette agence.");

	//test de la méthode lesComptesDe
		System.out.println(ab.lesComptesDe("toto"));
		System.out.println(ab.lesComptesDe("coucou"));

	// test de la méthode mesClients
		System.out.println(ab.mesClients());

	// test de la méthode retireCompteDe
		if (ab.retireComptesDe("gayral"))
			System.out.println(ab);
		ab.ajoute(cb1);
		System.out.println(ab);


	//Question c
	/*
	for (CompteBancaire cb : comptes) {
		if(cb.getNom().equals("toto"))
			System.out.println(cb);
	}
	*/
	// Question d
	/*
	for (CompteBancaire cb : comptes) {
		if(cb.getNom().equals("toto"))
			System.out.println(cb.getSolde());
	}
	*/
	// Question e
	/*
	comptes.remove(cb1);
	System.out.println(comptes);
	*/
	// Question f
	/*
	ListIterator<CompteBancaire> ite = comptes.listIterator();
	while(ite.hasNext())
	{
		CompteBancaire cb = ite.next();
		if (cb.getNom().equals("toto"))
			ite.remove();
	}
	System.out.println(comptes);
	*/

   }	// fin du main
}// fin de la classe TestUtilisationClasses
