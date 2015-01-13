package battletest;

import static org.junit.Assert.*;

import org.junit.Test;

import battleships.Battleship;
import battleships.Ocean;
import battleships.Ship;

public class BattleshipTest {

	@Test
	public void testGetShipType() {
		Ship tanker = new Battleship();
		assertEquals("Ship type is incorrect","battleship",tanker.getShipType());
	}

	@Test
	public void testBattleship() {
		Ship tanker = new Battleship();
		assertEquals("Length is incorrect",4,tanker.getLength());
	}

	@Test
	public void testToString() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void testShootAt() {
		Ocean water = new Ocean();
		Ship tanker = new Battleship();
		tanker.placeShipAt(2, 4, true, water);

		assertEquals("Ship placed in incorrect row",2,tanker.getBowRow());
		assertEquals("Ship placed in incorrect column",4,tanker.getBowColumn());
		assertEquals("Ship not horizontal",true,tanker.isHorizontal());
		assertEquals("Ship too short!",4,tanker.getLength());
		
		assertEquals("Shot at bow",true,tanker.shootAt(2, 4));
		assertEquals("Shot at bow+1",true,tanker.shootAt(3, 4));
		assertEquals("Shot at bow+2",true,tanker.shootAt(4, 4));
		assertEquals("Shot at bow+3",true,tanker.shootAt(5, 4));
		
		assertEquals("Should have missed",false,tanker.shootAt(4, 2));
		
	}
	
	
	@Test
	public void testShootAt2() {
		Ocean water = new Ocean();
		Ship tanker = new Battleship();
		tanker.placeShipAt(2, 4, false, water);

		assertEquals("Ship placed in incorrect row",2,tanker.getBowRow());
		assertEquals("Ship placed in incorrect column",4,tanker.getBowColumn());
		assertEquals("Ship not horizontal",false,tanker.isHorizontal());
		assertEquals("Ship too short!",4,tanker.getLength());
		
		assertEquals("Shot at bow",true,tanker.shootAt(2, 4));
		assertEquals("Shot at bow+1",true,tanker.shootAt(2, 5));
		assertEquals("Shot at bow+2",true,tanker.shootAt(2, 6));
		assertEquals("Shot at bow+3",true,tanker.shootAt(2, 7));
		
		assertEquals("Shot at bow+4",false,tanker.shootAt(2, 8));
		
		assertEquals("Should have missed",false,tanker.shootAt(4, 2));
		
	}
	

}