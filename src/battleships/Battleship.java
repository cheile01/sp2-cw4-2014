/**
 * 
 */
package battleships;

/**
 * @author christianheiler
 *
 */
public class Battleship extends Ship {


	public Battleship() {
		this.length = 4;
		
	}
	
	/**
	 * Returns the ship type
	 * @return Ship type
	 */
	@Override
	public String getShipType(){
		return "battleship";
	}
	
	/**
	 * Returns single character for ship 
	 * @return character to "S" Fired upon, "x" Sunk, "." not hit
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
