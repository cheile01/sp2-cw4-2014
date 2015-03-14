package battleships;

import java.util.Scanner;

public class BattleshipGame {
	
	
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int row;
		int column;
		boolean again = false;
		
		do{
		Ocean ocean = new Ocean();
		ocean.placeAllShipsRandomly();

			do{
				System.out.println("");
				
				System.out.print("Shots: " + ocean.getShotsFired());
				System.out.print(" | Hits: " + ocean.getHitCount());
				System.out.print(" | Ships: " + ocean.getShipsSunk());
				System.out.println("");
				System.out.println("");
				ocean.print();
				
				row = getInteger("Shoot at row: ",in);
				column = getInteger("Shoot at collumn: ",in);
				ocean.shootAt(row, column);

			}while(!ocean.isGameOver());
			
			System.out.println("Game Over, you sunk all ships!");
			System.out.println("Your Result:");
			System.out.print("Shots: " + ocean.getShotsFired());
			System.out.print(" | Hits: " + ocean.getHitCount());
			System.out.print(" | Ships: " + ocean.getShipsSunk());
			
			System.out.println("");
			again = getPlayAgain("Play Again?",in);
			
		}while(again);
		
		System.out.println("Thank you for playing");
		
		in.close();
		
		
	}
	
	
	public static int getInteger(String message, Scanner in){
		System.out.print(message+" ");
		int temp = -8;
		do{
			if(in.hasNextInt()){
				temp = in.nextInt();
				if(temp < 0 || temp > 9){
					System.out.print("A number between 0 and 9 please! ");
				}
			} else {
				System.out.print("A number between 0 and 9 please ");
				in.next();
			}
		}while(temp < 0 || temp > 9);
		
		return temp;
	}
	
	public static boolean getPlayAgain(String message, Scanner in){
		System.out.print(message);
		String temp = in.next();
		if(temp.equalsIgnoreCase("y")){
			return true;
		}
		return false;
	}

}
