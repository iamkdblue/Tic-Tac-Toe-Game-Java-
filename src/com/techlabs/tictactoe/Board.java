package com.techlabs.tictactoe;

public class Board {

	private int grid[][];
	private int n;

	public Board(int n) {
		grid = new int[n][n];
		this.n = n;
	}

	private int pos;
	private MarkType markType;
	public static int countMoves = 0;

	public void initializeGrid() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = -1;
			}

		}
	}

	public int move(int row, int column, Player p) {
		if (grid[row][column] == -1) {
			if (p.getMarkType() == this.markType.NOUGHT) {
				grid[row][column] = 0;
				countMoves++;
				System.out.println(countMoves);
			}

			else {
				grid[row][column] = 1;
				countMoves++;
			}

			if (countMoves >= (2 * n - 1)) {// here 2n+1 is for minimum moves
											// check
				int checkWinnersValue = checkWinners(row, column);
				return checkWinnersValue;
			}

		} else {
			System.out.println("Can't Override the position");
			TicTacToe.movesStatus = false;
		}
		return -2;
	}

	private int checkWinners(int row, int column) {
		if (horizontalCheck(row, column))
			return grid[row][column];

		if (diagonalCheck(row, column))
			return grid[row][column];

		if (verticalCheck(row, column))
			return grid[row][column];

		return -2;
	}

	private boolean horizontalCheck(int row, int column) {
		int posValue = grid[row][column];
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (grid[row][i] == posValue) {
				count++;
			}
			if (count == n) {
				return true;
			}

		}

		return false;
	}

	private boolean diagonalCheck(int row, int column) {
		int posValue = grid[row][column];
		int count = 0;
		if ((row + column) % 2 == 0) {
			if (row == column) {
				for (int i = 0; i < n; i++) {
					if (grid[i][i] == posValue)
						count++;
					if (count == n)
						return true;
				}
			} else {
				for (int i = 0, j = n - 1; i < n; i++, j--) {
					if (grid[i][j] == posValue)
						count++;
					if (count == n)
						return true;
				}
			}
		}

		return false;

	}

	private boolean verticalCheck(int row, int column) {
		int posValue = grid[row][column];
		int count = 0;

		for (int i = 0; i < n; i++) {
			if (grid[i][column] == posValue) {
				count++;
			}
			if (count == n) {
				return true;
			}

		}
		return false;
	}

}
