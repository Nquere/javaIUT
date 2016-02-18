import java.util.*;
public class TestArguments {
	public static void main(String[] args) {
	// 	if (args.length == 2) {
	// 		System.out.println(args[0]);
	// 		System.out.println(args[1]);
	// 	}
	// 	else
	// 		System.out.println("Aucun arguments passés en paramètres");
	// }

		// Question 1

		// int x;
		// int somme = 0;
		// int moyenne = 0;
		// for (String s : args) {
		// 	x = Integer.parseInt(s);
		// 	somme += x; 
		// }
		// moyenne = somme / args.length;
		// System.out.print("La moyenne des paramètres est :");
		// System.out.println(moyenne);

		// Question 2

		if (args.length == 2) {
			CompteBancaire cb8 = new CompteBancaire(args[0], args[1]);
			System.out.println(cb8);
		}
		else
			System.out.println("Le nombre de paramètres doit être de 2.");
	}
 }