/**
 * 
 */
package battleships;

/**
 * @author christianheiler
 *
 */
public class Destroyer extends Ship {


	public Destroyer() {
		this.length = 2;
		
	}
	

	/**
	 * Returns the ship type
	 * @return Ship type
	 */
	@Override
	public String getShipType(){
		return "destroyer";
	}
	
	/**
	 * Returns single character for ship 
	 * @return character to display
	 */
	@Override
	public String toString(){
		// return appropriate string element:
		// "S" Fired and hit ship
		// "x" ship is sunk
		// "." not fired at
		if(this.isSunk()){
			return "x";
		}
		// check if ship has been fired upon.
		for(int i = 0; i < this.length; i++){
			if(hit[i]){
				return "S";
			}	
		}
		return ".";
	}
	
	
	

}
