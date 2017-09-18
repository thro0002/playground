package example;

import numbers.Rational;


/**
 * Testklasse zur Demonstration der Anwendung der Methoden der Klasse Rational.
 * 
 * Beispiele für Instanziierung und Anwenden der Grundrechenarten.
 *
 * $Author: roth $ $Revision: #1 $ $Date: 2017/09/18 $
 */

public class App {

	public static void main(String[] args) {
		
		Rational r = new Rational(1,5);
		r.print();
		
		Rational a = new Rational(2,4);
		a.print();
		
		System.out.println("MUL:");
		
		a.mul(r);
		a.print();
		
		Rational b = new Rational(3,7);
		r.print();
		
		Rational c = new Rational(2,6);
		c.print();
		
		System.out.println("ADD:");
		
		c.add(b);
		
		b.print();
		c.print();
		
		System.out.println("Kehrwert c");
		
		c.kehrwert();
		c.print();
		
		System.out.println("SUB:");
		
		Rational e = new Rational(10,25);
		e.print();
		
		Rational f = new Rational(13,16);
		f.print();
		
		f.sub(e);
		
		f.print();
		
		System.out.println("ADD2:");
		
		Rational z = new Rational(10,25);
		z.print();
		
		Rational x = new Rational(13,16);
		x.print();
		
		Rational y;
		
		y = z.add(z,x);
		
		y.print();
		
	}

}
