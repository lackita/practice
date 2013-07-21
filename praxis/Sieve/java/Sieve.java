import java.util.*;

class Sieve {
	public static void main(String[] args) {
		for (Integer prime : sieveFor(Integer.parseInt(args[0]))) {
			System.out.println(prime.toString());
		}
	}

	public static Integer[] sieveFor(int maximum) {
		return (new Sieve(maximum)).primes();
	}

	private int maximum;
	public Sieve(int maximum) {
		this.maximum = maximum;
	}

	public Integer[] primes() {
		TreeSet<Integer> primes = allNumbers();

		Integer prime = primes.first();
		while (prime <= largestSievableNumber()) {
			prime = primes.higher(prime);

			Integer potential_composite = primes.higher(firstUnsievedComposite(prime) - 1);
			while (potential_composite != null) {
				if (potential_composite % prime == 0) {
					primes.remove(potential_composite);
				}
				potential_composite = primes.higher(potential_composite);
			}
		}

		return primes.toArray(new Integer[0]);
	}

	private TreeSet<Integer> allNumbers() {
		TreeSet<Integer> numbers = new TreeSet<Integer>();
		numbers.add(2);
		
		for (int i = 3;i <= this.maximum;i += 2) {
			numbers.add(i);
		}

		return numbers;
	}

	private Integer largestSievableNumber() {
		return new Integer((int) Math.pow(this.maximum, 0.5));
	}

	private ArrayList<Integer> compositesFor(int prime, int maximum) {
		ArrayList<Integer> composites = new ArrayList<Integer>();
		for (int i = firstUnsievedComposite(prime);i <= this.maximum;i += prime) {
			composites.add(i);
		}

		return composites;
	}

	private Integer firstUnsievedComposite(int prime) {
		return new Integer((int) Math.pow(prime, 2));
	}
}
