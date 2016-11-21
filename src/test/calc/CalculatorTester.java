package test.calc;

import org.junit.Test;
import static org.junit.Assert.*;
import calc.Calculator;

public class CalculatorTester {

	@Test
	public void addTest() {
		Calculator cal = new Calculator();
		String arg = "3,4,+";
		assertEquals(7.0, cal.calculate(arg), 0.0000001);
	}

	@Test
	public void invalidNumbers() {
		Calculator cal = new Calculator();
		String arg = "3,4,5,+";
		try {
			cal.calculate(arg);
			assertFalse(true);
		} catch (IllegalArgumentException e) {
			assertEquals("Given Input Malformed", e.getMessage());
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
}
