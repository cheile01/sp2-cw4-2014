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
	 * @return character to display
	 */
	@Override
	public String toString(){
		//TODO return appropriate string element:
		// "S" Fired and hit ship
		// "x" ship is sunk
		// "." not fired at
		
		
		
		return ".";
	}	
	

}
