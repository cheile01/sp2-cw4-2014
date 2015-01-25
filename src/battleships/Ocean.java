/**
 * 
 */
package battleships;

/**
 * @author christianheiler
 *
 */
public class Ocean {
	private Ship[][] ships = new Ship[10][10];
	private int shotsFired;
	private int hitCount;
	private int shipsSunk;
	private Battleship[] battleship = new Battleship[0]; //1 Battleship
	//private EmptySea[] emptySea = new EmptySea[99]; //100 EmptySea
	
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
		int counter = 0;
		for(int r=0; r<=9;r++){
			for(int c=0; c<=9; c++){
				ships[r][c] = new EmptySea();
				counter++;
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
	

}
