package mru.tsc.test;
import mru.tsc.model.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.tsc.model.BoardGame;
/**
 * 
 * This class unit tests the Board Game class.
 * 
 *
 */

class BoardGameTest {

	@Test
	/**
	 * 
	 * This conducts the test
	 * 
	 *
	 */

	void test() {
		String testGame ="8441793657;Solarquest;Game Orc;112.00;6;7;2-8;Miller Knights";
		BoardGame gameOrc = null;
		try {
			gameOrc = new BoardGame(testGame);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(testGame, gameOrc.saveToy());
	}

}
