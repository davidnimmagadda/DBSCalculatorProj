package test.calc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import calc.Calculator;

public class CalculatorTester {

	@Test
	public void addTest() {
		Calculator cal = new Calculator();
		String arg = "3,4,+";
		assertEquals(7.0, cal.calculate(arg), 0.0000001);
	}

	@Test
	public void divideByZero() {
		Calculator cal = new Calculator();
		String arg = "3,0,/";
		Double res = cal.calculate(arg);
		assertFalse(!Double.isInfinite(res));
	}

	@Test
	public void binaryOpMisuse() {
		Calculator cal = new Calculator();
		String arg = "3,4,5,+";
		try {
			cal.calculate(arg);
			assertFalse(true);
		} catch (IllegalArgumentException e) {
			assertEquals("Stack Size not 2 for Binary Operator", e.getMessage());
		}

	}

	@Test
	public void unaryOpMisuse() {
		Calculator cal = new Calculator();
		String arg = "3,4,%";
		try {
			cal.calculate(arg);
			assertFalse(true);
		} catch (IllegalArgumentException e) {
			assertEquals("Stack Size not 1 for Unary Operator", e.getMessage());
		}
	}

	@Test
	public void invalidNumber() {
		invalidNumber("3fsh,4,+");
	}

	@Test
	public void invalidNumber_2() {
		invalidNumber(",4,+");
	}

	@Test
	public void invalidNumber_3() {
		invalidNumber(" ,4,+");
	}

	@Test
	public void emptyInput() {
		invalidNumber("");
	}

	public void invalidNumber(String arg) {
		Calculator cal = new Calculator();
		try {
			cal.calculate(arg);
			assertFalse(true);
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid Number", e.getMessage());
		}
	}

	@Test
	public void extraDigit() {
		Calculator cal = new Calculator();
		String arg = "3,4,+,9";
		try {
			cal.calculate(arg);
			assertFalse(true);
		} catch (IllegalArgumentException e) {
			assertEquals("Got Unused Numbers", e.getMessage());
		}
	}

	@Test
	public void nullInput() {
		Calculator cal = new Calculator();
		try {
			cal.calculate(null);
			assertFalse(true);
		} catch (IllegalArgumentException e) {
			assertEquals("Null Input", e.getMessage());
		}
	}

}