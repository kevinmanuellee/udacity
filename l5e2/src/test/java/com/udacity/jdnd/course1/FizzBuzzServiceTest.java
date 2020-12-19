package com.udacity.jdnd.course1;

import com.udacity.jdnd.course1.service.FizzBuzzService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FizzBuzzServiceTest {

	@Test
	void testFizzBuzz(){
		FizzBuzzService fbs = new FizzBuzzService();

		// check non-divisible numbers return themselves
		assertEquals("1", fbs.fizzBuzz(1));
		assertEquals("47", fbs.fizzBuzz(47));
		assertEquals("121", fbs.fizzBuzz(121));

		// check numbers divisible by 3
		assertEquals("Fizz", fbs.fizzBuzz(3));
		assertEquals("Fizz", fbs.fizzBuzz(333));

		//check numbers divisible by 5
		assertEquals("Buzz", fbs.fizzBuzz(5));
		assertEquals("Buzz", fbs.fizzBuzz(85));

		//check numbers divisible by 3 and 5
		assertEquals("FizzBuzz", fbs.fizzBuzz(15));
		assertEquals("FizzBuzz", fbs.fizzBuzz(75));

		//check invalid inputs
		assertThrows(IllegalArgumentException.class, () -> fbs.fizzBuzz(0));
		assertThrows(IllegalArgumentException.class, () -> fbs.fizzBuzz(-1));

		//-----------------------------------------------------------------------------
	}

	@Test
	void testBuzzFizz(){
		FizzBuzzService fbs = new FizzBuzzService();

		// check non-divisible numbers return themselves
		assertEquals(1, fbs.buzzFizz("1", 0));
		assertEquals(47, fbs.buzzFizz("47", 0));
		assertEquals(121, fbs.buzzFizz("121", 0));

		// check numbers divisible by 3
		assertEquals(3, fbs.buzzFizz("Fizz", 1));
		assertEquals(333, fbs.buzzFizz("Fizz", 111));

		//check numbers divisible by 5
		assertEquals(5, fbs.buzzFizz("Buzz", 1));
		assertEquals(85, fbs.buzzFizz("Buzz", 17));

		//check numbers divisible by 3 and 5
		assertEquals(15, fbs.buzzFizz("FizzBuzz", 1));
		assertEquals(75, fbs.buzzFizz("FizzBuzz", 5));

		//check invalid inputs
//		assertThrows(IllegalArgumentException.class, () -> fbs.buzzFizz("FizzBuzz", 0));
//		assertThrows(IllegalArgumentException.class, () -> fbs.buzzFizz("FizzBuzz", -1));
//		assertThrows(IllegalArgumentException.class, () -> fbs.buzzFizz("FizBuzz", 1));
	}
}
