package mru.tsc.test;
import mru.tsc.exceptions.NegativePrice;
import mru.tsc.model.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.tsc.model.Puzzle;
/**
 * 
 * This class unit tests the Puzzle class.
 * 
 *
 */

class PuzzleTest {
	/**
	 * 
	 * This conducts the test.
	 * 
	 *
	 */

	@Test
	void test() throws NegativePrice {
		String testPuzzle="5239019250;Nob Yoshigahara Puzzle Design Competition;Game Zombie;67.20;5;3;M";
		Puzzle zombie= new Puzzle(testPuzzle);
		assertEquals(testPuzzle,zombie.saveToy());
	}

}
