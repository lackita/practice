import java.util.*;

class RPN {
	public int calc(String expression) {
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
	abstract public int calculate(Stack<Token> operands);

	public boolean isOperator() {
		return true;
	}
}

class Addition extends Token {
	public int calculate(Stack<Token> operands) {
		return operands.pop().calculate(operands) + operands.pop().calculate(operands);
	}
}

class Subtraction extends Token {
	public int calculate(Stack<Token> operands) {
		Token first = operands.pop();
		Token second = operands.pop();
		return second.calculate(operands) - first.calculate(operands);
	}
}

class Multiplication extends Token {
	public int calculate(Stack<Token> operands) {
		return operands.pop().calculate(operands) * operands.pop().calculate(operands);
	}
}

class Division extends Token {
	public int calculate(Stack<Token> operands) {
		Token first = operands.pop();
		Token second = operands.pop();
		return second.calculate(operands) / first.calculate(operands);
	}
}

class Number extends Token {
	private String value;
	public Number(String value) {
		super();
		this.value = value;
	}

	public int calculate(Stack<Token> operands) {
		return Integer.parseInt(value);
	}

	public boolean isOperator() {
		return false;
	}
}
