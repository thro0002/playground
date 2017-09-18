package numbers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Rationale Zahlen.
 * 
 * Eine rationale Zahl lässt sich als Bruch darstellen mit ganzen Zahlen sowohl
 * im Zähler als auch im Nenner.
 * 
 * \image html bruch.jpg "Rationale Zahlen"
 *
 * $Author: roth $ $Revision: #1 $ $Date: 2017/09/18 $
 */

public class Rational extends Zahl {

	private int p;
	private int q;
	private static final Logger log = LogManager.getLogger();

	/**
	 * Rationale Zahl mit Wert 1 für Zähler und Nenner.
	 */
	public Rational() {
		if(log.isTraceEnabled()) {
			log.trace("** Rational()");
		}
		this.p = 1;
		this.q = 1;
	}

	/**
	 * Rationale Zahl mit Wert 1 für Nenner. Der Wert für den Zähler wird
	 * übergeben.
	 * 
	 * \param[in] z Wert für Zähler
	 */
	public Rational(int z) {
		if(log.isTraceEnabled()) {
			log.trace("** Rational(int) value:" + z);
		}
		this.p = z;
		this.q = 1;
	}

	/**
	 * Rationale Zahl mit Zähler und Nenner. Der Bruch wird gekürzt.
	 * 
	 * \param[in] z Wert für Zähler
	 * \param[in] n Wert für Nenner
	 */
	public Rational(int z, int n) {
		if(log.isTraceEnabled()) {
			log.trace("** Rational(int, int) values:"+ z + " " + n);
		}
		this.p = z;
		this.q = n;
		assert (n != 0);
		kuerzen();
	}

	/**
	 * Methode zur Ausgabe des Bruchs.
	 */
	public void print() {
		if(log.isTraceEnabled()) {
			log.info(">> print()");
		}
		System.out.println(p + "/" + q);
		if(log.isTraceEnabled()) {
			log.info("<< print()");
		}
	}

	/**
	 * Getter für Zähler.
	 * 
	 * \return Wert der Zählervariable als integer
	 */
	public int zaehler() {
		return p;
	}

	/**
	 * Getter für Nenner.
	 * 
	 * \return Wert der Nennervariable als integer
	 */
	public int nenner() {
		return q;
	}

	/**
	 * Methode zur Addition einer rationalen Zahl zu einer bestehenden.
	 * 
	 * \param[in] z rationale Zahl für den zweiten Summanden
	 */
	public void add(Zahl z) {
		// System.out.println(z.getClass());
		Rational r = (Rational) z;
		p = p * r.q + r.p * q;
		q = q * r.q;
		kuerzen();
	}

	/**
	 * Methode zur Addition eines Integers zu einer rationalen Zahl.
	 * 
	 * \param[in] i Zahl als Integer für den zweiten Summanden
	 */
	public void add(int i) {
		Rational r = new Rational(i);
		add(r);
		kuerzen();
	}

	/**
	 * Methode zur Multiplikation einer rationalen Zahl mit einer anderen.
	 * 
	 * \param[in] z rationale Zahl für den zweiten Faktor
	 */
	public void mul(Zahl z) {
		Rational r = (Rational) z;
		p = p * r.p;
		q = q * r.q;
		kuerzen();
	}

	/**
	 * Methode zur Multiplikation einer rationalen Zahl und eines Integers.
	 * 
	 * \param[in] i integer für den zweiten Faktor.
	 */
	public void mul(int i) {
		Rational r = new Rational(i);
		mul(r);
	}

	/**
	 * Methode zur Division einer rationalen Zahl mit einer zweiten. 
	 * 
	 * Division erfolgt durch Multiplikation mit dem Kehrwert.
	 * \param[in] z rationale Zahl für den Divisor.
	 */
	public void div(Zahl z) {
		Rational r = (Rational) z;
		r.kehrwert();
		mul(r);
	}

	/**
	 * Methode zur Division einer rationalen Zahl und eines Integers. 
	 * 
	 * \param[in] i Integer für den Divisor.
	 */
	public void div(int i) {
		Rational r = new Rational(i);
		div(r);
	}

