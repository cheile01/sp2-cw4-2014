package battletest;

import static org.junit.Assert.*;

import org.junit.Test;

import battleships.EmptySea;
import battleships.Ocean;
import battleships.Ship;

public class EmptySeaTest {

	@Test
	public void creation() {
		Ocean ocean = new Ocean();
		
		Ship es = new EmptySea();
		
		ocean.addShip(es);
		
		
		assertEquals("Print 1",".",es.toString());
		assertEquals("element 0 shot at",false,es.shootAt(4, 3));
		assertEquals("Print 2","-",es.toString());
		assertEquals("element 0  hit",true,es.isElementHit(4, 3));
		
		ocean.shootAt(4, 3);
		
		Ship temp = ocean.getShipArray()[4][3];
		
		assertEquals("Print 2","-",temp.toString());
		
		
		
	}

}
