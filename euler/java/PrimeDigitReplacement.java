import java.util.*;

public class PrimeDigitReplacement {
	public int firstPrimeInClassSize(int number_of_primes) {
		boolean found_correct_class = false;
		PrimeIterator pi = new PrimeIterator();
		while (!found_correct_class) {
			if (pi.next() > 11) {
				if (familyFor(pi.current()).size() == number_of_primes) {
					found_correct_class = true;
				}
			}
		}
		return pi.current();
	}

	public TreeSet<Integer> familyFor(int prime) {
		TreeSet<Integer> family = new TreeSet<Integer>();

		int increment_value = incrementValueForFirstDigit(prime);
		while (prime < increment_value * 10) {
			if (PrimeChecker.isPrime(prime)) {
				family.add(prime);
			}

			prime += increment_value;
		}

		return family;
	}

	public int incrementValueForFirstDigit(int value) {
		int current_exponent = 0;
		while (Math.pow(10, current_exponent + 1) < value) {
			++current_exponent;
		}

		return (int) Math.pow(10, current_exponent);
	}
}
