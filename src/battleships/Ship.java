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
	
	public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean){
		//TODO check if it is ok to place ship - needs ocean array first.
		
		for(int i=0; i <= this.getLength()-1; i++){
			if(this.isHorizontal()){
				
					
			} else {
				
				
			}//END else isHorizontal
		}//END For loop
		
		return true;
	}
	
	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean){
		if(this.okToPlaceShipAt(row, column, horizontal, ocean)){
			this.setBowColumn(column);
			this.setBowRow(row);
			this.setHorizontal(horizontal);
		}
		
		//TODO add to ocean array
		
		
	}
	
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
	
	public boolean isSunk(){
		//TODO return true if all (length) elements of ship array are TRUE
		return false;
	}
	
}
