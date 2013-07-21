import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class SudokuTest {
	private Board board;

	@Before
	public void setUp() {
		board = new Board();
	}

	@Test
	public void oneValue() {
		board.setCell(1,1,1);
		assertEquals(1, board.getCell(1,1));
	}
}
