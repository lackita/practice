import java.util.*;

class Board {
	static int BOARD_SIZE = 9;
	private Cell[][] cell_board = new Cell[BOARD_SIZE][BOARD_SIZE];

	public void setCell(int column_id, int row_id, int value) {
		cell_board[column_id][row_id] = new Cell(value);
	}

	public Cell getCell(int column_id, int row_id) {
		return cell_board[column_id][row_id];
	}

	public boolean validRow(int row_id) {
		Set<Integer> existing_values = new HashSet<Integer>();
		for (Cell cell : row(row_id)) {
			if (cell != null) {
				if (existing_values.contains(cell.value())) {
					return false;
				}
				existing_values.add(cell.value());
			}
		}
		return true;
	}

	public Cell[] row(int row_id) {
		Cell[] row = new Cell[BOARD_SIZE];
		for (int column_id = 0;column_id < BOARD_SIZE;++column_id) {
			row[column_id] = getCell(column_id, row_id);
		}
		return row;
	}
}

class Cell {
	private int value;
	public Cell(int value) {
		set(value);
	}

	public int value() {
		return value;
	}

	public void set(int value) {
		this.value = value;
	}
}
