import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestFizzBuzz {

	// @Before - Is added for us when we selected the setUp() method during the initial step. 
	// This annotation will trigger the attached method before interpreting the rest of the class
	
	public FizzBuzz fb;
	
	@Before
	public void setUp() throws Exception {
		// add in an instance of the FizzBuzz class In the setUp() method 
		fb= new FizzBuzz();
	}

	// @Test - This annotation tells JUnit to run the method as a test
	@Test
	public void test() {
		// assertNotNull is a method that check to see if the given object is not null, if it is not null, the test will pass
		assertNotNull(fb);
	}
	
	
	@Test
	public void testForFizz() {
		String result=fb.fizzBuzz(3);
		// assertTrue - will test the condition supplied, and the test will pass if the condition it true
		assertTrue(result.equals("fizz"));
	}
	
	@Test
	public void testForBuzz() {
		String result=fb.fizzBuzz(5);
		assertTrue(result.equals("buzz"));
	}
	
	@Test
	public void testForFizzFalse() {
		String result =fb.fizzBuzz(5);
		// assertFalse - will test the condition supplied, and the test will pass if the condition it false
		assertFalse(result.equals("fizz"));
	}
	
	@Test
	public void testForFizzBuzz() {
		String expected="fizzbuzz";
		String actual=fb.fizzBuzz(30);
		System.out.println("testForFizzBuzz : "+fb.fizzBuzz(30));
		// assertEquals - will compare the supplied arguments, and the test will pass if they are the same
		assertEquals(expected,actual);
	}
	
	// test number not divisible by 3 and 5
	@Test
	public void testForNumberTow() {
		String expected="2";
		String actual=fb.fizzBuzz(2);
		System.out.println("testForNumberTow : "+fb.fizzBuzz(2));
		assertEquals(expected,actual);
	}

}
