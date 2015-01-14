package battletest;

import static org.junit.Assert.*;

import org.junit.Test;

import battleships.Ocean;
import battleships.Ship;

public class ShipAbstractTest {


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
		assertEquals("Ship Length incorrect",1,tanker.getLength());
	}

	@Test
	public void testOkToPlaceShipAt() {
		
		
		
		
	}

	@Test
	public void testPlaceShipAt() {
		Ocean water = new Ocean();
		Ship tanker = new Ship();
		tanker.placeShipAt(2, 4, true, water);

		assertEquals("Ship placed in incorrect row",2,tanker.getBowRow());
		assertEquals("Ship placed in incorrect column",4,tanker.getBowColumn());
		assertEquals("Ship not horizontal",true,tanker.isHorizontal());
	}

	@Test
	public void testShootAt() {
		Ocean water = new Ocean();
		Ship tanker = new Ship();
		tanker.placeShipAt(2, 4, true, water);

		assertEquals("Ship placed in incorrect row",2,tanker.getBowRow());
		assertEquals("Ship placed in incorrect column",4,tanker.getBowColumn());
		assertEquals("Ship not horizontal",true,tanker.isHorizontal());
		
		assertEquals("Shot at bow",true,tanker.shootAt(2, 4));
		assertEquals("Should have missed",false,tanker.shootAt(4, 2));
		
		
		
	}

	@Test
	public void testIsSunk() {
		fail("Not yet implemented");
	}

}
