import java.util.*;
import java.io.*;

class RPN {
	public static void main(String[] args) throws IOException {
		RPN rpn = new RPN();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			line = line.trim();
			double result = rpn.calc(line);
			System.out.println(Double.toString(result));
		}
	}

	public double calc(String expression) {
		Stack<Token> operands = operands(expression);
		return operands.pop().calculate(operands);
	}

	private Stack<Token> operands(String expression) {
		Stack<Token> operands = new Stack<Token>();

		for (String token : expression.split(" ")) {
			operands.push(build_token(token));
		}

		return operands;
	}

	public Token build_token(String descriptor) {
		Token t;
		switch (descriptor) {
		case "+": t = new Addition();
			break;
		case "-": t = new Subtraction();
			break;
		case "*": t = new Multiplication();
			break;
		case "/": t = new Division();
			break;
		default: t = new Number(descriptor);
			break;
		}
		return t;
	}
}

abstract class Token {
	abstract public double calculate(Stack<Token> operands);

	public boolean isOperator() {
		return false;
	}
}

abstract class Operator extends Token {
	public double calculate(Stack<Token> operands) {
		double second = operands.pop().calculate(operands);
		double first = operands.pop().calculate(operands);;
		return calculate(first, second);
	}

	abstract protected double calculate(double first, double second);

	public boolean isOperator() {
		return true;
	}
}

class Addition extends Operator {
	protected double calculate(double first, double second) {
		return first + second;
	}
}

class Subtraction extends Operator {
	protected double calculate(double first, double second) {
		return first - second;
	}
}

class Multiplication extends Operator {
	protected double calculate(double first, double second) {
		return first * second;
	}
}

class Division extends Operator {
	protected double calculate(double first, double second) {
		return first / second;
	}
}

class Number extends Token {
	private String value;
	public Number(String value) {
		super();
		this.value = value;
	}

	public double calculate(Stack<Token> operands) {
		return Double.parseDouble(value);
	}
}
