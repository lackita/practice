import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class PrimeDigitReplacementTest {
	PrimeDigitReplacement pdr;
	@Before
	public void setUp() {
		pdr = new PrimeDigitReplacement();
	}

	@Test
	public void onePrimeFamily() {
		assertEquals(13, pdr.firstPrimeInClassSize(6));
	}

	@Test
	public void thirteenFamily() {
		assertArrayEquals(new Integer[]{13, 23, 43, 53, 73, 83}, pdr.familyFor(13).toArray(new Integer[0]));
	}

	// @Test
	// public void twoFamily() {
	// 	assertArrayEquals(new Integer[]{2, 3, 5, 7}, pdr.familyFor(2).toArray(new Integer[0]));
	// }

	@Test
	public void digitIncrementValue() {
		assertEquals(10, pdr.incrementValueForFirstDigit(13));
		assertEquals(1, pdr.incrementValueForFirstDigit(2));
	}
}
