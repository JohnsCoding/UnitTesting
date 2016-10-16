import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UnitConverterTest {

	UnitConverter uc;
	
	@Before
	public void setUp() throws Exception {
		uc = new UnitConverter();
	}

	@After
	public void tearDown() throws Exception {
		uc = null;
	}
	
	@Test
	public void testConvertToInches() {
		assertEquals(callConvertToInchesWhenPrivate("feet",1), 12, 0.01);
		assertEquals(callConvertToInchesWhenPrivate("yards",1), 12*3, 0.01);
		assertEquals(callConvertToInchesWhenPrivate("miles",1), 12*3*1760, 0.01);
		assertEquals(callConvertToInchesWhenPrivate("leagues",1), 12*3*1760*3, 0.01);
	}
	
	@Test
	public void testConvertFromInches() {
		assertEquals(callConvertFromInchesWhenPrivate("feet",12), 1, 0.01);
		assertEquals(callConvertFromInchesWhenPrivate("yards",12*3), 1, 0.01);
		assertEquals(callConvertFromInchesWhenPrivate("miles",12*3*1760), 1, 0.01);
		assertEquals(callConvertFromInchesWhenPrivate("leagues",12*3*1760*3), 1, 0.01);
	}
	
	public double callConvertToInchesWhenPrivate(String unitToConvertFrom, double amountToConvert) {

		double result = 0;

		try {

			Method method = uc.getClass().getDeclaredMethod("convertToInches", String.class, double.class);
			method.setAccessible(true);
			Object valueToTest = method.invoke(uc, unitToConvertFrom, amountToConvert);

			result = (Double)valueToTest;

		} catch (NoSuchMethodException e) {

			fail("Error");
			System.out.println(e.getClass());
			System.out.println(e.getMessage());

		} catch (InvocationTargetException e) {

			fail("Error");
			System.out.println(e.getClass());
			System.out.println(e.getMessage());

		} catch (IllegalAccessException e) {

			fail("Error");
			System.out.println(e.getClass());
			System.out.println(e.getMessage());
			
		}

		return result;

	}
	
	public double callConvertFromInchesWhenPrivate(String unitToConvertTo, double amountToConvert) {

		double result = 0;

		try {

			Method method = uc.getClass().getDeclaredMethod("convertFromInches", String.class, double.class);
			method.setAccessible(true);
			Object valueToTest = method.invoke(uc, unitToConvertTo, amountToConvert);

			result = (Double)valueToTest;

		} catch (NoSuchMethodException e) {

			fail("Error");
			System.out.println(e.getClass());
			System.out.println(e.getMessage());

		} catch (InvocationTargetException e) {

			fail("Error");
			System.out.println(e.getClass());
			System.out.println(e.getMessage());

		} catch (IllegalAccessException e) {

			fail("Error");
			System.out.println(e.getClass());
			System.out.println(e.getMessage());
			
		}

		return result;

	}
}
