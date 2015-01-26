/**
 * 
 */
package battleships;

import java.util.Random;

/**
 * @author christianheiler
 *
 */
public class Ocean {
	private Ship[][] ships = new Ship[10][10];
	private int shotsFired;
	private int hitCount;
	private int shipsSunk;

	//game parameters:
	private int battleships = 1;
	private int cruisers = 2;
	private int destroyers = 3;
	private int submarines = 4;
	
	//Calculated game parameters
	private int totalShips = battleships+cruisers+destroyers+submarines;
	private Ship[] shipArray = new Ship[totalShips];
	
	{
		shotsFired=0;
		hitCount=0;
		shipsSunk=0;
	}
	
	/**
	 * 
	 */
	public Ocean() {
		//fill Ocean with emtptySea Objects
		for(int r=0; r<=9;r++){
			for(int c=0; c<=9; c++){
				ships[r][c] = new EmptySea();
			}//END for c
		}//END for r
	}

	/**
	 * @return the hitCount
	 */
	public int getHitCount() {
		return hitCount;
	}

	/**
	 * increase hit count by 1
	 */
	private void increaseHitCount() {
		this.hitCount++;
	}
	
	/**
	 * @return the number of ships sunk.
	 */
	public int getShipsSunk() {
		return this.shipsSunk;
	}

	/**
	 * increase hit count by 1
	 */
	private void increaseShipsSunk() {
		this.shipsSunk++;
	}
	
	/**
	 * @return the number of shots fired.
	 */
	public int getShotsFired() {
		return this.shotsFired;
	}

	/**
	 * increase shots fired by 1
	 */
	private void increaseShotsFired() {
		this.shotsFired++;
	}
	
	/**
	 * return ship array TEST only!
	 * @return Ships array
	 */
	public Ship[][] getShipArray() {
		return this.ships;
	}
	
	/**
	 * print ocean
	 */
	public void print() {
		//TODO loop to print some ocean
	}
	
	/**
	 * check if game is over
	 * @return TRUE if the game is over
	 */
	public boolean isGameOver() {
		//TODO check if all ships are sunk.
		return false;
	}
	
	/**
	 * check if game is over
	 * @param row ocean row
	 * @param column ocean column
	 * @return TRUE if the field is occupied by anything but EmptySea
	 */
	public boolean isOccupied(int row, int column) {
		return this.ships[row][column].isShip();
	}	
	
	/**
	 * add a ship to the ocean
	 * @param ship - the ship to place
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
		
	}
	
	
	public void placeAllShipsRandomly(){
		boolean repeat = true;
		int row = 0;
		int column = 0;
		boolean horizontal;
		Random rand = new Random();
		for(int b = 0; b < this.battleships; b++){
			Battleship battleship = new Battleship();
			do{
				row = rand.nextInt(9);
				column = rand.nextInt(9);
				horizontal = rand.nextBoolean();
				if(battleship.okToPlaceShipAt(row, column, horizontal, this)){
					battleship.placeShipAt(row, column, horizontal, this);
					repeat = false;
				}
			}while(repeat);
			repeat = true;
		}
		for(int c = 0; c < this.cruisers; c++){
			Cruiser cruiser = new Cruiser();
			do{
				row = rand.nextInt(9);
				column = rand.nextInt(9);
				horizontal = rand.nextBoolean();
				if(cruiser.okToPlaceShipAt(row, column, horizontal, this)){
					cruiser.placeShipAt(row, column, horizontal, this);
					repeat = false;
				}
			}while(repeat);
			repeat=true;
		}
		for(int d = 0; d < this.destroyers; d++){
			Destroyer destroyer = new Destroyer();
			do{
				row = rand.nextInt(9);
				column = rand.nextInt(9);
				horizontal = rand.nextBoolean();
				if(destroyer.okToPlaceShipAt(row, column, horizontal, this)){
					destroyer.placeShipAt(row, column, horizontal, this);
					repeat = false;
				}
			}while(repeat);
			repeat=true;
		}
		for(int s = 0; s < this.submarines; s++){
			Submarine submarine = new Submarine();
			do{
				row = rand.nextInt(9);
				column = rand.nextInt(9);
				horizontal = rand.nextBoolean();
				if(submarine.okToPlaceShipAt(row, column, horizontal, this)){
					submarine.placeShipAt(row, column, horizontal, this);
					repeat = false;
				}
			}while(repeat);
			repeat=true;
		}
	}
	
	

}
