package calc;

import java.util.Stack;

public class Calculator {

	public Double calculate(String arg) {
		String[] vals = arg.split(",");
		Stack<Double> stack = new Stack<>();
		for (int i = 0; i < vals.length; i++) {
			switch (vals[i]) {
			case "+": {
				if (stack.size() != 2)
					throw new IllegalArgumentException("Given Input Malformed");
				else {
					Double b = stack.pop();
					Double a = stack.pop();
					stack.push(a + b);
				}
				break;
			}

			case "-": {
				if (stack.size() != 2)
					throw new IllegalArgumentException("Given Input Malformed");
				else {
					Double b = stack.pop();
					Double a = stack.pop();
					stack.push(a - b);
				}
				break;
			}
			case "/": {
				if (stack.size() != 2)
					throw new IllegalArgumentException("Given Input Malformed");
				else {
					Double b = stack.pop();
					Double a = stack.pop();
					stack.push(a / b);
				}
				break;
			}
			case "*": {
				if (stack.size() != 2)
					throw new IllegalArgumentException("Given Input Malformed");
				else {
					Double b = stack.pop();
					Double a = stack.pop();
					stack.push(a * b);
				}
				break;
			}

			default: {
				try {
					stack.push(Double.parseDouble(vals[i]));
				} catch (NumberFormatException e) {
					throw new IllegalArgumentException("Invalid Number");
				}
				break;
			}
			}
		}

		if (stack.size() == 1)
			return stack.pop();
		else
			throw new IllegalArgumentException("Got Unused Numbers");
	}

}
