package mru.tsc.test;
import mru.tsc.exceptions.NegativePrice;
import mru.tsc.model.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.tsc.model.Animal;
/**
 * 
 * This class unit tests the Animal class.
 * 
 *
 */


class AnimalTest {

	/**
	 * 
	 * this conducts the test.
	 * 
	 *
	 */

	void test() throws NegativePrice {
		String testAnimal="4774316121;Snake cube;Game Sensor;184.21;9;3;C";
		
		Animal snakeCube= new Animal(testAnimal);
		
		assertEquals(snakeCube.saveToy(),testAnimal);
	}

}
