package battletest;

import static org.junit.Assert.*;

import org.junit.Test;

import battleships.Battleship;
import battleships.EmptySea;
import battleships.Ocean;
import battleships.Ship;

public class OceanTest {

	@Test
	public void testOcean() {
		Ocean water = new Ocean();
		
	}

	@Test
	public void testGetHitCount() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetShipsSunk() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetShotsFired() {
		//fail("Not yet implemented");
	}

	@Test
	public void occupiedTest() {
		Ocean water = new Ocean();
		Ship block = new Battleship();
		
		//place blocking ship
		block.placeShipAt(2, 6, false, water);
		
		assertEquals("Check 1,6",false,water.isOccupied(1, 6));		
		assertEquals("Check 2,6",true,water.isOccupied(2, 6));		
		
	}
	
	@Test
	public void testShipPlacement() {
		Ocean water = new Ocean();
		Ship block = new Battleship();
		Ship empty = new EmptySea();
		
		//place blocking ship
		block.placeShipAt(2, 6, false, water);
		
		assertEquals("Check 1,6",empty.toString(),water.getShipArray()[1][6].toString());
		assertEquals("Check 2,6",block.toString(),water.getShipArray()[2][6].toString());
		assertEquals("Check 3,6",block.toString(),water.getShipArray()[3][6].toString());
		assertEquals("Check 4,6",block.toString(),water.getShipArray()[4][6].toString());
		assertEquals("Check 5,6",block.toString(),water.getShipArray()[5][6].toString());
		assertEquals("Check 6,6",empty.toString(),water.getShipArray()[6][6].toString());
	}
	

}
