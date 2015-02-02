/**
 * 
 */
package battleships;

/**
 * @author christianheiler
 *
 */
public class EmptySea extends Ship {


	public EmptySea() {
		this.length = 1;
		
	}

	/**
	 * Returns the ship type
	 * @return Ship type
	 */
	@Override
	public String getShipType(){
		//TODO: Change to Empty Sea;
		return ".";
	}
	
	/**
	 * Returns single character for ship 
	 * @return character to display
	 */
	@Override
	public String toString(){
		//return appropriate string element:
		// "." not fired at
		//  "-" fired on water
		if(this.hit[0] == true){
			return "-";
		}
		return ".";
	}
	
	
	@Override
	public boolean shootAt(int row, int column){		
		if(this.getBowRow() == row && this.getBowColumn() == column){
			this.hit[0] = true;
		}
		
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	/**
	 * Checks if is ship.
	 * This will always return false as EmptySea is not a real ship
	 *
	 * @return true for ship, false for Empty Sea. 
	 */
	@Override
	public boolean isShip(){
		return false;
	}
	
	
	

}
