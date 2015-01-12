/**
 * 
 */
package battleships;

/**
 * @author christianheiler
 *
 */
public class Ship {
	protected int bowRow;
	protected int bowColumn;
	protected boolean horizontal;
	protected int length;
	protected boolean[] hit = new boolean[4];
	
	
	/**
	 * 
	 */
	public Ship() {
		this.length = 1;
	}


	/**
	 * @return the bowRow
	 */
	public int getBowRow() {
		return bowRow;
	}


	/**
	 * @param bowRow the bowRow to set
	 */
	public void setBowRow(int bowRow) {
		this.bowRow = bowRow;
	}


	/**
	 * @return the bowColumn
	 */
	public int getBowColumn() {
		return bowColumn;
	}


	/**
	 * @param bowColumn the bowColumn to set
	 */
	public void setBowColumn(int bowColumn) {
		this.bowColumn = bowColumn;
	}


	/**
	 * @return the horizontal
	 */
	public boolean isHorizontal() {
		return horizontal;
	}


	/**
	 * @param horizontal the horizontal to set
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	/**
	 * Returns the ship type
	 * @return Ship type
	 */
	public String getShipType(){
		return "";
	}
	
	public int getLength(){
		return this.length;
	}
	
	public boolean okToPlaceShipAt(int row, int column, boolean hotizontal, Ocean ocean){
		//TODO check if it is ok to place ship - needs ocean array first.
		return true;
	}
	
	public void placeShipAt(int row, int column, boolean hotizontal, Ocean ocean){
		//TODO create method to place ship - needs ocean array first.
		
	}
	
	public boolean shootAt(int row, int column){
		//TODO check if the ship is in the position of row/column.
		for(int i=0; i <= this.getLength()-1; i++){
			if(this.isHorizontal()){
				//check row
				if(this.getBowRow()+i==row && this.getBowColumn() == column){
					
				}	
			} else {
				//check column values
			}
			
		}

		
		//TODO set hit array to true if it is hit
		
		//TODO return TRUE if hit
		return false;
	}
	
	public boolean isSunk(){
		//TODO return true if all (length) elements of ship array are TRUE
		return false;
	}
	
}
