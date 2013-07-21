import java.util.*;

class Caller {
	public static void main(String[] args) {
		Card[] cards = new Card[Integer.parseInt(args[0])];
		for (int i = 0;i < cards.length;++i) {
			cards[i] = new Card();
		}

		Random value_caller = new Random(1000);
		Set<Integer> called_values = new HashSet<Integer>();
		boolean card_wins = false;
		int calls = 0;
		while (!card_wins) {
			++calls;
			int called_value;
			do {
				called_value = value_caller.nextInt(75) + 1;
			} while(called_values.contains(called_value));
			called_values.add(called_value);

			for (Card card : cards) {
				card.select(called_value);
				if (card.wins()) {
					card_wins = true;
				}
			}
		}

		System.out.println(Integer.toString(calls));
	}
}

class Card {
	private Column[] columns = new Column[5];
	public Card() {
		for (int column = 0;column < columns.length;++column) {
			columns[column] = new Column(column);
		}
	}

	public Cell[] cells() {
		Queue<Cell> cells = new ArrayDeque<Cell>(25);
		for (Column column : columns) {
			for (Cell cell : column.cells()) {
				cells.add(cell);
			}
		}
		return cells.toArray(new Cell[0]);
	}

	public Cell cell(int column, int row) {
		return columns[column].cell(row);
	}

	public Column[] columns() {
		return columns; 
	}

	public void select(int value) {
		columns[(value - 1) / 15].select(value);
	}

	public boolean wins() {
		return rowWins() || columnWins() || downwardDiagonalWins() || upwardDiagonalWins();
	}

	private boolean rowWins() {
		for (int row = 0;row < 5;++row) {
			if (rowWins(row))
				return true;
		}

		return false;
	}

	private boolean rowWins(int row) {
		for (int column = 0;column < 5;++column) {
			if (!cell(column, row).isSelected()) {
				return false;
			}
		}

		return true;
	}

	private boolean columnWins() {
		for (int column = 0;column < 5;++column) {
			if (columnWins(column))
				return true;
		}

		return false;
	}

	private boolean columnWins(int column) {
		for (int row = 0;row < 5;++row) {
			if (!cell(column, row).isSelected()) {
				return false;
			}
		}

		return true;
	}

	private boolean downwardDiagonalWins() {
		for (int position = 0;position < 5;++position) {
			if (!cell(position, position).isSelected()) {
				return false;
			}
		}

		return true;
	}

	private boolean upwardDiagonalWins() {
		for (int position = 0;position < 5;++position) {
			if (!cell(position, 4 - position).isSelected()) {
				return false;
			}
		}

		return true;
	}
}

class Column {
	private Cell[] cells = new Cell[5];
	public int position;
	private int value_index = 0;
	private Random possible_values = new Random();
	private HashSet<Integer> existing_offsets = new HashSet<Integer>();
	public Column(int position) {
		this.position = position;
		for (int row = 0;row < cells.length;++row) {
			cells[row] = new Cell(this, row);
		}
	}

	public Cell[] cells() {
		return cells;
	}

	public int size() {
		return cells.length;
	}

	public int validValue() {
		return smallestValidValue() + validValueOffset();
	}

	private int validValueOffset() {
		int offset;
		do {
			offset = possible_values.nextInt(largestValidValue() - smallestValidValue());
		} while (existing_offsets.contains(offset));
		existing_offsets.add(offset);
		return offset;
	}

	public int smallestValidValue() {
		return 15*position + 1;
	}

	public int largestValidValue() {
		return 15*(position + 1);
	}

	public Cell cell(int row) {
		return cells[row];
	}

	public void select(int value) {
		for (Cell cell : cells()) {
			if (cell.value() == value) {
				cell.select();
			}
		}
	}

	public boolean hasFreeCell() {
		return position == 2;
	}
}

class Cell {
	private Column column;
	private int row;
	private int value;
	private boolean selected = false;
	public Cell(Column column, int row) {
		this.row = row;
		this.column = column;
		value = column.validValue();
	}

	public int value() {
		return value;
	}

	public boolean hasValidValue() {
		return value >= column.smallestValidValue() && value <= column.largestValidValue();
	}

	public void select() {
		selected = true;
	}

	public boolean isSelected() {
		return (row == 2 && column.hasFreeCell()) || selected;
	}
}
