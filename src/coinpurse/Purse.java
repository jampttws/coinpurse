package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import coinpurse.strategy.GreedyWithdraw;
import coinpurse.strategy.RecursiveWithdraw;
import coinpurse.strategy.WithdrawStrategy;


/**
 *  A purse contains coins and banknote.
 *  You can insert money, withdraw money, check the balance,
 *  and check if the purse is full.
 *  
 *  @author Tanasorn Tritawisup
 */

public class Purse {
    /** Collection of objects in the purse. */
    private static List<Valuable> money;
	
    /** Capacity is maximum number of items the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    
    private Comparator<Valuable> comparator = new ValueComparator();
    
    /**Type of WithdrawStrategy*/
    private WithdrawStrategy strategy;
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of money you can put in purse.
     */
    public Purse( int capacity ) {
    	this.capacity = capacity;
    	money = new ArrayList<Valuable>(capacity);
    	strategy = new GreedyWithdraw();
    }

    /**
     * Count and return the number of coins in the purse.
     * This is the number of coins, not their value.
     * @return the number of coins in the purse.
     */
    public int count() { 
    	return money.size(); 
    }
    
    /** 
     *  Get the total value of all items in the purse.
     *  @return the total value of items in the purse.
     */
    public static double getBalance() {
    	double totalValue = 0.0;
    	for(Valuable v : money) totalValue += v.getValue();
    	return totalValue;
	}

    
    /**
     * Return the capacity of the purse.
     * @return the capacity.
     */
    public int getCapacity() { 
		return capacity; 
	}
    
    /** 
     *  Test whether the purse is full.
     *  The purse is full if number of items in purse equals
     *  or greater than the purse capacity.
     *  @return true if purse is full.
     */
    public boolean isFull() {
        return count() >= capacity;
    }

    /** 
     * Insert a value into the purse.
     * The value is only inserted if the purse has space for it
     * and the value is positive.
     * @param value is a Valuable interface to insert into purse
     * @return true if value inserted, false if can't insert
     */
    public boolean insert( Valuable value ) {
        if(isFull() || value.getValue() <= 0) return false;  
        else {
        	money.add(value);
        	return true;
        }	
    }
    
    /**
     * Withdraw the amount, using only items that have 
     * the same currency as the parameter(amount). 
     * amount must not be null and amount.getValue() > 0.
     * @param amount
     * @return array of Valuable class for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw(Valuable amount ) {
    	
    	setWithdrawStrategy(new RecursiveWithdraw());

       	List<Valuable> withdraw = strategy.withdraw(amount, money);
  	
       	if (withdraw == null) return null;
       	
		for(Valuable v : withdraw) money.remove(v);
		
		Valuable[] withdrawArray = new Valuable[withdraw.size()];
        return withdraw.toArray(withdrawArray);
        
	}
    
    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of Valuable withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of Valuable class for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw( double amount ) {
    	Money amountM = new Money(amount, "Baht");
    	return withdraw(amountM);       
	}

    /** 
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     */
    @Override 
    public String toString() {
    	    return money.toString();
    }
	
    /**
     * Set the withdraw strategy.
     * @param strategy is a withdraw strategy that you want to set.
     */
	public void setWithdrawStrategy(WithdrawStrategy strategy){
		this.strategy = strategy;
	}

}
