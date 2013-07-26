import java.util.*;

public class PrimeChecker {
	public static boolean isPrime(int x) {
		PrimeChecker pc = PrimeChecker.singleton();
		pc.calculatePast(x);
		return pc.calculated().contains(x);
	}

	public static int largerThan(int x) {
		PrimeChecker pc = PrimeChecker.singleton();
		pc.calculatePast(x);
		return pc.calculated().higher(x);
	}

	private static PrimeChecker instance;
	private static PrimeChecker singleton() {
		if (instance == null) {
			instance = new PrimeChecker();
		}
		return instance;
	}

	private TreeSet<Integer> primes = new TreeSet<Integer>();
	private Integer largest_value = 1;

	public TreeSet<Integer> calculated() {
		return primes;
	}

	public void calculatePast(int x) {
		for (++largest_value;primes.higher(x) == null;++largest_value) {
			if (relativelyPrimeToComputedPrimes(largest_value)) {
				primes.add(largest_value);
			}
		}
	}

	private boolean relativelyPrimeToComputedPrimes(int current_value) {
		Iterator prime_iterator = primes.iterator();
		boolean composite = false;
		while (!composite && prime_iterator.hasNext()) {
			Integer prime = (Integer) prime_iterator.next();
			if (current_value % prime == 0) {
				composite = true;
			}
		}

		return !composite;
	}
}

class PrimeIterator {
	private int last_prime = 1;
	public int next() {
		last_prime = PrimeChecker.largerThan(last_prime);
		return last_prime;
	}

	public int current() {
		return last_prime;
	}
}
