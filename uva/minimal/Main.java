import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		SequenceLength sl = new SequenceLength();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			int max_cycle = sl.maximumCycleLength(line);
			System.out.println(line + " " + Integer.toString(max_cycle));
		}
	}
}

class SequenceLength {
	public static void main(String args[]) {
	}

	public int maximumCycleLength(String range) {
		int maximum_length = 0;
		for (int sequence_start : rangeFor(range)) {
		}
		
		return maximum_length;
	}

	private int[] rangeFor(String range_descriptor) {
		String[] range_values = range_descriptor.split(" ");
		int i = Integer.parseInt(range_values[0]);
		int j = Integer.parseInt(range_values[1]);
		if (j < i) {
			int tempj = j;
			j = i;
			i = tempj;
		}
		int[] range = new int[j - i + 1];
		return new int[0];
	}
}
