package calc;

import java.util.Stack;

public class Calculator {

	public Double calculate(String arg) {
		if (arg == null)
			throw new IllegalArgumentException("Null Input");

		String[] vals = arg.split(",");
		Stack<Double> stack = new Stack<>();
		for (int i = 0; i < vals.length; i++)
			calculationStrategy(vals[i], stack);

		return checkOut(stack);
	}

	private Double checkOut(Stack<Double> stack) {
		if (stack.size() == 1)
			return stack.pop();
		else
			throw new IllegalArgumentException("Got Unused Numbers");
	}

	private void calculationStrategy(String op, Stack<Double> stack) {
		if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/"))
			calculateBinary(op, stack);
		else if (op.equals("%"))
			calculateUnary(op, stack);
		else
			addNumber(op, stack);
	}

	private void calculateBinary(String op, Stack<Double> stack) {
		if (stack.size() != 2)
			throw new IllegalArgumentException("Stack Size not 2 for Binary Operator");
		else {
			Double b = stack.pop();
			Double a = stack.pop();
			if (op.equals("+"))
				stack.push(a + b);
			else if (op.equals("-"))
				stack.push(a - b);
			else if (op.equals("*"))
				stack.push(a * b);
			else
				stack.push(a / b);
		}
	}

	private void calculateUnary(String op, Stack<Double> stack) {
		if (stack.size() != 1)
			throw new IllegalArgumentException("Stack Size not 1 for Unary Operator");
		else {
			Double a = stack.pop();
			if (op.equals("%"))
				stack.push(a / 100);
		}
	}

	private void addNumber(String op, Stack<Double> stack) {
		try {
			stack.push(Double.parseDouble(op));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Invalid Number");
		}
	}

}