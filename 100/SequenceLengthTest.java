import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SequenceLengthTest {
	private SequenceLength sl;

	@Before
	public void setUp() {
		sl = new SequenceLength();
	}
	
	@Test
	public void testBaseValue() {
		assertEquals(1, sl.maximumCycleLength("1 1"));
	}

	@Test
	public void testEvenValue() {
		assertEquals(3, sl.maximumCycleLength("4 4"));
	}
	
	@Test
	public void testOddValue() {
		assertEquals(6, sl.maximumCycleLength("5 5"));
	}
	
	@Test
	public void testMultipleValue() {
		assertEquals(8, sl.maximumCycleLength("3 4"));
	}
}
