class Board {
	private int[][] board = new int[9][9];

	public void setCell(int column, int row, int value) {
		board[column - 1][row - 1] = value;
	}

	public int getCell(int column, int row) {
		return 1;
	}
}
