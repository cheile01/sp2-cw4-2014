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
		// TODO implement constructor method
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
	
	
	
	

}
