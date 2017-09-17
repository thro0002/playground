package numbers;

import static org.junit.Assert.*;

import org.junit.Test;

public class RationalTest {

	@Test
	public void testAdd() {
		Rational e = new Rational(1,2);
		assertEquals(1, e.zaehler());
		assertEquals(2, e.nenner());
		
		Rational f = new Rational(1,4);
		assertEquals(1, f.zaehler());
		assertEquals(4, f.nenner());
		
		f.add(e);
		assertEquals(3, f.zaehler());
		assertEquals(4, f.nenner());
	}
	@Test
	public void testAddInt() {
		Rational e = new Rational(1,2);
		assertEquals(1, e.zaehler());
		assertEquals(2, e.nenner());
		
		int i = 3;
		
		e.add(i);
		
		assertEquals(7, e.zaehler());
		assertEquals(2, e.nenner());
	}
	
	@Test
	public void testMulInt() {
		Rational e = new Rational(1,2);
		assertEquals(1, e.zaehler());
		assertEquals(2, e.nenner());
		
		int i = 3;
		
		e.mul(i);
		
		assertEquals(3, e.zaehler());
		assertEquals(2, e.nenner());
	}
	
	@Test
	public void testDivInt() {
		Rational e = new Rational(1,2);
		assertEquals(1, e.zaehler());
		assertEquals(2, e.nenner());
		
		int i = 3;
		
		e.div(i);
		
		assertEquals(1, e.zaehler());
		assertEquals(6, e.nenner());
	}
	
	@Test
	public void testSubInt() {
		Rational e = new Rational(1,2);
		assertEquals(1, e.zaehler());
		assertEquals(2, e.nenner());
		
		int i = 3;
		
		e.sub(i);
		
		assertEquals(-5, e.zaehler());
		assertEquals(2, e.nenner());
	}

	@Test
	public void testMul() {
		Rational e = new Rational(1,2);
		assertEquals(1, e.zaehler());
		assertEquals(2, e.nenner());
		
		Rational f = new Rational(3,4);
		assertEquals(3, f.zaehler());
		assertEquals(4, f.nenner());
		
		e.mul(f);
		
		assertEquals(3, e.zaehler());
		assertEquals(8, e.nenner());
	}
	
	@Test
	public void testDiv() {
		Rational e = new Rational(1,2);
		assertEquals(1, e.zaehler());
		assertEquals(2, e.nenner());
		
		Rational f = new Rational(3,4);
		assertEquals(3, f.zaehler());
		assertEquals(4, f.nenner());
		
		e.div(f);
		
		assertEquals(2, e.zaehler());
		assertEquals(3, e.nenner());
	}

	@Test
	public void testSub() {
		
		Rational e = new Rational(10,25);
		assertEquals(2, e.zaehler());
		assertEquals(5, e.nenner());
		
		Rational f = new Rational(13,16);
		assertEquals(13, f.zaehler());
		assertEquals(16, f.nenner());
		
		f.sub(e);
		
		assertEquals(33, f.zaehler());
		assertEquals(80, f.nenner());
	}

	@Test
	public void testKehrwert() {
		Rational e = new Rational(40,60);
		assertEquals(2, e.zaehler());
		assertEquals(3, e.nenner());
		
		e.kehrwert();
		
		assertEquals(3, e.zaehler());
		assertEquals(2, e.nenner());
		
	}

	@Test
	public void testKuerzen() {
		Rational e = new Rational(40,60);
		assertEquals(2, e.zaehler());
		assertEquals(3, e.nenner());
	}
	
	@Test
	public void testGetDouble() {
		Rational e = new Rational(1,2);
		assertEquals(0.5, e.getDoubleWert(), 0.00001);
		
	}

}
