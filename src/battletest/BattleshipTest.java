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
		tanker.placeShipAt(2, 4, false, water);

		assertEquals("Ship placed in incorrect row",2,tanker.getBowRow());
		assertEquals("Ship placed in incorrect column",4,tanker.getBowColumn());
		assertEquals("Ship not horizontal",false,tanker.isHorizontal());
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
		tanker.placeShipAt(2, 4, true, water);

		assertEquals("Ship placed in incorrect row",2,tanker.getBowRow());
		assertEquals("Ship placed in incorrect column",4,tanker.getBowColumn());
		assertEquals("Ship not horizontal",true,tanker.isHorizontal());
		assertEquals("Ship too short!",4,tanker.getLength());
		
		assertEquals("Shot at bow",true,tanker.shootAt(2, 4));
		assertEquals("Shot at bow+1",true,tanker.shootAt(2, 5));
		assertEquals("Shot at bow+2",true,tanker.shootAt(2, 6));
		assertEquals("Shot at bow+3",true,tanker.shootAt(2, 7));
		
		assertEquals("Shot at bow+4",false,tanker.shootAt(2, 8));
		
		assertEquals("Should have missed",false,tanker.shootAt(4, 2));
		
	}
	
	@Test
	public void okToPlaceShipInEmptyOcean(){
		Ocean water = new Ocean();
		Ship tanker = new Battleship();
		
		//Testing top corner
		assertEquals("Place 0,0 horizontal",true,tanker.okToPlaceShipAt(0, 0, true, water));
		assertEquals("Place 0,0 vertical",true,tanker.okToPlaceShipAt(0, 0, false, water));
		
		//Testing top edge
		assertEquals("Place 0,1 horizontal",true,tanker.okToPlaceShipAt(0, 1, true, water));
		
		//Testing standing over
		assertEquals("Place 4,8 horizontal",false,tanker.okToPlaceShipAt(4, 8, true, water));
		assertEquals("Place 7,2 vertical",false,tanker.okToPlaceShipAt(7, 2, false, water));
		
		//Testing top right corner:
		assertEquals("Place 0,6 horizontal",true,tanker.okToPlaceShipAt(0, 6, true, water));
		assertEquals("Place 0,9 vertical",true,tanker.okToPlaceShipAt(0, 9, false, water));
		
		//Testing bottom left corner:
		assertEquals("Place 9,0 horizontal",true,tanker.okToPlaceShipAt(9, 0, true, water));
		assertEquals("Place 6,0 vertical",true,tanker.okToPlaceShipAt(6, 0, false, water));
		
		//Testing bottom right corner:
		assertEquals("Place 9,6 horizontal",true,tanker.okToPlaceShipAt(9, 6, true, water));
		assertEquals("Place 6,9 vertical",true,tanker.okToPlaceShipAt(6, 9, false, water));
		
	}
	
	
	@Test
	public void okToPlaceShipInFullOcean(){
		Ocean water = new Ocean();
		Ship block = new Battleship();
		Ship tanker = new Battleship();
		
		//place blocking ship
		block.placeShipAt(1, 6, false, water);
		
		//Testing horizontals
		assertEquals("Place 0,1 horizontal",true,tanker.okToPlaceShipAt(0, 1, true, water));
		assertEquals("Place 0,6 horizontal",false,tanker.okToPlaceShipAt(0, 6, true, water));
		assertEquals("Place 2,1 horizontal",true,tanker.okToPlaceShipAt(2, 1, true, water));
		assertEquals("Place 2,6 horizontal",false,tanker.okToPlaceShipAt(2, 6, true, water));
		assertEquals("Place 4,4 horizontal",false,tanker.okToPlaceShipAt(4, 4, true, water));
		assertEquals("Place 5,2 horizontal",false,tanker.okToPlaceShipAt(5, 2, true, water));
		assertEquals("Place 6,4 horizontal",true,tanker.okToPlaceShipAt(6, 4, true, water));
		
		
	}
	
	@Test
	public void testIsSunk(){
		Ocean water = new Ocean();
		Ship tanker = new Battleship();	

		tanker.placeShipAt(1, 6, true, water);
		
		tanker.shootAt(1, 6);
		tanker.shootAt(2, 6);
		tanker.shootAt(3, 6);
		tanker.shootAt(4, 6);
		
		assertEquals("check Sunk",false,tanker.isSunk());
	}
	
	@Test
	public void toStringTest(){
		Ocean water = new Ocean();
		Ship tanker = new Battleship();	
	
		tanker.placeShipAt(1, 6, false, water);
		assertEquals("toString no shot",".",tanker.toString());
		
		tanker.shootAt(2, 6);
		assertEquals("toString 1 shot","S",tanker.toString());
		
		tanker.shootAt(1, 6);
		tanker.shootAt(3, 6);
		tanker.shootAt(4, 6);
		assertEquals("toString 4 shot","x",tanker.toString());

	}
	
	@Test
	public void isElementHitTest(){
		Ocean water = new Ocean();
		Ship tanker = new Battleship();	
	
		tanker.placeShipAt(1, 6, false, water);
		assertEquals("element 0 not hit",false,tanker.isElementHit(1, 6));
		assertEquals("element 1 not hit",false,tanker.isElementHit(2, 6));
		assertEquals("element 2 not hit",false,tanker.isElementHit(3, 6));
		assertEquals("element 3 not hit",false,tanker.isElementHit(4, 6));
		
		tanker.shootAt(2, 6);
		assertEquals("toString 1 shot","S",tanker.toString());
		assertEquals("element 0 not hit",false,tanker.isElementHit(1, 6));
		assertEquals("element 1 hit",true,tanker.isElementHit(2, 6));
		assertEquals("element 2 not hit",false,tanker.isElementHit(3, 6));
		assertEquals("element 3 not hit",false,tanker.isElementHit(4, 6));
		
		tanker.shootAt(1, 6);
		tanker.shootAt(3, 6);
		assertEquals("element 0 hit",true,tanker.isElementHit(1, 6));
		assertEquals("element 1 hit",true,tanker.isElementHit(2, 6));
		assertEquals("element 2 hit",true,tanker.isElementHit(3, 6));
		assertEquals("element 3 not hit",false,tanker.isElementHit(4, 6));

	}
	

}
