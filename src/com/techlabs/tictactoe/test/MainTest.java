package com.techlabs.tictactoe.test;

import java.util.Scanner;

import com.techlabs.tictactoe.TicTacToe;

public class MainTest {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("enter size of Board :");
		int n = sc.nextInt();

		TicTacToe tacToe = new TicTacToe(n);

		int winner = tacToe.start();
		switch (winner) {
		case -2:
			System.out.println("Match is draw");
			break;
		case 1:
			System.out.println("Player 1 is win match");
			break;
		case 2:
			System.out.println("Player 2 is win match");
		}
	}
}
