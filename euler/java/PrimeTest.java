import static org.junit.Assert.*;
import org.junit.Test;

public class PrimeTest {
	@Test
	public void smallestPrime() {
		assertTrue(PrimeChecker.isPrime(2));
	}

	@Test
	public void smallestComposite() {
		assertFalse(PrimeChecker.isPrime(4));
	}

	@Test
	public void iterator() {
		PrimeIterator pi = new PrimeIterator();
		assertEquals(2, pi.next());
		assertEquals(3, pi.next());
		assertEquals(5, pi.next());
		assertEquals(7, pi.next());
	}
}
