package numbers;

/**
 * Rationale Zahlen.
 * 
 * Abstrakte Klasse mit zu implementierenden Methoden für die Grundrechenarten sowie der Ausgabe.
 *
 * $Author: roth $ $Revision: #1 $ $Date: 2017/09/18 $
 */
public abstract class Zahl {
	
	
	 //Jede Zahl sollte mit den 4 Grundrechenarten bearbeitet werden können.	
	 public abstract void add(Zahl a);
	 
	 public abstract void sub(Zahl z);
	 
	 public abstract void mul(Zahl z);
	 
	 public abstract void div(Zahl z);	 
	 
	 //Anzeigen der Zahl sollte auch möglich sein.
	 public abstract void print();

	
	
}
