//-------------------------------
//Gregory Demirdjian - 40249882
//Hrag Bankian - 40245363
//COMP 249
//Assignment 1
//February 3, 2023
//-------------------------------

import java.util.Scanner;
/**
 * Main/driver of the game
 * @author Gregory Demirdjian, Hrag Bankian
 *
 */
public class PlayLadderAndSnake {

	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		welcome();
		
		/**
		 * Prompt input for number of players
		 */
		System.out.print("\nTo begin enter the number of players: ");
		int numPlayers = input.nextInt();
		
		/**
		 * initialize LadderAndSnake object
		 */
		LadderAndSnake game1 = new LadderAndSnake(numPlayers);
		
		/**
		 * Prompt input for player names
		 */
		System.out.print("\nEnter player names...\nPlayer 1: ");
		String p1Name = input.next().toUpperCase();
		System.out.print("Player 2: ");
		String p2Name = input.next().toUpperCase();

		/**
		 * call play method for game1 object
		 */
		game1.play(p1Name, p2Name);
		
		end();
		
		input.close();
		
	}

///////////////////////////////////////////////////////////////////////////////////////
	/**
	 * welcome banner
	 */
	public static void welcome() {
		System.out.println("--------------------------------");
		System.out.println("\tSNAKES & LADDERS");
		System.out.println("--------------------------------");
	}
	/**
	 * end message
	 */
	public static void end() {
		System.out.println("\n------------------------------------------------------");
		System.out.println("\tThank you for playing SNAKES & LADDERS");
		System.out.println("\tReload the program to play again...");
		System.out.println("------------------------------------------------------");
	}
}

