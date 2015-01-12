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
	
	{
		shotsFired=0;
		hitCount=0;
		shipsSunk=0;
	}
	
	/**
	 * 
	 */
	public Ocean() {
		// TODO implement constructor method, needs EmptySea class.
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
		return true;
	}
	
	

}
