package mru.tsc.test;
import mru.tsc.exceptions.NegativePrice;
import mru.tsc.model.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.tsc.model.Figure;
/**
 * 
 * This class unit tests the Figure Game class.
 * 
 *
 */

class FigureTest {
	/**
	 * 
	 * This method conducts the test.
	 * 
	 *
	 */

	@Test
	void test() throws NegativePrice {
		String testFigure ="1147205649;Ninja Turtles;Gamezoid;46.15;10;6;A";
		Figure ninjaTurtle= new Figure(testFigure);
		assertEquals(testFigure, ninjaTurtle.saveToy());
	}

}
