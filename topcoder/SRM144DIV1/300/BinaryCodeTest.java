import static org.junit.Assert.*;
import org.junit.Test;

public class BinaryCodeTest {
	@Test
	public void testSingleCharacter() {
		assertArrayEquals(new String[]{"0", "NONE"}, BinaryCode.decode("0"));
		assertArrayEquals(new String[]{"NONE", "1"}, BinaryCode.decode("1"));
	}

	@Test
	public void testTwoCharacters() {
		assertArrayEquals(new String[]{"00", "NONE"}, BinaryCode.decode("00"));
		assertArrayEquals(new String[]{"01", "10"}, BinaryCode.decode("11"));
	}
}
