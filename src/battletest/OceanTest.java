package battletest;

import static org.junit.Assert.*;

import org.junit.Test;

import battleships.Battleship;
import battleships.Cruiser;
import battleships.Destroyer;
import battleships.EmptySea;
import battleships.Ocean;
import battleships.Ship;
import battleships.Submarine;

public class OceanTest {

	@Test
	public void testOcean() {
		Ocean water = new Ocean();
		
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
	
	
	
	@Test
	public void gameOverTest1() {
		Ocean water = new Ocean();
		Ship block = new Battleship();
		
		block.placeShipAt(1, 6, false, water);
		
		assertEquals("check if ship is not sunk",false,block.isSunk());
		assertEquals("Game should go on",false,water.isGameOver());
		
		//shoot at ship
		
		assertEquals("Shoot at 1,6",true,block.shootAt(1, 6));
		assertEquals("Shoot at 2,6",true,block.shootAt(2, 6));
		assertEquals("Shoot at 3,6",true,block.shootAt(3, 6));
		
		//ship is almost sunk, checking if status is still correct.
		
		assertEquals("check if ship is not sunk",false,block.isSunk());
		assertEquals("Game should go on",false,water.isGameOver());
		
		
		assertEquals("Shoot at 4,6",true,block.shootAt(4, 6));

		//ship should be sunk now
		assertEquals("check if ship is sunk",true,block.isSunk());
		assertEquals("Game should be over",true,water.isGameOver());

	}
	
	@Test
	public void gameOverTest2() {
		//Testing multiple ships
		Ocean water = new Ocean();
		Ship bs = new Battleship();
		Ship c1 = new Cruiser();
		Ship d1 = new Destroyer();
		Ship s1 = new Submarine();
		Ship s2 = new Submarine();
		
		bs.placeShipAt(1, 6, false, water);
		c1.placeShipAt(0, 0, true, water);
		d1.placeShipAt(2, 1, false, water);
		s1.placeShipAt(7, 2, false, water);
		s2.placeShipAt(8, 5, false, water);
		
		assertEquals("check if bs is not sunk",false,bs.isSunk());
		assertEquals("check if c1 is not sunk",false,c1.isSunk());
		assertEquals("check if d1 is not sunk",false,d1.isSunk());
		assertEquals("check if s1 is not sunk",false,s1.isSunk());
		assertEquals("check if s2 is not sunk",false,s2.isSunk());
		assertEquals("Game should go on",false,water.isGameOver());
		
		//shoot at ship
		
		assertEquals("Shoot at 1,6",true,bs.shootAt(1, 6));
		assertEquals("Shoot at 2,6",true,bs.shootAt(2, 6));
		assertEquals("Shoot at 3,6",true,bs.shootAt(3, 6));
		assertEquals("Shoot at 0,0",true,c1.shootAt(0, 0));
		assertEquals("Shoot at 0,1",true,c1.shootAt(0, 1));
		assertEquals("Shoot at 2,1",true,d1.shootAt(2, 1));
		assertEquals("Shoot at 7,2",true,s1.shootAt(7, 2));
		
		//ship is almost sunk, checking if status is still correct.
		
		assertEquals("check if bs is not sunk",false,bs.isSunk());
		assertEquals("check if c1 is not sunk",false,c1.isSunk());
		assertEquals("check if d1 is not sunk",false,d1.isSunk());
		assertEquals("check if s1 is sunk",true,s1.isSunk());
		assertEquals("check if s2 is not sunk",false,s2.isSunk());
		assertEquals("Game should go on",false,water.isGameOver());
		
		
		assertEquals("Shoot at 4,6",true,bs.shootAt(4, 6));
		assertEquals("Shoot at 0,2",true,c1.shootAt(0, 2));
		assertEquals("Shoot at 3,1",true,d1.shootAt(3, 1));
		assertEquals("Shoot at 8,5",true,s2.shootAt(8, 5));

		//ship should be sunk now
		assertEquals("check if ship is sunk",true,bs.isSunk());
		assertEquals("Game should be over",true,water.isGameOver());

	}
	
	
	@Test
	public void shootAt1() {
		Ocean water = new Ocean();
		Ship block = new Battleship();
		
		block.placeShipAt(1, 6, false, water);
		
		assertEquals("Checking hits",0,water.getHitCount());
		assertEquals("Checking shots",0,water.getShotsFired());
		assertEquals("Should be 0 sunk ships",0,water.getShipsSunk());
		
		//shoot at ocean
		
		assertEquals("Shoot at 1,6",true,water.shootAt(1, 6));
		assertEquals("Shoot at 2,6",true,water.shootAt(2, 6));
		assertEquals("Shoot at 3,6",true,water.shootAt(3, 6));
		
		assertEquals("Checking shots",3,water.getShotsFired());
		assertEquals("Checking hits",3,water.getHitCount());
		
		//shoot at water
		
		assertEquals("Shoot at 1,7",false,water.shootAt(1, 7));
		assertEquals("Shoot at 2,5",false,water.shootAt(2, 5));
		assertEquals("Shoot at 8,8",false,water.shootAt(8, 8));
		
		assertEquals("Checking shots",6,water.getShotsFired());
		assertEquals("Checking hits",3,water.getHitCount());
		
		//shoot at same again
		assertEquals("Shoot at 3,6",true,water.shootAt(3, 6));
		assertEquals("Shoot at 1,7",false,water.shootAt(1, 7));
		
		assertEquals("Checking shots",8,water.getShotsFired());
		assertEquals("Checking hits",4,water.getHitCount());
		
		//sink ship
		assertEquals("Shoot at 4,6",true,water.shootAt(4, 6));

		//ship should be sunk now
		assertEquals("check if ship is sunk",true,block.isSunk());
		assertEquals("Should be 1 sunk ship",1,water.getShipsSunk());

		//add another ship and sink it:
		Submarine sub = new Submarine();
		sub.placeShipAt(2, 2, true, water);
		water.shootAt(2, 2);
		assertEquals("Should be 2 sunk ships",2,water.getShipsSunk());
		
		assertEquals("Game should be over",true,water.isGameOver());

	}
	
	
	@Test
	public void oceanPrint() {
		Ocean water = new Ocean();
		System.out.println();
		System.out.println("Ocean print test");
		System.out.println();
		
		water.print();
		
	}
	
	@Test
	public void oceanPrint2() {
		Ocean water = new Ocean();
		Ship bs = new Battleship();
		Ship c1 = new Cruiser();
		Ship d1 = new Destroyer();
		Ship s1 = new Submarine();
		Ship s2 = new Submarine();
		
		bs.placeShipAt(1, 6, false, water);
		c1.placeShipAt(0, 0, true, water);
		d1.placeShipAt(2, 1, false, water);
		s1.placeShipAt(7, 2, false, water);
		s2.placeShipAt(8, 5, false, water);
		
		water.shootAt(1, 6);
		water.shootAt(2, 6);
		water.shootAt(0, 0);
		water.shootAt(0, 1);
		water.shootAt(0, 2);
		
		System.out.println();
		System.out.println("Ocean print test2");
		System.out.println();
		
		water.print();
		
	}
	
	
	

}
