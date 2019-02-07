package coinpurse.test;

import static org.junit.Assert.*;

import org.junit.Test;

import coinpurse.MalayMoneyFactory;
import coinpurse.MoneyFactory;
import coinpurse.ThaiMoneyFactory;

/**
 * Test the MoneyFactory using JUnit.
 * @author Tanasorn Tritawisup
 *
 */
public class MoneyFactoryTest {
	
	/** tolerance for comparing two double values */
	private static final double TOL = 1.0E-6;
	
	/**test that the MoneyFactory is Singleton*/
	@Test
	public void testSingleton() {
		MoneyFactory mf1 = MoneyFactory.getInstance();
		MoneyFactory mf2 = MoneyFactory.getInstance();
		assertTrue(mf1 == mf2);
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory mf3 = MoneyFactory.getInstance();
		assertFalse(mf1 == mf3);		
	}

	/**test for ThaiMoneyFactory methods*/
	@Test
	public void testThaiMoneyFactory(){
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory mt1 = MoneyFactory.getInstance();
		MoneyFactory mt2 = MoneyFactory.getInstance();
		MoneyFactory mt3 = MoneyFactory.getInstance();
		mt1.createMoney(50);
		mt2.createMoney(50);
		assertTrue(mt1 == mt2);
		assertEquals(20, mt1.createMoney(20).getValue(), TOL);
		assertEquals(100, mt2.createMoney(100).getValue(), TOL);
		assertTrue((mt3.createMoney(10).getCurrency()).equals("Baht"));
	}
	
	/**test for MalayMoneyFactory methods*/
	@Test
	public void testMalayMoneyFactory(){
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory mm1 = MoneyFactory.getInstance();
		MoneyFactory mm2 = MoneyFactory.getInstance();
		MoneyFactory mm3 = MoneyFactory.getInstance();
		assertTrue(mm1 == mm2);
		assertEquals(0.05, mm1.createMoney(0.05).getValue(), TOL);
		assertEquals(10, mm2.createMoney(10).getValue(), TOL);
		assertTrue((mm3.createMoney(10).getCurrency()).equals("Ringgit"));
	}
	
	
}
