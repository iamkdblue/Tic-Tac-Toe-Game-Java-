package com.techlabs.tictactoe;

import java.util.Scanner;

public class TicTacToe {

	static boolean movesStatus = true;
	Scanner sc = new Scanner(System.in);
	Board board;
	Player player1;
	Player player2;
	int n;
	public TicTacToe(int n) {
		player1 = new Player("kuldeep", MarkType.CROSS);
		player2 = new Player("Rahul", MarkType.NOUGHT);
		board = new Board(n);
		board.initializeGrid();
		this.n=n;
	}

	public int start() {
		while (Board.countMoves < n*n) {
			if (movesStatus == true) {
				//cross
				System.out.println("Player 1");
				int row = sc.nextInt();
				int column = sc.nextInt();
				movesStatus = false;
				if ((board.move(row, column, player1)) == 1)
				{
					return 1;
				}
			} else {
				//circle
				System.out.println("Player 2");
				int row = sc.nextInt();
				int column = sc.nextInt();
				movesStatus = true;
				if (board.move(row, column, player2) == 0)
				{
					return 2;
				}
			}
		}
		System.out.println("while close");
		return -2;
	}
}
