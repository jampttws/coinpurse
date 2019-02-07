package coinpurse.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import coinpurse.*;
import coinpurse.strategy.GreedyWithdraw;
import coinpurse.strategy.RecursiveWithdraw;
import coinpurse.strategy.WithdrawStrategy;

/**
 * Test the WithdrawStrategy with JUnit.
 * @author Tanasorn Tritawisup
 *
 */
public class WithdrawTest {
	
	private WithdrawStrategy strategy;
	private List<Valuable> list;
	double balance = 0;
	
	/** tolerance for comparing two double values */
	private static final double TOL = 1.0E-6;
	
	/**
	 * Code to run before each test. Setup the "test fixture"
	 */
	@Before
	public void setUp(){
		strategy = new RecursiveWithdraw();
		list = new ArrayList<>();
	}
	
	public double getBalance(){
		for(Valuable v : list) balance += v.getValue();
	    return balance;
	}
	
	/**Make a money with currency "Baht".*/
	public Money makeMoney(double value){
		return new Money(value, "Baht");
	}
	
	/**Add one money and remove it.*/
   @Test
   public void testSimpleWithdraw(){
	   list.add(makeMoney(10));	   
	   list = strategy.withdraw(makeMoney(10), list);
	   assertEquals(10, getBalance(), TOL);
   }
   
   /**Add many money and remove some.*/
   @Test 
   public void testWithdrawSomeValue(){
	   list.add(makeMoney(10));
	   list.add(makeMoney(5));
	   list.add(makeMoney(500));
	   list.add(makeMoney(20));
	   list = strategy.withdraw(makeMoney(505), list);
	   
	   assertEquals(505, getBalance(), TOL);
   }
   
   /**Remove some money with advance type.*/
   @Test
   public void testAdvanceWithdraw(){
	   list.add(makeMoney(5));
	   list.add(makeMoney(2));
	   list.add(makeMoney(2));
	   list.add(makeMoney(10));
	   list.add(makeMoney(2)); 
	   
	   list = strategy.withdraw(makeMoney(16), list);
	   assertFalse(list.contains(makeMoney(5)));
   }
   
   /**Remove money more than in the list.*/
   @Test 
   public void testOverWithdraw(){
	   list.add(makeMoney(2));
	   list.add(makeMoney(2));
	   list.add(makeMoney(5));
	   list = strategy.withdraw(makeMoney(10), list);
	   assertNull(list);
   }
   
   /**Impossible to withdraw.*/
   @Test 
   public void testImpossibleWithdraw(){
	   list.add(makeMoney(50));
	   list = strategy.withdraw(makeMoney(20), list);
	   assertNull(list);
   }
   
   
   @Test
   public void testStrategyWithdraw(){
	   list.add(makeMoney(20));
	   list.add(makeMoney(10));
	   list.add(makeMoney(5));
	   List temp = strategy.withdraw(makeMoney(20), list);
	   assertTrue(list.contains(makeMoney(20)));
   }
   
   
   

}
