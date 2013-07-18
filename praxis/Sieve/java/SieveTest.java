import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SieveTest {
	private Sieve s;
	@Before
	public void setUp() {
		s = new Sieve();
	}

	@Test
	public void even() {
		assertArrayEquals(new Integer[]{2}, s.primes(2));
	}

	@Test
	public void firstOdd() {
		assertArrayEquals(new Integer[]{2, 3}, s.primes(3));
		assertArrayEquals(new Integer[]{2, 3}, s.primes(4));
	}

	@Test
	public void compositeOdd() {
		assertArrayEquals(new Integer[]{2, 3, 5, 7}, s.primes(9));
	}
}
