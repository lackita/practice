import java.util.*;

class RPN {
	public int calc(String expression) {
		Queue<String> tokens = tokens(expression);
		if (tokens.size() == 1) {
			return Integer.parseInt(tokens.poll());
		}

		int first = Integer.parseInt(tokens.poll());
		int second = Integer.parseInt(tokens.poll());
		String operator = tokens.poll();

		Token operator_token = Token.build(operator);
		if (operator.equals("+")) {
			return first + second;
		}
		else if (operator.equals("-")) {
			return first - second;
		}
		return 0;
	}

	private Queue<String> tokens(String expression) {
		Queue<String> tokens = new ArrayDeque<String>();

		for (String token : expression.split(" ")) {
			tokens.add(token);
		}

		return tokens;
	}
}

class Token {
	public static Token build(String descriptor) {
		return new Token(descriptor);
	}

	private String descriptor;
	public Token(String descriptor) {
		this.descriptor = descriptor;
	}

	public int calculate(int first, int second) {
		if (descriptor.equals("+")) {
			return first + second;
		}
		else if (descriptor.equals("-")) {
			return first - second;
		}
		return 0;
	}
}
