import static org.junit.Assert.*;
import org.junit.Test;

public class SieveTest {
	@Test
	public void even() {
		assertArrayEquals(new Integer[]{2}, sieveFor(2));
	}

	@Test
	public void firstOdd() {
		assertArrayEquals(new Integer[]{2, 3}, sieveFor(3));
		assertArrayEquals(new Integer[]{2, 3}, sieveFor(4));
	}

	@Test
	public void compositeOdd() {
		assertArrayEquals(new Integer[]{2, 3, 5, 7}, sieveFor(9));
	}

	@Test
	public void largeList() {
		assertArrayEquals(new Integer[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29}, sieveFor(30));
	}

	private Integer[] sieveFor(int maximum) {
		return Sieve.sieveFor(maximum);
	}
}
