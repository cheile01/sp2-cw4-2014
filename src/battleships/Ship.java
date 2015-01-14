/**
 * 
 */
package battleships;

// TODO: Auto-generated Javadoc
/**
 * The Class Ship.
 *
 * @author christianheiler
 */
/**
 * @author christianheiler
 *
 */
public class Ship {
	
	/** The bow row. */
	protected int bowRow;
	
	/** The bow column. */
	protected int bowColumn;
	
	/** The horizontal. */
	protected boolean horizontal;
	
	/** The length. */
	protected int length;
	
	/** The hit. */
	protected boolean[] hit = new boolean[4];
	
	
	/**
	 * Instantiates a new ship.
	 */
	public Ship() {
		this.length = 1;
	}


	/**
	 * Gets the bow row.
	 *
	 * @return the bowRow
	 */
	public int getBowRow() {
		return bowRow;
	}


	/**
	 * Sets the bow row.
	 *
	 * @param bowRow the bowRow to set
	 */
	public void setBowRow(int bowRow) {
		this.bowRow = bowRow;
	}


	/**
	 * Gets the bow column.
	 *
	 * @return the bowColumn
	 */
	public int getBowColumn() {
		return bowColumn;
	}


	/**
	 * Sets the bow column.
	 *
	 * @param bowColumn the bowColumn to set
	 */
	public void setBowColumn(int bowColumn) {
		this.bowColumn = bowColumn;
	}


	/**
	 * Checks if is horizontal.
	 *
	 * @return the horizontal
	 */
	public boolean isHorizontal() {
		return horizontal;
	}


	/**
	 * Sets the horizontal.
	 *
	 * @param horizontal the horizontal to set
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	/**
	 * Returns the ship type.
	 *
	 * @return Ship type
	 */
	public String getShipType(){
		return "";
	}
	
	/**
	 * Gets the length.
	 *
	 * @return the length
	 */
	public int getLength(){
		return this.length;
	}
	
	/**
	 * Ok to place ship at.
	 *
	 * @param row the row
	 * @param column the column
	 * @param horizontal the horizontal
	 * @param ocean the ocean
	 * @return true, if successful
	 */
	public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean){
		//set minimum values to bow coordinates.
		int minRow = row;
		int minColumn = column;
		
		//set maximum coordinates to stern coordinates
		int maxRow;
		int maxColumn;
		if(horizontal){
			maxRow = row;
			maxColumn = column + this.getLength() - 1;
		} else {
			maxColumn = column;
			maxRow = row + this.getLength() - 1;
		}
		
		//if maxRow OR maxColumn are larger than 9, the ship would stand over
		if(maxRow > 9 || maxColumn > 9) { return false; }
		
		//if not in maxRow or maxColumn 9, there needs to be bottom and right space tested:
		if(maxRow < 9){ maxRow++; }
		if(maxColumn < 9){ maxColumn++; }

		//TODO: remove: 
		System.out.println("For "+row+","+column+" Min: "+minRow+","+minColumn+" Max: "+maxRow+","+maxColumn);
		
		//loop through Ocean
		for(int r = minRow;r<=maxRow;r++){
			for(int c = minColumn;c<=maxColumn;c++){
				if(ocean.isOccupied(r, c)){
					//as soon as the first occupied space is found, stop looping and return false
					return false;
				}
			}
		}//END loop through Ocean
		
		//No occupying ships found, ok to place ship
		return true;
	}
	
	/**
	 * Place ship at.
	 *
	 * @param row the row
	 * @param column the column
	 * @param horizontal the horizontal
	 * @param ocean the ocean
	 */
	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean){

			this.setBowColumn(column);
			this.setBowRow(row);
			this.setHorizontal(horizontal);

		
		//TODO add to ocean array
		
		
	}
	
	/**
	 * Shoot at.
	 *
	 * @param row the row
	 * @param column the column
	 * @return true, if successful
	 */
	public boolean shootAt(int row, int column){
		for(int i=0; i <= this.getLength()-1; i++){
			if(this.isHorizontal()){
				//check row values
				if(this.getBowRow()+i==row && this.getBowColumn() == column){
					this.hit[i] = true;
					return true;
				}	
			} else {
				//check column values
				if(this.getBowRow()==row && this.getBowColumn()+i == column){
					this.hit[i] = true;
					return true;
				}
			}//END else isHorizontal
		}//END For loop
		return false;
	}
	
	/**
	 * Checks if is sunk.
	 *
	 * @return true, if is sunk
	 */
	public boolean isSunk(){
		//TODO return true if all (length) elements of ship array are TRUE
		return false;
	}
	
	
	/**
	 * Checks if is ship.
	 * This will always return true for a real ship
	 *
	 * @return true, if is ship
	 */
	public boolean isShip(){
		return true;
	}
	
}
