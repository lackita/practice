import java.util.*;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
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
		assertEquals(2, pdr.firstPrimeInClassSize(1));
	}

	@Test
	public void fourPrimeFamily() {
		assertEquals(2, pdr.firstPrimeInClassSize(4));
	}

	@Test
	public void sixPrimeFamily() {
		assertEquals(13, pdr.firstPrimeInClassSize(6));
	}

	@Test
	public void twoFamilies() {
		MathSet increments = new MathSet();
		MathSet result = new MathSet();
		result.add(2);
		assertEquals(result, pdr.familyFor(2, increments));

		increments.add(1);
		result.add(3);
		result.add(5);
		result.add(7);
		assertEquals(result, pdr.familyFor(2, increments));
	}
}
