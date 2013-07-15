class BinaryCode {
	public static String[] decode(String message) {
		BinaryCode bc = new BinaryCode(message);
		return new String[]{bc.decodeStartingWith(0), bc.decodeStartingWith(1)};
	}

	private String message;
	public BinaryCode(String message) {
		this.message = message;
	}

	public String decodeStartingWith(int startingDigit) {
		String decodedMessage = Integer.toString(startingDigit);
		int lastValue = startingDigit;
		for (int i = 0;i < message.length();++i) {
			int digit = message.charAt(i) - '0';
			int newValue = digit - lastValue;
			if (newValue < 0) {
				return "NONE";
			}
			else {
				lastValue = startingDigit;
				decodedMessage += Integer.toString(lastValue);
			}
		}

		if (decodedMessage.charAt(decodedMessage.length() - 1) != '0') {
			return "NONE";
		}

		return decodedMessage.substring(0, decodedMessage.length() - 1);
	}
}
