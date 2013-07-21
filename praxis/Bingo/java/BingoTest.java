import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.util.*;

public class BingoTest {
	private Card card;
	@Before
	public void setUp() {
		card = new Card();
	}

	@Test
	public void noCalls() {
		Set<Integer> seen_values = new HashSet<Integer>();
		for (Cell cell : card.cells()) {
			assertTrue(cell.hasValidValue());
			assertFalse(seen_values.contains(cell.value()));
			seen_values.add(cell.value());
		}

		assertTrue(card.cell(2, 2).isSelected());
	}

	@Test
	public void oneCall() {
		selectAt(0,0);
		assertTrue(card.cell(0,0).isSelected());
		assertFalse(card.cell(0,1).isSelected());
	}

	@Test
	public void lose() {
		assertFalse(card.wins());
	}

	@Test
	public void firstRowWin() {
		for (int column = 0;column < 5;++column) {
			selectAt(column, 0);
		}
		assertTrue(card.wins());
	}

	@Test
	public void secondRowWin() {
		for (int column = 0;column < 5;++column) {
			selectAt(column, 1);
		}
		assertTrue(card.wins());
	}

	@Test
	public void thirdRowWin() {
		for (int column = 0;column < 5;++column) {
			if (column != 2) {
				selectAt(column, 2);
			}
		}
		assertTrue(card.wins());
	}

	@Test
	public void firstColumnWins() {
		for (int row = 0;row < 5;++row) {
			selectAt(0, row);
		}
		assertTrue(card.wins());
	}

	@Test
	public void thirdColumnWins() {
		for (int row = 0;row < 5;++row) {
			if (row != 2)
				selectAt(2, row);
		}
		assertTrue(card.wins());
	}

	@Test
	public void downwardDiagonalWins() {
		for (int position = 0;position < 5;++position) {
			if (position != 2)
				selectAt(position, position);
		}
		assertTrue(card.wins());
	}

	@Test
	public void upwardDiagonalWins() {
		for (int position = 0;position < 5;++position) {
			if (position != 2)
				selectAt(position, 4 - position);
		}
		assertTrue(card.wins());
	}

	private void selectAt(int column, int row) {
		card.select(card.cell(column, row).value());
	}
}
