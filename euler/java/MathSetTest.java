import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class MathSetTest {
	@Test
	public void emptySubset() {
		MathSet set = new MathSet();
		assertTrue(set.subsets().contains(new MathSet()));
		assertEquals(1, set.subsets().size());
	}

	@Test
	public void oneSubset() {
		MathSet set = new MathSet();
		set.add(1);
		assertTrue(set.subsets().contains(set));
	}

	@Test
	public void severalSubsets() {
		MathSet set = new MathSet();
		set.add(1);
		set.add(2);
		LinkedList<MathSet> result = set.subsets();
		assertTrue(result.contains(set));

		MathSet expected_set = new MathSet();
		expected_set.add(1);
		assertTrue(result.contains(expected_set));

		expected_set = new MathSet();
		expected_set.add(2);
		assertTrue(result.contains(expected_set));
	}
}
