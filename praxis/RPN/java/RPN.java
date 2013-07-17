class RPN {
	public int calc(String expression) {
		String[] tokens = expression.split(" ");
		if (tokens.length == 1) {
			return Integer.parseInt(tokens[0]);
		}
		return Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[1]);
	}
}
