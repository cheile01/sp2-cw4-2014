package battleships;

import java.util.Scanner;

public class BattleshipGame {

	public BattleshipGame() {
		// TODO Auto-generated constructor stub
	}
	
	public void main(String args[]){
		int number = getInteger("gimme");
		System.out.println(number);
	}
	
	
	
	public static int getInteger(String message){
		Scanner in = new Scanner(System.in);
		System.out.print(message+" ");
		int temp = 0;
		do{
			if(in.hasNextInt()){
				temp = in.nextInt();
				if(temp < 0 && temp > 9){
					System.out.print("A number between 0 and 9 please ");
					temp = 0;
				}
			} else {
				System.out.print("A number between 0 and 9 please ");
				in.next();
			}
			
		}while(temp < 0 && temp > 9);

		in.close();
		
		return temp;
		
	}

}
