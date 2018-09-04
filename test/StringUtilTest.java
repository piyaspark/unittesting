import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests of the StringUtil methods.
 */
public class StringUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test that the method work correctly.
	 */
	@Test
	public void testIndexOf() {
		String[] fruit = {"Apple", "Banana", "Grapes"};
		assertEquals(0, StringUtil.indexOf("Apple", fruit));
	}

	/**
	 * Test that the method always return the index of first occurrence of arg.
	 */
	@Test
	public void testMultipleArg() {
		String[] fruit = {"Apple", "Apple", "Grapes"};
		assertEquals(0, StringUtil.indexOf("Apple", fruit));
		String[] fruit2 = {"Banana", "Apple", "Apple"};
		assertEquals(1,StringUtil.indexOf("Apple", fruit2));
	}

	/**
	 * The method will return -1 if arg is not in the array.
	 */
	@Test
	public void testNoArgInArray(){
		String[] fruit = {"Apple", "Banana", "Grapes"};
		assertEquals(-1,StringUtil.indexOf("Potato", fruit));
	}

	/**
	 * Test the method that can work correctly even arg is uppercase or lowercase.
	 */
	@Test
	public void testArgIgnoreCase(){
		String[] fruit = {"aPplE", "BaNaNa", "GRAPES"};
		assertEquals(0,StringUtil.indexOf("apple", fruit));
		assertEquals(1,StringUtil.indexOf("banana", fruit));
		assertEquals(2,StringUtil.indexOf("grapes", fruit));
	}

}
