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
		board.setCell(0,0,1);
		assertEquals(1, board.getCell(0,0).value());
	}

	@Test
	public void validRow() {
		for (int column = 0;column < Board.BOARD_SIZE;++column) {
			board.setCell(column, 0, column + 1);
		}

		assertTrue(board.validRow(0));
	}

	@Test
	public void invalidRow() {
		int value = 1;
		for (Cell cell : board.row(0)) {
			cell.set(value++);
		}
		board.setCell(8, 0, 1);

		assertFalse(board.validRow(0));
	}
}
