//-------------------------------
//Gregory Demirdjian - 40249882
//Hrag Bankian - 40245363
//COMP 249
//Assignment 1
//February 3, 2023
//-------------------------------

import java.util.Scanner;
/**
 * Class with two attributes and method to run the game
 * @author Gregory Demirdjian, Hrag Bankian
 *
 */
public class LadderAndSnake {
	/**
	 * board attribute as 2D array of type int
	 * players attribute of type int
	 */
	private static int board [][];
	private int players;
	
	Scanner input = new Scanner (System.in);
	
	/**
	 * Default constructor
	 */
	public LadderAndSnake () {
		board = new int [10][10];
		players = 2;
	}
	
	/**
	 * Parameterized contructor, with number of players being passed
	 * And validation for the number of players
	 * @param players pass the number of players, input from the user
	 */
	public LadderAndSnake(int players) {
		board = new int [10][10];
		this.players = players;
		if (players > 2) {
			System.out.println("Error: Number of players is limited to 2\nNumber of players will be reset to 2");
			this.players = 2;
		}
		else if (players < 2) {
			System.out.println("Minimum of 2 players is required to play SNAKES & LADDERS");
			PlayLadderAndSnake.end();
			System.exit(0);
		}
	}
	
	/**
	 * Accessor method for board attribute
	 * @return 10x10 board
	 */
	public int getBoard() {
		return board [10][10];
	}
	
	/**
	 * Accessor for number of players
	 * @return number of players
	 */
	public int getPlayers() {
		return players;
	}
	
	/**
	 * Mutator method for players attribute
	 * @param players pass number of players
	 */
	public void setPlayers(int players) {
		this.players = players;
	}
	
	/**
	 * Roll the die
	 * @return value of die
	 */
	public static int flipDice() {
		return (int) (Math.random()*6+1);
	}
	
	/**
	 * Method play runs through the game of Snakes and Ladders
	 * @param p1Name pass name of player 1
	 * @param p2Name pass name of player 2
	 */
	public void play(String p1Name, String p2Name) {
		
		System.out.println("\nWelcome " + p1Name + ", " + p2Name);
		System.out.println("Roll the die to determine the player who will play first");
		System.out.print("Press ENTER to roll the die...");
		String go = input.nextLine();
		
		//store die values and starting player
		boolean begin = false;
		int p1die = 0;
		int p2die = 0;
		int count = 0;
		String r1 = "";
		String r2 = "";
		
		//loop until starter is determined
		do {
			p1die = flipDice();
			p2die = flipDice();
			
			if (p1die > p2die) {
				//count++;
				r1 = p1Name;
				r2 = p2Name;
				begin = true;
				System.out.println(p1Name + " starts! After " + ++count + " roll(s).");
			}
			else if (p1die < p2die) {
				//count++;
				r1 = p2Name;
				r2 = p1Name;
				begin = true;
				System.out.println(p2Name + " starts! After " + ++count + " roll(s).\n");
				
			}
			//re-roll if both roll the same
			else if (p1die == p2die) {
				System.out.println("\nTie!\nRoll again\n");
				count++;
			}
		}while (begin == false);
		
		//array of names in rolling order
		String nameArr [] = {r1, r2};
		//winner name
		String winner = "";
		
		//fill 10x10 board with spaces 1-100
		int num = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = ++num;
			}
		}
		
		boolean play = true;
		//array of player's current position
		int players [] = new int [2];
		
		//main loop for the game
		do {
			System.out.println("\nRolling...");
			
			//roll die for each player and store position
			for (int i = 0, j = 1; i < players.length && j>=0; i++, j--) {
				int roll = flipDice();
				players[i] += roll;
				
				//after every turn verify presence of snake or ladder
				switch (players[i]) {
				case 1:
					players[i] = 38;
					break;
				case 4:
					players[i] = 14;
					break;
				case 9:
					players[i] = 31;
					break;
				case 16:
					players[i] = 6;
					break;
				case 21:
					players[i] = 42;
					break;
				case 28:
					players[i] = 84;
					break;
				case 36:
					players[i] = 44;
					break;
				case 48:
					players[i] = 30;
					break;
				case 51:
					players[i] = 67;
					break;
				case 64:
					players[i] = 60;
					break;
				case 71:
					players[i] = 91;
					break;
				case 80:
					players[i] = 100;
					break;
				case 93:
					players[i] = 68;
					break;
				case 95:
					players[i] = 24;
					break;
				case 97:
					players[i] = 76;
					break;
				case 98:
					players[i] = 78;
					break;
				}
				
				//verify if same position and kick back to start
				if(players[i] == players[j]) {
					players[j] = 0;
					System.out.println(nameArr[j] + " gets kicked back to square 0!");
				}
					
				//verify if position is over 100 and calibrate
				if(players[i] > 100) {
					players[i] -= 2*(players[i]-100);
				}
				
				//determine winner and end of game
				if(players[i] == 100) {
					winner = nameArr[i];
					play = false;
				}
				
				//print current roll and update position after each player's rolls
				System.out.println(nameArr[i] + " rolls " + roll + ". Position: " + players[i]);
			}
			
			
			//printing the board after each round with current player positions
			//print rows in alternating order
			boolean side = true;
			
			for (int i = board.length-1; i >= 0; i--) {
				
					for (int j= board.length -1; j >= 0 && side == true; j--) {
						if (board[i][j] == players[0] || board[i][j] == players[1]) {
							System.out.print("["+board[i][j]+"]" + "\t");
						}else
							System.out.print(board[i][j] + "\t");	
					
					}

					for (int j= 0; j < board.length && side ==false; j++) {
						if (board[i][j] == players[0] || board[i][j] == players[1]) {
							System.out.print("["+board[i][j]+"]" + "\t");
						}else
							System.out.print(board[i][j] + "\t");	
						}
				side = !side;
				System.out.println();
			}
						
		} while (play == true);
		
		//END of game display winner banner
		System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("\t" + winner + " IS THE WINNER");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}
	
	
}
