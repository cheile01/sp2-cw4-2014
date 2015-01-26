package battletest;

import static org.junit.Assert.*;

import org.junit.Test;

import battleships.Battleship;
import battleships.Cruiser;
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
	
	@Test
	public void printOceanTest1() {
		Ocean water = new Ocean();
		Ship cruiser = new Cruiser();
		Ship tanker = new Battleship();
		Ship empty1 = new EmptySea();
		
		cruiser.placeShipAt(2, 6, false, water);
		tanker.placeShipAt(8, 1, true, water);
		empty1.placeShipAt(2, 2, true, water);
		
		empty1.shootAt(2, 2);
		cruiser.shootAt(2, 6);
		tanker.shootAt(8, 1);
		tanker.shootAt(8, 2);
		tanker.shootAt(8, 3);
		tanker.shootAt(8, 4);
		
		Ship Ships[][] = water.getShipArray();
		
		for(int r = 0; r < 10; r++){
			for(int c = 0; c < 10; c++){
				System.out.print(Ships[r][c].getShipType().charAt(0));
			}
			System.out.println();
		}
	}
	
	@Test
	public void placeRandomTest1() {
		Ocean water = new Ocean();

		water.placeAllShipsRandomly();

		Ship Ships[][] = water.getShipArray();
		
		for(int r = 0; r < 10; r++){
			for(int c = 0; c < 10; c++){
				System.out.print(Ships[r][c].getShipType().charAt(0));
			}
			System.out.println();
		}
		System.out.println();
		
	}

}
