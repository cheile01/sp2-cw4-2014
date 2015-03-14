package battleships;

import java.util.ArrayList;
import java.util.Random;

/**
 * The Class Ocean.
 *
 * @author christianheiler
 */
public class Ocean {
	
	/** The ships. */
	private Ship[][] ships = new Ship[10][10];
	
	/** The shots fired. */
	private int shotsFired;
	
	/** The hit count. */
	private int hitCount;
	
	/** The ships sunk. */
	private int shipsSunk;

	//game parameters:
	/** The battleships. */
	private int battleships = 1;
	
	/** The cruisers. */
	private int cruisers = 2;
	
	/** The destroyers. */
	private int destroyers = 3;
	
	/** The submarines. */
	private int submarines = 4;
	
	//Calculated game parameters
	/** The ship array. */
	private ArrayList<Ship> shipArray = new ArrayList<Ship>();
	
	{
		shotsFired=0;
		hitCount=0;
		shipsSunk=0;
	}
	
	/**
	 * Ocean constructor.
	 */
	public Ocean() {
		//fill Ocean with emtptySea Objects
		for(int r=0; r<=9;r++){
			for(int c=0; c<=9; c++){
				Ship temp = new EmptySea();
				temp.placeShipAt(r, c, true, this);
				ships[r][c] = temp;
			}//END for c
		}//END for r
	}

	/**
	 * Gets the hit count.
	 *
	 * @return the hitCount
	 */
	public int getHitCount() {
		return hitCount;
	}

	/**
	 * increase hit count by 1.
	 */
	private void increaseHitCount() {
		this.hitCount++;
	}
	
	/**
	 * Gets the ships sunk.
	 *
	 * @return the number of ships sunk.
	 */
	public int getShipsSunk() {
		return this.shipsSunk;
	}

	/**
	 * increase hit count by 1.
	 */
	private void increaseShipsSunk() {
		this.shipsSunk++;
	}
	
	/**
	 * Gets the shots fired.
	 *
	 * @return the number of shots fired.
	 */
	public int getShotsFired() {
		return this.shotsFired;
	}

	/**
	 * increase shots fired by 1.
	 */
	private void increaseShotsFired() {
		this.shotsFired++;
	}
	
	/**
	 * return ship array TEST only!.
	 *
	 * @return Ships array
	 */
	public Ship[][] getShipArray() {
		return this.ships;
	}
	
	/**
	 * print ocean.
	 */
	public void print() {
		//loop to print some ocean
		
		//Print first line
		System.out.println("  0 1 2 3 4 5 6 7 8 9");
		for(int r=0;r<10;r++){
			System.out.print(r+" ");
			for(int c=0;c<10;c++){
				Ship ship = this.ships[r][c];
				String s = ship.toString();
				if(s=="S"){
					if(!ship.isElementHit(r, c)){
						s = ".";
					} 
				} 
				System.out.print(s + " ");
				
			}//END Columns for loop
			System.out.println();
		}//END Rows for loop
		
		
	}
	
	/**
	 * check if game is over.
	 *
	 * @return TRUE if the game is over
	 */
	public boolean isGameOver() {
		//check if all ships are sunk.
		for(Ship ship : this.shipArray){
			//if one ship is not sunk, the game is not over
			if(!ship.isSunk()){
				return false;
			}
		}
		return true;
	}
	
	//TODO: Remove function
	/**
	 * Gets the ship list.
	 *
	 * @return the ship list
	 */
	public ArrayList<Ship> getShipList(){
		return this.shipArray;
	}
	
	
	/**
	 * check if element is Occupied.
	 *
	 * @param row ocean row
	 * @param column ocean column
	 * @return TRUE if the field is occupied by anything but EmptySea
	 */
	public boolean isOccupied(int row, int column) {
		return this.ships[row][column].isShip();
	}	
	
	/**
	 * add a ship to the ocean.
	 *
	 * @param s the s
	 * @return TRUE if the field is occupied by anything but EmptySea
	 */
	public void addShip(Ship s){
		//add ship to ocean array
		int row = s.getBowRow();
		int column = s.getBowColumn();
		int length = s.getLength();
		
		for(int i = 0; i < length; i++){
			if(s.isHorizontal()){
				this.ships[row][column+i] = s;
			} else {
				this.ships[row+i][column] = s;
			}
		}
		//Only add the ship to the list if it is a real ship, not empty ocean
		if(s.isShip()){
			this.shipArray.add(s);
		}
		
		
	}
	
	
	/**
	 * Place all ships randomly.
	 */
	public void placeAllShipsRandomly(){
		for(int b = 0; b < this.battleships; b++){
			placeShipRandomly(new Battleship());
		}
		for(int c = 0; c < this.cruisers; c++){
			placeShipRandomly(new Cruiser());
		}
		for(int d = 0; d < this.destroyers; d++){
			placeShipRandomly(new Destroyer());
		}
		for(int s = 0; s < this.submarines; s++){
			placeShipRandomly(new Submarine());
		}
	}
	
	
	/**
	 * Place one ship randomly.
	 *
	 * @param ship the ship
	 */
	private void placeShipRandomly(Ship ship){
		int row = 0;
		int column = 0;
		boolean horizontal;
		Random rand = new Random();
		do{
			row = rand.nextInt(9);
			column = rand.nextInt(9);
			horizontal = rand.nextBoolean();
			if(ship.okToPlaceShipAt(row, column, horizontal, this)){
				ship.placeShipAt(row, column, horizontal, this);
				break;
			}
		}while(true);
	}
	
	
	/**
	 * Shoot at.
	 *
	 * @param row the row
	 * @param column the column
	 * @return true, if successful
	 */
	public boolean shootAt(int row, int column){
		Ship ship = this.ships[row][column];
		boolean alreadySunk = ship.isSunk();
				
		boolean temp = ship.shootAt(row, column);
		
		this.increaseShotsFired();
		if(ship.isShip()){
			this.increaseHitCount();
			if(ship.isSunk() && !alreadySunk){
				this.increaseShipsSunk();
			}
		} 
		return temp;
	}


	
}