	/**
	 * Methode zur Subtraktion zweier rationalen Zahlen. 
	 * 
	 * Die Subtraktion kann durch Addition des negativen Arguments erreicht werden.
	 * \param[in] z rationale Zahl für den Subtrahenden.
	 */ 
	public void sub(Zahl z) {
		Rational r = (Rational) z;
		r.p *= -1;
		add(r);
	}

	/**
	 * Methode zur Subtraktion eines Integers von einer rationalen Zahl. 
	 * 
	 * \param[in] i Integer für den Subtrahenden.
	 */ 
	public void sub(int i) {
		Rational r = new Rational(i);
		sub(r);
	}

	/**
	 * Methode zur Ermittlung des Kehrwerts. 
	 * 
	 * Zähler und Nenner werden getauscht.
	 */ 
	public void kehrwert() {
		int temp = p;
		p = q;
		q = temp;
		assert (q != 0);
	}

	
	/**
	 * Methode zum Kürzen eines Bruchs. 
	 * 
	 */ 
	public void kuerzen() {
		if(log.isInfoEnabled()) {
			log.info(">> kuerzen()");
		}
		// Vorzeichen merken und Betrag bilden
		int sign = 1;
		if (p < 0) {
			sign = -sign;
			p = -p;
		}
		if (q < 0) {
			sign = -sign;
			q = -q;
		}

		int teiler = ggt(p, q);

		// Vorzeichen restaurieren
		p = sign * p / teiler;
		q = q / teiler;
		
		if(log.isInfoEnabled()) {
			log.info("<< kuerzen()");
		}

	}

	/**
	 * Methode zur Darstellung als Dezimalzahl. 
	 * 
	 *\return Darstellung des Bruchs als double.
	 */ 
	public double getDoubleWert() {
		return (double) p / (double) q;
	}
	
	/**
	 * Methode zur Ermittlung des größten gemeinsamen Teilers. 
	 * 
	 *\return GGT als integer.
	 */ 
	private int ggt(int x, int y) {
		if(log.isDebugEnabled()) {
			log.debug(">> ggt: x=" + x +", y="+ y);
		}
		while (y > 0) {
			int rest = x % y;
			x = y;
			y = rest;
		}
		if(log.isDebugEnabled()) {
			log.debug("<< ggt, return " + x);
		}
		return x;
	}

	/**
	 * Methode zur Addition zweier rationaler Zahlen.
	 * 
	 * \param[in] a rationale Zahl für den ersten Summanden
	 * \param[in] b rationale Zahl für den zweiten Summanden
	 * \return Rational Summe
	 */
	public Rational add(Rational a, Rational b) {
		a.add(b);
		return a;
	}

	/**
	 * Methode zur Subtraktion zweier rationaler Zahlen.
	 * 
	 * \param[in] a rationale Zahl für den Minuenden
	 * \param[in] b rationale Zahl für den Subtrahenden
	 * \return Rational Differenz
	 */
	public Rational sub(Rational a, Rational b) {
		a.sub(b);
		return a;
	}

	/**
	 * Methode zur Division zweier rationaler Zahlen.
	 * 
	 * \param[in] a rationale Zahl für den Dividenden
	 * \param[in] b rationale Zahl für den Divisor
	 * \return Rational Quotient
	 */
	public Rational div(Rational a, Rational b) {
		a.div(b);
		return a;
	}

	/**
	 * Methode zur Multiplikation zweier rationaler Zahlen.
	 * 
	 * \param[in] a rationale Zahl für den Multiplikator
	 * \param[in] b rationale Zahl für den Multiplikanden
	 * \return Rational Produkt
	 */
	public Rational mul(Rational a, Rational b) {
		a.mul(b);
		return a;
	}

	/**
	 * \mainpage Rationale Zahlen - Klassen
	 * 
	 * \image html bruch.jpg "Das Projekt-Logo"
	 * 
	 * Dies ist die Hauptseite der mit Doxygen erzeugten HTML-Dokumentation.
	 * 
	 * Dieser Text befindet sich in der Datei Rational.java.
	 */

	/**
	 * \example App.java
	 *
	 * Dieses Beispiel demonstriert die Instanziierung von Objekten der Klasse
	 * Rational und der Anwendung der Operationen für die Grundrechenarten.
	 * 
	 */

}
