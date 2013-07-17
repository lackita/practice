import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		SequenceLength sl = new SequenceLength();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			int max_cycle = sl.maximumCycleLength(line.trim());
			System.out.println(line.trim() + " " + Integer.toString(max_cycle));
		}
	}
}

class SequenceLength {
	public static void main(String args[]) {
	}
	
	private Hashtable<Integer, Integer> memoized_cycle_lengths;
	public SequenceLength() {
		memoized_cycle_lengths = new Hashtable<Integer, Integer>();
	}
	
	public int maximumCycleLength(String range) {
		int maximum_length = 0;
		for (int sequence_start : rangeFor(range)) {
			if (cycleLength(sequence_start) > maximum_length) {
				maximum_length = cycleLength(sequence_start);
			}
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
		
		for (int current = i;current <= j;++current) {
			range[current - i] = current;
		}
		
		return range;
	}
	
	private int cycleLength(int current_value) {
		int return_value;
		
		if (memoized_cycle_lengths.containsKey(current_value))
			return_value = memoized_cycle_lengths.get(current_value);
		else if (current_value <= 1)
			return_value = 1;
		else if (current_value % 2 == 1)
			return_value = 1 + cycleLength(3*current_value + 1);
		else
			return_value = 1 + cycleLength(current_value / 2);

		memoized_cycle_lengths.put(current_value, return_value);
		return return_value;
	}
}
