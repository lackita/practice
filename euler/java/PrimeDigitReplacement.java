import java.util.*;

public class PrimeDigitReplacement {
	public int firstPrimeInClassSize(int number_of_primes) {
		boolean found_correct_class = false;
		PrimeIterator primes = new PrimeIterator();
		while (primes.hasNext()) {
			for (MathSet family : allFamiliesFor(primes.next())) {
				if (family.size() == number_of_primes)
					return primes.current();
			}
		}

		return -1;
	}

	public LinkedList<MathSet> allFamiliesFor(int prime) {
		LinkedList<MathSet> families = new LinkedList<MathSet>();
		for (MathSet increments : digitIncrements(prime).subsets()) {
			families.add(familyFor(prime, increments));
		}
		return families;
	}

	public MathSet digitIncrements(int x) {
		MathSet increments = new MathSet();
		int current_value = 1;
		while (current_value <= x) {
			increments.add(current_value);
			current_value *= 10;
		}
		return increments;
	}

	public MathSet familyFor(int prime, MathSet increments) {
		MathSet family = new MathSet();
		family.add(prime);

		for (Integer increment : increments) {
			MathSet recursive_increments = new MathSet(increments);
			recursive_increments.remove(increment);

			for (int current_increment = 0;prime + current_increment < increment*10;current_increment += increment) {
				if (PrimeChecker.isPrime(prime + current_increment)) {
					family.addAll(familyFor(prime + current_increment, recursive_increments));
				}
			}
		}

		return family;
	}
}
