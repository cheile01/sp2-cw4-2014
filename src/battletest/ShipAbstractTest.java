package battletest;

import static org.junit.Assert.*;

import org.junit.Test;

import battleships.Ship;

public class ShipAbstractTest {

	@Test
	public void testShip() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBowRow() {
		Ship tanker = new Ship();
		tanker.setBowRow(5);
		assertEquals("BowRow incorrect",5,tanker.getBowRow());
		
	}


	@Test
	public void testGetBowColumn() {
		Ship tanker = new Ship();
		tanker.setBowColumn(7);
		assertEquals("BowColumn incorrect",7,tanker.getBowColumn());
	}
	

	@Test
	public void testIsHorizontal() {
		Ship tanker = new Ship();
		tanker.setHorizontal(true);
		assertEquals("Ship Horizontal incorrect",true,tanker.isHorizontal());
	}

	@Test
	public void testGetShipType() {
		Ship tanker = new Ship();
		assertEquals("Ship type is incorrect","",tanker.getShipType());
		
	}

	@Test
	public void testGetLength() {
		Ship tanker = new Ship();
		assertEquals("Ship Length incorrect",0,tanker.getLength());
	}

	@Test
	public void testOkToPlaceShipAt() {
		fail("Not yet implemented");
	}

	@Test
	public void testPlaceShipAt() {
		fail("Not yet implemented");
	}

	@Test
	public void testShootAt() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsSunk() {
		fail("Not yet implemented");
	}

}
