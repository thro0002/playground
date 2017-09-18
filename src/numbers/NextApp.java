package numbers;

import java.util.Scanner;


/**
 * Anwendungsklasse mit Benutzereingabe und anschließender Ausgabe des gekürzten Bruchs.
 *
 * $Author: roth $ $Revision: #1 $ $Date: 2017/09/18 $
 */


public class NextApp {

	public static void main(String[] args) {
		int p=0;
		int q=0;
		int i=0;
		Scanner sc = new Scanner(System.in);

		System.out.println("Geben Sie den Zähler ein:");
		assert (sc.hasNextInt()) : "Bitte Integerwert für Zähler eingeben";
		i = sc.nextInt();
		p = i;

		System.out.println("Geben Sie den Nenner ein:");
		assert (sc.hasNextInt()) : "Bitte Integerwert für Nenner eingeben";
		i = sc.nextInt();
		assert (i != 0) : "Nenner darf nicht null sein";
		q = i;
		

		sc.close();

		System.out.println("Ihre Eingabe:");
		
		Rational r = new Rational(p, q);
		r.kuerzen();
		r.print();
	}
}
