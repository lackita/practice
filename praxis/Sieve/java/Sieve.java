import java.util.*;

class Sieve {
	public Integer[] primes(int maximum) {
		SortedSet<Integer> primes = new TreeSet<Integer>();
		primes.add(2);
		
		for (int i = 3;i <= maximum;i += 2) {
			primes.add(i);
		}

		for (Integer prime : primes.toArray(new Integer[0])) {
			for (Integer composite = 2*prime;composite <= maximum;composite += prime) {
				if (primes.contains(composite)) {
					primes.remove(composite);
				}
			}
		}

		return primes.toArray(new Integer[0]);
	}
}
