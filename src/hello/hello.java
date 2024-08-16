package hello;

import java.util.Arrays;
import java.util.Scanner;



public class hello {
	
	static char [][] grid = new char [6][7];
	static char [] l = new char[1];
	static int  mode;
	static int flag = 1;
	static int terminate = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcom to coccect4");
		System.out.println("select game type");
		System.out.println("Enter 1 for player VS computer");
		System.out.println("Enter 2 for player VS player");
		Scanner input = new Scanner(System.in);
		int typeOfGame = input.nextInt();			//choose between two modes in the game(computer VS player is not available) 
		mode = typeOfGame;
		System.out.println("starting game");
		
		
		
			playGame();					//initialize game 
			
		
		
	}
	
	public static void playGame() {
				
		Scanner input = new Scanner(System.in);
		if(mode ==2) {
			
			if (flag == 1) {
				playerOne();				//function take player 1 move
				flag = 0;
			} else {
				playertwo();				//function take player 2 move
				flag = 1;
			}
			
			printGrid();					//print the updated grid after player 1 or 2 play
			checkWin1();					//check win (row of 4 vertical or horizontal)
			checkWin2();					//check win (row of 4 in diagonal)
			checkWin3();					//check win (row of 4 in diagonal)
			
		 }else if(mode ==1) {
			 //will be code for computer VS player
		 }
	}
	
	public static void printGrid() {			
		for (int i = 1;i < 8;i++) {
			System.out.print(" "+i+"  | ");
		}
		System.out.println("");
		for (int i = 0;i < 6;i++) {
			for (int j = 0;j < 7;j++) {
				System.out.print(" "+grid[i][j]+"  | ");
			}
			System.out.println("");
		}
	}
	
	public static void playerOne() {			
		Scanner input = new Scanner(System.in);
		System.out.print("player 1 move:");
		int playerMove = input.nextInt();
		for (int i = 6;i >= 0;i--) {
			if((playerMove > 7) || (i <= 0)) {
				System.out.println("can't be played play again");
				playerOne();
				break;
			}else if(grid[i-1][playerMove - 1] == l[0]) {
				System.out.println("i'm in");
				grid[i - 1][playerMove - 1] = 'x';
				break;
			}
		}
	}
	
	public static void playertwo() {			
		Scanner input = new Scanner(System.in);
		System.out.print("player 2 move:");
		int playerMove = input.nextInt();
		for (int i = 6;i >= 0;i--) {
			if((playerMove > 7) || (i <= 0 )) {
				System.out.println("can't be played play again");
				playertwo();
				break;
			}else if(grid[i - 1][playerMove - 1] == l[0]) {
				
				grid[i - 1][playerMove - 1] = 'o';
				break;
			}
		}
	}
	
	public static void checkWin1() {
	
		for (int i = 0;i < 6;i++) {
			for (int j = 0;j < 7;j++) {
				if((j+1>6) || (j+2>6) || (j+3>6)) {
					continue;
				}else if((grid[i][j] == 'x') && (grid[i][j+1] == 'x') && (grid[i][j+2] == 'x') && (grid[i][j+3] == 'x')){
					System.out.println("player 1 win");
					terminate = 1;
				}else if((grid[i][j] == 'o') && (grid[i][j+1] == 'o') && (grid[i][j+2] == 'o') && (grid[i][j+3] == 'o')){
					System.out.println("player 2 win");
					terminate = 1;
				}else if((i+1>5) || (i+2>5) || (i+3>5)) {
					continue;
				}else if((grid[i][j] == 'x') && (grid[i+1][j] == 'x') && (grid[i+2][j] == 'x') && (grid[i+3][j] == 'x')){
					System.out.println("player 1 win");
					terminate = 1;
				}else if((grid[i][j] == 'o') && (grid[i+1][j] == 'o') && (grid[i+2][j] == 'o') && (grid[i+3][j] == 'o')){
					System.out.println("player 2 win");
					terminate = 1;
				}
				
			}
		}
	
	}
	
	public static void checkWin2() {
		for (int i = 0;i < 6;i++) {
			for (int j = 0;j < 7;j++) {
				if((i-1<0) || (i-2<0) || (i-3<0)) {
					continue;
				}else if((j+1>6) || (j+2>6) || (j+3>6)) {
					continue;
				}else if((grid[i][j] == 'o') && (grid[i-1][j+1] == 'o') && (grid[i-2][j+2] == 'o') && (grid[i-3][j+3] == 'o')){
					System.out.println("player 2 win");
					terminate = 1;
				}else if((grid[i][j] == 'x') && (grid[i-1][j+1] == 'x') && (grid[i-2][j+2] == 'x') && (grid[i-3][j+3] == 'x')){
					System.out.println("player 1 win");
					terminate = 1;
				}
			}
		}
	}
	
	public static void checkWin3() {
		for (int i = 0;i < 6;i++) {
			for (int j = 0;j < 7;j++) {
				if((j+1<0) || (j+2<0) || (j+3<0)) {
					continue;
				}else if((i+1>5) || (i+2>5) || (i+3>5)) {
					continue;
				}else if((grid[i][j] == 'o') && (grid[i+1][j+1] == 'o') && (grid[i+2][j+2] == 'o') && (grid[i+3][j+3] == 'o')){
					System.out.println("player 2 win");
					terminate = 1;
				}else if((grid[i][j] == 'x') && (grid[i+1][j+1] == 'x') && (grid[i+2][j+2] == 'x') && (grid[i+3][j+3] == 'x')){
					System.out.println("player 1 win");
					terminate = 1;
				}
			}
		}
		if (terminate == 0) {
			playGame();
		}else {System.out.println("end of the game");}
		
	}
	
	
}