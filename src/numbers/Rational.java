package numbers;

import java.util.Scanner;

public class Rational extends Zahl {

	private int p;
	private int q;

	public Rational() {
		this.p = 1;
		this.q = 1;

	}

	public Rational(int z) {
		this.p = z;
		this.q = 1;
	}

	public Rational(int z, int n) {
		this.p = z;
		this.q = n;
		assert (n != 0);
		kuerzen();
	}

	public void print() {

		System.out.println(p + "/" + q);

	}
	
	public int zaehler(){
		return p;
	}
	public int nenner(){
		return q;
	}

	public void add(Zahl z) {
		// System.out.println(z.getClass());
		Rational r = (Rational) z;
		p = p * r.q + r.p * q;
		q = q * r.q;
		kuerzen();

	}

	public void add(int i) {
		Rational r = new Rational(i);
		add(r);
		kuerzen();
	}

	public void mul(Zahl z) {
		Rational r = (Rational) z;
		p = p * r.p;
		q = q * r.q;
		kuerzen();
	}

	public void mul(int i) {
		Rational r = new Rational(i);
		mul(r);
	}

	// Division durch Multiplikation mit dem Kehrwert
	public void div(Zahl z) {
		Rational r = (Rational) z;
		r.kehrwert();
		mul(r);
	}

	public void div(int i) {
		Rational r = new Rational(i);
		div(r);
	}

	// Die Subtraktion kann durch Addition des negativen Arguments erreicht
	// werden.
	public void sub(Zahl z) {
		Rational r = (Rational) z;
		r.p *= -1;
		add(r);
	}

	public void sub(int i) {
		Rational r = new Rational(i);
		sub(r);
	}

	public void kehrwert() {
		int temp = p;
		p = q;
		q = temp;
		assert (q != 0);
	}

	public void kuerzen() {
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

	}

	public double getDoubleWert() {
		return (double) p / (double) q;
	}

	private int ggt(int x, int y) {

		while (y > 0) {
			int rest = x % y;
			x = y;
			y = rest;
		}
		return x;
	}

	public Rational add(Rational a, Rational b) {

		a.add(b);
		return a;

	}

	public Rational sub(Rational a, Rational b) {

		a.sub(b);
		return a;

	}

	public Rational div(Rational a, Rational b) {

		a.div(b);
		return a;

	}

	public Rational mul(Rational a, Rational b) {

		a.mul(b);
		return a;

	}

	public void eingabe() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Geben Sie den Zähler ein:");
		int i = sc.nextInt();
		p = i;

		System.out.println("Geben Sie den Nenner ein:");
		i = sc.nextInt();
		q = i;

		sc.close();

		System.out.println("Ihre Eingabe:");
		kuerzen();
		print();

	}

}
