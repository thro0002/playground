package numbers;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Anwendungsklasse mit Benutzereingabe und anschließender Ausgabe des gekürzten Bruchs.
 *
 * $Author: roth $ $Revision: #1 $ $Date: 2017/09/18 $
 */


public class NextApp {

	static final Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		int p=0;
		int q=0;
		int i=0;
		Scanner sc = new Scanner(System.in);
		
		if(log.isInfoEnabled()) {
			log.info(">> main Start Hauptprogramm");
		}
		//log.trace("Soll nicht erscheinen");
		
		System.out.println("Geben Sie den Zähler ein:");
		try {
			//assert (sc.hasNextInt()) : "Bitte Integerwert für Zähler eingeben";
			i = sc.nextInt();
			p = i;
		} catch (Exception e) {
			if(log.isErrorEnabled()) {
				log.error("-- main Falsche Eingabe für Zaehler (ganze Zahl)");
				sc.close();
				return;
			}
		}
		

		System.out.println("Geben Sie den Nenner ein:");
		try {
		//assert (sc.hasNextInt()) : "Bitte Integerwert für Nenner eingeben";
			i = sc.nextInt();
			//assert (i != 0) : "Nenner darf nicht null sein";
			q = i;
		} catch(Exception e) {
			if(log.isErrorEnabled()) {
				log.error("-- main Falsche Eingabe für Nenner (ganze Zahl ungleich 0");
				sc.close();
				return;
			}
		}
		

		sc.close();

		System.out.println("Ihre Eingabe:");
		
		Rational r = new Rational(p, q);
		r.kuerzen();
		r.print();
		
		if(log.isInfoEnabled()) {
			log.info("<< Ende Hauptprogramm");
		}
	}
}
