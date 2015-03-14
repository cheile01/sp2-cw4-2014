package battleships;

import java.util.Scanner;

public class BattleshipGame {

	
	public static void main(String args[]){
		Ocean ocean = new Ocean();
		ocean.placeAllShipsRandomly();
		int row;
		int column;
		
		do{
			ocean.print();
			row = getInteger("Shoot at row: ");
			column = getInteger("Shoot at collumn: ");
			ocean.shootAt(row, column);
		}while(!ocean.isGameOver());
		
		
		
		
	}
	
	
	
	public static int getInteger(String message){
		Scanner in = new Scanner(System.in);
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

}
